package com.ecotourism.oms.oms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.exception.MyException;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.dao.RefundStrategyDetailsDao;
import com.ecotourism.oms.oms.dao.SpotTicketDao;
import com.ecotourism.oms.oms.domain.*;
import com.ecotourism.oms.oms.service.CommonService;
import com.ecotourism.oms.oms.service.ModifyOrderService;
import com.ecotourism.oms.oms.service.OrderInfoService;
import com.ecotourism.oms.oms.service.OrderRefundTicketService;
import com.ecotourism.oms.product.dao.PriceStockDao;
import com.ecotourism.oms.product.domain.PriceStockDO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ModifyOrderServiceImpl implements ModifyOrderService {
    private static final Logger logger = LoggerFactory.getLogger(ModifyOrderServiceImpl.class);
    @Autowired
    CommonService commonService;
    @Autowired
    OrderInfoService orderInfoService;
    @Autowired
    SpotTicketDao spotTicketDao;
    @Autowired
    RefundStrategyDetailsDao refundStrategyDetailsDao;
    @Autowired
    OrderRefundTicketService orderRefundTicketService;
    @Autowired
    PriceStockDao priceStockDao;
    @Override
    @Transactional
    public String modifyOrder(RequestVo requestVo) {
        long now = System.currentTimeMillis();
        ResultMsg resultMsg = orderInfoService.checkUpdateData(requestVo);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return  commonService.getError(resultMsg.getReturn_code(),resultMsg.getReturn_msg());
        resultMsg =  orderInfoService.allowUpdate(requestVo);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())) return  commonService.getError(resultMsg.getReturn_code(),resultMsg.getReturn_msg());
        List<OrderSpotDO> list = (List<OrderSpotDO>) resultMsg.getObj();
        for(OrderSpotDO orderSpotDO:list){
            orderSpotDO.setOrderDistributor(requestVo.getDistributionNo());
            orderInfoService.updateOrder(orderSpotDO,requestVo);
        }
        list = orderInfoService.getCancelOrder(requestVo,"modify");
//        clientHelperOrderUpdateService.updateSecondOrder(list,pdUpdate);
//        clientHelperOrderUpdateService.sendUpdateNoticeToLocal(list);
//        commonService.saveLog(pdUpdate,ApiEnum.updateOrder);
        List<PageData> buildList = new ArrayList<>();
        buildList =  commonService.buildOrdersInfo(list,requestVo.getApiVersion(),"022002");
        logger.debug("修改订单接口，损耗时间==> "+(System.currentTimeMillis()-now));
        return commonService.getResultOk(requestVo,buildList);
    }

    @Override
    @Transactional
    public String refundOrder(RequestVo requestVo, String orderType) {
        ResultMsg resultMsg = commonService.getParamsOrderNo(requestVo);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())){
            return commonService.getError(resultMsg.getReturn_code(), resultMsg.getReturn_msg());
        }
        resultMsg = orderInfoService.allowRefund(requestVo,resultMsg);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())){
            return commonService.getError(resultMsg.getReturn_code(), resultMsg.getReturn_msg());
        }
        PageData resultData = (PageData) resultMsg.getObj();
        List<OrderSpotDO> orders = (List<OrderSpotDO>) resultData.get("orders");
        boolean  auditing = false;//是否需要审核
        for (OrderSpotDO order : orders) {
            String refund_status = order.getRefundStatus();
            if("002004".equals(refund_status)){//需要审核
                auditing = true;
            }
        }
        orderRefundTicketService.refundTicked(orders,requestVo);//去景区退票
        List<OrderSpotDO> list = orderInfoService.getCancelOrder(requestVo,"refund");
        //clientHelperOrderRefundService.refundOrderSecond(list,buildPd);//修改子订单退票状态
        buildRefundMoney(list,requestVo);//计算退票金额
        //退票退库存
        updateProductStock(list);//减库存
        if(auditing){
            List<PageData> buildList = commonService.buildOrdersInfo(list,requestVo.getApiVersion(),"022002");
            commonService.saveLog(list,ApiEnum.refundRetirementAudit);//保持退票审核日志
            return commonService.getResultOk(requestVo,buildList);
        }
        orderRefundTicketService.saveRefundTicketLog(list,requestVo);//保存退票记录
        List<PageData> buildList = commonService.buildOrdersInfo(list,requestVo.getApiVersion(),"022002");
        commonService.saveLog(list,ApiEnum.refundOrder);//保持退票日志

        return commonService.getResultOk(requestVo,buildList);
    }

    @Override
    @Transactional
    public String cancelOrder(RequestVo requestVo, String orderType) {
        ResultMsg resultMsg = commonService.getParamsOrderNo(requestVo);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())){
            return commonService.getError(resultMsg.getReturn_code(), resultMsg.getReturn_msg());
        }
        resultMsg = orderInfoService.allowCancel(requestVo,resultMsg);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())){
            return commonService.getError(resultMsg.getReturn_code(), resultMsg.getReturn_msg());
        }
        orderInfoService.cancelOrder(requestVo,resultMsg);
        Map<String, Object> map = new HashMap<>();
        map.put("orderDistributor",requestVo.getDistributionNo());
        map.put("orderNo",JSONObject.parseObject(requestVo.getData()).getString("orderNo"));
        List<OrderSpotDO> list = orderInfoService.getCancelOrder(requestVo,"cancel");
        List<PageData> buildList = commonService.buildOrdersInfo(list,requestVo.getApiVersion(),"022002");
        commonService.saveLog(list,ApiEnum.cancelOrder);
        return commonService.getResultOk(requestVo,buildList);
    }

    /**
     * 根据退票策略计算退票金额
     * @param list
     * @param requestVo
     * @throws Exception
     */
    public void buildRefundMoney(List<OrderSpotDO> list,RequestVo requestVo){
        for (OrderSpotDO pd : list) {
            String product_no = pd.getProductNo();
            SpotTicketDO product = spotTicketDao.get(product_no);
            CooperationDistributionDO cache = requestVo.getCooperationDistributionDO();
            BigDecimal total_amount = pd.getTotalAmount();
            String WHETHER_USE_CAR = cache.getWhetherUseCar();
            if("0".equals(WHETHER_USE_CAR)){
                pd.setRefundAmount(total_amount);
                pd.setCounterFee(new BigDecimal(0));
            }else if("1".equals(WHETHER_USE_CAR)){
                String PRODUCT_TYPE = product.getProductType();//产品类型
                if("043003".equals(PRODUCT_TYPE)) {//车票+景区门票
                    BigDecimal totalAmount = total_amount;
                    BigDecimal isTransit = new BigDecimal(0);
                    if(null != pd.getIsTransit()){
                        isTransit = new BigDecimal(pd.getIsTransit());
                    }
                    BigDecimal car_price = new BigDecimal(0);
                    if(StringUtils.isNotBlank(product.getCarFee())){
                        car_price = new BigDecimal(product.getCarFee());
                    }
                    if(car_price == null){
                        car_price = cache.getCarPrice();
                    }
                    BigDecimal buckleAmount = new BigDecimal(pd.getOrderQuantity()).multiply(car_price);
                    buckleAmount = buckleAmount.multiply(isTransit);
                    pd.setRefundAmount(totalAmount.subtract(buckleAmount));
                    pd.setCounterFee(buckleAmount);
                }else{
                    pd.setRefundAmount(total_amount);
                    pd.setCounterFee(new BigDecimal(0));
                }
            }
            String whether_refund_strategy = product.getWhetherRefundStrategy();
            if("1".equals(whether_refund_strategy)){
                String refund_strategy_detail_no = product.getRefundStrategyDetailNo();
                if(StringUtils.isNotBlank(refund_strategy_detail_no)){
                    RefundStrategyDetailsDO refundStrategyDetailsDO =  refundStrategyDetailsDao.getRefundStrategy(product.getRefundStrategyDetailNo());//获取退票策略明细
                    BigDecimal refundAmount = pd.getRefundAmount();
                    Float REFUND_PROPORTION = refundStrategyDetailsDO.getRefundProportion();//退票比例
                    BigDecimal subtract = new BigDecimal(REFUND_PROPORTION).multiply(refundAmount).setScale(2,BigDecimal.ROUND_UP);
                    //refundAmount = refundAmount.subtract(totalAmount.subtract(subtract));
                    pd.setRefundAmount(subtract);
                }
            }
            BigDecimal refundAmount = pd.getRefundAmount();
            if(refundAmount.compareTo(new BigDecimal(0))==-1){
                throw new MyException(commonService.getError(ApiEnum.refundOrderError.code,"退款金额不能为负!"));
            }
        }
    }

    public void updateProductStock(List<OrderSpotDO> list){
        for(OrderSpotDO orderSpotDO:list){
            SpotTicketDO product = spotTicketDao.get(orderSpotDO.getProductNo());
            if("1".equals(product.getWhetherLimitStock())){
                int stockType = product.getStockType();
                if(stockType ==1){ //限制总库存
                    ProductStock productStock = new ProductStock();
                    productStock.setProductNo(product.getProductNo());
                    productStock.setSaleNum(orderSpotDO.getOrderQuantity());
                    spotTicketDao.updateRefundStock(productStock);
                }else if(stockType ==2) { //限制日库存
                    PriceStockDO priceStock = new PriceStockDO();
                    priceStock.setSaleNum(orderSpotDO.getOrderQuantity());
                    priceStock.setProductNo(product.getProductNo());
                    priceStock.setDate(orderSpotDO.getPlayTime());
                    priceStockDao.updateRefundStock(priceStock);
                }
            }
        }
    }
}
