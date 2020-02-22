package com.ecotourism.api.api.service.impl;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.common.CommonOrderRequest;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.domain.order.create.AddressParams;
import com.ecotourism.api.api.domain.order.create.OrderProductData;
import com.ecotourism.api.api.domain.order.create.OrderRequestParam;
import com.ecotourism.api.api.domain.order.query.QueryOrderListRequestParams;
import com.ecotourism.api.api.domain.order.query.QueryOrderOneRequestParams;
import com.ecotourism.api.api.domain.order.refund.RefundElectronic;
import com.ecotourism.api.api.domain.order.refund.RefundMoneyDo;
import com.ecotourism.api.api.domain.order.refund.RefundOrderParams;
import com.ecotourism.api.api.domain.order.refund.RefundRequestParams;
import com.ecotourism.api.api.domain.procuct.ProductRequestParam;
import com.ecotourism.api.api.service.ClientAlipayService;
import com.ecotourism.api.api.service.ClientOrderService;
import com.ecotourism.api.api.service.ClientWechatService;
import com.ecotourism.api.api.util.DateUtil;
import com.ecotourism.api.api.util.MakeOrderNum;
import com.ecotourism.api.application.domain.ApplicationOrderDO;
import com.ecotourism.api.application.domain.OrderDo;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.application.service.ApplicationOrderService;
import com.ecotourism.api.common.service.DictService;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.StringUtils;
import com.ecotourism.api.common.utils.Tools;
import com.ecotourism.api.oms.domain.RefundFromOmsDo;
import com.ecotourism.api.oms.service.OmsApiService;
import com.ecotourism.api.product.domain.ProductDO;
import com.ecotourism.api.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 说明：创建订单
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 9:39
 **/
@Service
public class ClientOrderServiceImpl implements ClientOrderService{
    @Autowired
    private ApplicationOrderService applicationOrderService;
    @Autowired
    private OmsApiService omsApiService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DictService dictService;
    @Autowired
    private ClientWechatService clientWechatService;
    @Autowired
    private ClientAlipayService clientAlipayService;

    /**
     * @Description 创建应用订单
     * @Author scotte
     * @Date 2018/8/23 10:23
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    @Transactional
    public R createOrder(RequestVo requestVo){
        OrderRequestParam param = (OrderRequestParam) requestVo.getParamsVo();
        String applicationNo = requestVo.getApplicationNo();
        String orderNo = applicationOrderService.getOrderNo(applicationNo);
        param.setOrderNo(orderNo);
        R r = omsApiService.checkCreateOrder(param, requestVo.getApplicationDO().getDistribution());
        if(!r.isSuccess()){
            return r;
        }
        List<OrderProductData> datas = param.getData();
        String time = DateUtil.getTime();
        List<ApplicationOrderDO> orders = new ArrayList<>();
        ApplicationOrderDO order = new ApplicationOrderDO();
        order.setApplicationNo(applicationNo);
        order.setOrderNo(orderNo);
        String openId = param.getOpenId();
        order.setOpenId(openId);
        order.setPayStatus("005002");//未支付
        order.setOrderStatus("004001");//未消费
        order.setRefundStatus("002001");//未退款
        order.setPurchaseTime(time);
        order.setPushUserNo(param.getPushUserNo());
        List<AddressParams> addresses = new ArrayList<>();
        for (OrderProductData data : datas) {
            ApplicationOrderDO orderVo = new ApplicationOrderDO();
            BeanUtils.copyProperties(order,orderVo);
            BeanUtils.copyProperties(data,orderVo);
            String productNo = data.getProductNo();
            orderVo.setProductNo(productNo);
            String subOrderNo = MakeOrderNum.makeOrderNum();
            orderVo.setSubOrderNo(subOrderNo);
            ProductDO productDO = productService.getByPriceStock(productNo,data.getPlayTime());
            if(productDO==null) return R.error(ApiEnum.productNull.code,ApiEnum.productNull.msg);
            orderVo.setProductName(productDO.getProductName());
            BigDecimal payPrice = productDO.getPayPrice().setScale(2);
            orderVo.setPayPrice(payPrice);
            String nums = data.getNums();
            orderVo.setOrderQuantity(Integer.valueOf(nums));
            BigDecimal totalAmount = payPrice.multiply(new BigDecimal(nums)).setScale(2);
            if((StringUtils.isNotBlank(data.getPayPrice()) && StringUtils.isNotBlank(data.getTotalAmount())) &&
                    (new BigDecimal(data.getPayPrice()).setScale(2).compareTo(payPrice) !=0 ||
                    new BigDecimal(data.getTotalAmount()).setScale(2).compareTo(totalAmount) !=0)
                    ){
                return R.error(ApiEnum.moneyError.code,ApiEnum.moneyError.msg);
            }
            orderVo.setTotalAmount(totalAmount);
            orders.add(orderVo);

            AddressParams address = data.getAddress();
            if(address!=null){
                address.setOpenId(openId);
                address.setApplicationNo(applicationNo);
                address.setOrderNo(orderNo);
                address.setSubOrderNo(subOrderNo);
                address.setConsigneeName(data.getCustomerName());
                address.setConsigneePhone(data.getCustomerPhone());
                addresses.add(address);
            }
        }
        if(orders.size()>0){
            for (ApplicationOrderDO orderVo : orders) {
                applicationOrderService.save(orderVo);//保存订单数据
            }
            if(addresses.size()>0){
                for (AddressParams address : addresses) {
                    applicationOrderService.saveOrderAddress(address);//镜像订单收获地址
                }
            }

            CommonOrderRequest commonOrderRequest = new CommonOrderRequest();
            commonOrderRequest.setOrderNo(orderNo);
            return R.ok(commonOrderRequest);
        }else {
            return R.error(ApiEnum.orderNull.code,ApiEnum.orderNull.msg);
        }
    }

    /**
     * @Description 获取最近订单中的用户信息
     * @Author scotte
     * @Date 2018/8/31 17:57
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R getOrderUserInfo(RequestVo requestVo){
        OpenIdRequestParams param = (OpenIdRequestParams) requestVo.getParamsVo();
        return R.ok( applicationOrderService.getOrderUserInfo(param.getOpenId()));
    }
    /**
     * @Description 查询用户订单
     * @Author scotte
     * @Date 2018/8/31 17:57
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R listOrders(RequestVo requestVo){
        QueryOrderListRequestParams param = (QueryOrderListRequestParams) requestVo.getParamsVo();
        List<OrderResult> orderResults = applicationOrderService.listOrdersResult(param);
        return R.ok(orderResults);
    }
    /**
     * @Description 通过订单号查询用户订单
     * @Author scotte
     * @Date 2018/8/31 17:57
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R getOrder(RequestVo requestVo){
        QueryOrderOneRequestParams param = (QueryOrderOneRequestParams) requestVo.getParamsVo();
        OrderResult orderResults = applicationOrderService.getOrder(param.getOrderNo(),requestVo.getApplicationNo(),param.getOpenId(),"",null);
        return R.ok(orderResults);
    }
    /**
     * @Description 退票处理
     * @Author scotte
     * @Date 2018/8/24 10:23
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    @Override
    public R updateRefundOrder(RequestVo requestVo){
        RefundRequestParams param = (RefundRequestParams) requestVo.getParamsVo();
        String orderNo = param.getOrderNo();
        String productNo = param.getProductNo();
        String subOrderNo = param.getSubOrderNo();
        String openId = param.getOpenId();
        OrderResult order = applicationOrderService.getOrder(orderNo,requestVo.getApplicationNo(),openId,productNo,subOrderNo);
        if(order==null || order.getOrders().size()==0)return R.error(ApiEnum.orderNull.code,ApiEnum.orderNull.msg);
        R r = checkRefund(order, param);//检测退单
        if(!r.isSuccess()){
            return r;
        }
        RefundOrderParams refundFromOms = (RefundOrderParams) r.getObj();
        RefundFromOmsDo omsDo = refundFromOms.getOmsDo();
        List<ApplicationOrderDO> failureOrders = refundFromOms.getFailureOrders();
        List<ApplicationOrderDO> orders =refundFromOms.getOrders();
        //退单
        if(orders!=null && orders.size()>0){//存在需要到oms退订的订单
            r = omsApiService.refundOrder(omsDo, requestVo.getApplicationDO().getDistribution());
            if(!r.isSuccess()){
                return r;
            }
            orders = (List<ApplicationOrderDO>) r.getObj();
            if(orders!=null&& orders.size()>0){//退单返回
                orders.addAll(failureOrders);
            }else{//特殊：订单已退
                orders =refundFromOms.getOrders();
                orders.addAll(failureOrders);
            }
        }else{
            orders = failureOrders;
        }
        if(orders.size()>0){//修改订单状态
            for (ApplicationOrderDO applicationOrderDO : orders) {//已退单，未退款
                applicationOrderService.updateOrderByOmsRefundResult(applicationOrderDO);
            }
        }
        if(StringUtils.isNotBlank(productNo) || StringUtils.isNotBlank(subOrderNo)){//设置退票总金额
            order.setTotalAmount(applicationOrderService.getOrder(orderNo,requestVo.getApplicationNo(),openId,null,null).getTotalAmount());
        }
        //退款
        RefundMoneyDo refundMoneyDo = buildRefundMoneyParams(order, orders);
        String refundMoneyStatus = "002003";
        String outRefundNo = null;
        if(refundMoneyDo!=null){
            outRefundNo = refundMoneyDo.getOutRefundNo();
            String payType = order.getPayType();
            if("006001".equals(payType)){
                r = clientWechatService.buildWechatRefundResult(refundMoneyDo, requestVo);
            }else if("006002".equals(payType)){
                r = clientAlipayService.refundMoney(refundMoneyDo, requestVo);
            }
            if(!r.isSuccess()){
                refundMoneyStatus = "002777";
                outRefundNo =null;
            }
        }
        boolean flag = true;
        for (ApplicationOrderDO applicationOrderDO : orders) {
            String orderStatus = applicationOrderDO.getOrderStatus();
            if("004004".equals(orderStatus)){
                flag = false;
                String outRefundNo1 = applicationOrderDO.getOutRefundNo();
                if(StringUtils.isNotBlank(outRefundNo1)){
                    refundMoneyStatus = "002003";
                }
                applicationOrderDO.setRefundStatus(refundMoneyStatus);
                applicationOrderDO.setOutRefundNo(outRefundNo);
                applicationOrderService.updateRefundStatusByRefundMoney(applicationOrderDO);
            }
        }
        if(flag){
            return R.error(ApiEnum.refundOrderError.code,ApiEnum.refundOrderError.msg);
        }
        return r;
    }


    /**
     * @Description 检测是否可退单
     * @Author scotte
     * @Date 2018/9/7 16:04
     * @Param [order, param]
     * @return com.ecotourism.api.common.utils.R
     */
    private R checkRefund(OrderResult order,RefundRequestParams param){
        List<OrderDo> orders = order.getOrders();
        String errorMsg = "";
        String productNo = param.getProductNo();
        RefundOrderParams refundFromOms = new RefundOrderParams();
        List<ApplicationOrderDO> failureOrders = refundFromOms.getFailureOrders();//出票失败或退款失败的订单
        List<ApplicationOrderDO> orders1 = refundFromOms.getOrders();//需要到oms退订的订单与OmsDo中data对应
        RefundFromOmsDo omsDo = refundFromOms.getOmsDo();
        omsDo.setOrderNo(order.getOrderNo());
        String payStatus = order.getPayStatus();
        if(!"005001".equals(payStatus)){
            errorMsg = dictService.getName("pay_state_type", payStatus);
            return R.error(ApiEnum.refundOrderError.code,ApiEnum.refundOrderError.msg+":"+errorMsg);
        }
        List<RefundElectronic> eles = new ArrayList<>();
        for (OrderDo orderDo : orders) {
            String productNo1 = orderDo.getProductNo();
            if(StringUtils.isBlank(productNo) || productNo1.equals(productNo)){
                String orderStatus = orderDo.getOrderStatus();
                String refundStatus = orderDo.getRefundStatus();
                //未消费，出票失败,004777:到oms出票失败，004008：oms到供应商出票失败
                if(!"004001".equals(orderStatus)&& !"004777".equals(orderStatus)&& !"004008".equals(orderStatus)&& !"004009".equals(orderStatus)&& !"002777".equals(refundStatus)){
                    errorMsg = dictService.getName("order_status", orderStatus);
                    return R.error(ApiEnum.refundOrderError.code,ApiEnum.refundOrderError.msg+":"+errorMsg);
                }
                if(!"002001".equals(refundStatus) && !"002005".equals(refundStatus)&& !"002777".equals(refundStatus)){
                    errorMsg = dictService.getName("refund_type", refundStatus);
                    return R.error(ApiEnum.refundOrderError.code,ApiEnum.refundOrderError.msg+":"+errorMsg);
                }
                ApplicationOrderDO applicationOrderDO = new ApplicationOrderDO();
                BeanUtils.copyProperties(order,applicationOrderDO);
                BeanUtils.copyProperties(orderDo,applicationOrderDO);
                BigDecimal refundAmount = applicationOrderDO.getRefundAmount();
                if(refundAmount==null){
                    applicationOrderDO.setRefundAmount(applicationOrderDO.getTotalAmount());//全额退
                }
                applicationOrderDO.setRefundStatus("002001");
                if("004777".equals(orderStatus) || "002777".equals(refundStatus)){//出票失败或退款失败，不用到oms退单
                    applicationOrderDO.setOrderStatus("004004");
                    failureOrders.add(applicationOrderDO);
                }else{
                    orders1.add(applicationOrderDO);
                    RefundElectronic refundElectronic = new RefundElectronic();
                    refundElectronic.setElectronicTicket(orderDo.getElectronicTicket());
                    eles.add(refundElectronic);
                }
                if(productNo1.equals(productNo) &&!"004777".equals(orderStatus) &&!"002777".equals(refundStatus)){//单个退订
                    break;
                }
            }
        }
        omsDo.setData(eles);
        return R.ok(refundFromOms);
    }

    /**
     * @Description 组装退款参数
     * @Author scotte
     * @Date 2018/8/24 10:43
     * @Param [byOrderNo]
     * @return com.ecotourism.api.api.domain.order.refund.RefundMoneyDo
     */
    private RefundMoneyDo buildRefundMoneyParams(OrderResult order,List<ApplicationOrderDO> orders){
        BigDecimal refundPrice = new BigDecimal(0);
        RefundMoneyDo refundMoneyDo = null;
        if(orders!=null&&orders.size()>0){
            for (ApplicationOrderDO applicationOrderDO : orders) {
                String outRefundNo = applicationOrderDO.getOutRefundNo();
                String orderStatus = applicationOrderDO.getOrderStatus();
                if(StringUtils.isBlank(outRefundNo) && "004004".equals(orderStatus)){
                    refundPrice = refundPrice.add(applicationOrderDO.getRefundAmount());
                }
            }
            if(refundPrice.compareTo(new BigDecimal(0))==1){
                refundMoneyDo = new RefundMoneyDo();
                refundMoneyDo.setOrderNo(order.getOrderNo());
                refundMoneyDo.setTotalAmount(order.getTotalAmount());
                refundMoneyDo.setOutRefundNo("refund" + new Date().getTime()+ Tools.getRandomString(13));
                refundMoneyDo.setRefundAmount(refundPrice);
                refundMoneyDo.setApplicationNo(order.getApplicationNo());
            }
        }
        return refundMoneyDo;
    }

    /**
     * @Description 获取产品当月销量
     * @Author scotte
     * @Date 2019/3/8 12:25
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R getMonthSellCount(RequestVo requestVo){
        ProductRequestParam param = (ProductRequestParam) requestVo.getParamsVo();
        return R.ok( applicationOrderService.findOrderCountByProduct(param.getProductNo()));
    }

}
