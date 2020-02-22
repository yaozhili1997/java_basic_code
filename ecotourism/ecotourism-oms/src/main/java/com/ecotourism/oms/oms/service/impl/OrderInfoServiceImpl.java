package com.ecotourism.oms.oms.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.service.DictService;
import com.ecotourism.oms.common.utils.DateUtil;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.config.ApiEnum;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.dao.OrderLogDao;
import com.ecotourism.oms.oms.dao.OrderSpotDao;
import com.ecotourism.oms.oms.dao.SpotTicketDao;
import com.ecotourism.oms.oms.domain.*;
import com.ecotourism.oms.oms.service.CommonService;
import com.ecotourism.oms.oms.service.OrderInfoService;
import com.ecotourism.oms.oms.util.Tools;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    //private static Logger logger = Logger.getLogger(OrderInfoServiceImpl.class);
    @Autowired
    CommonService commonService;
    @Autowired
    OrderLogDao orderLogDao;
    @Autowired
    OrderSpotDao orderSpotDao;
    @Autowired
    SpotTicketDao spotTicketDao;
    @Autowired
    DictService dictService;
    @Override
    public String getOrderStatus(RequestVo requestVo, String orderType) {
        ResultMsg resultMsg = commonService.getParamsOrderNo(requestVo);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())){
            return commonService.getError(resultMsg.getReturn_code(), resultMsg.getReturn_msg());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("orderDistributor",requestVo.getDistributionNo());
        map.put("orderNo",resultMsg.getObj().toString());
        List<OrderLogDO> list = orderLogDao.getOrderStatus(map);
        List<PageData> buildList = commonService.buildOrderStatusInfo(list,requestVo.getApiVersion(),"022002");
        return commonService.getResultOk(requestVo,buildList);
    }

    @Override
    public String getOrder(RequestVo requestVo, String orderType) {
        ResultMsg resultMsg = commonService.getParamsOrderNo(requestVo);
        if(!ResultMsg.SUCCESS.equals(resultMsg.getReturn_code())){
            return commonService.getError(resultMsg.getReturn_code(), resultMsg.getReturn_msg());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("orderDistributor",requestVo.getDistributionNo());
        map.put("orderNo",resultMsg.getObj().toString());
        List<OrderSpotDO> list = orderSpotDao.queryOrder(map);
        if(list==null || list.size()==0){
            return commonService.getError(ApiEnum.orderNotExists.code, ApiEnum.orderNotExists.msg);
        }else{
            List<PageData> buildList = commonService.buildOrdersInfo(list,requestVo.getApiVersion(),"022002");
            return commonService.getResultOk(requestVo,buildList);
        }
    }

    @Override
    public ResultMsg allowCancel(RequestVo requestVo,ResultMsg resultMsg) {
        //logger.debug("取消订单：状态检测开始");
        List<OrderSpotDO> list = getCancelOrder(requestVo,"cancel");
        if(list==null || list.size()==0)return ResultMsg.getResultMsg(ApiEnum.orderNotExists.code,ApiEnum.orderNotExists.msg);
        for(OrderSpotDO bean:list){
            String order_status = bean.getOrderStatus();
            Date play_time = bean.getPlayTime();
            String pay_status = bean.getPayStatus();
            String refund_status = bean.getRefundStatus();
            if("005001".equals(pay_status)){//判断支付状态，是否已支付
                return ResultMsg.getResultMsg(ApiEnum.orderYiPay.code,ApiEnum.orderYiPay.msg);
            }
            if("004002".equals(order_status)){//判断是否已检
                return ResultMsg.getResultMsg(ApiEnum.orderChecked.code,ApiEnum.orderChecked.msg);
            }
            if("002003".equals(refund_status)){//判断是否退票
                return ResultMsg.getResultMsg(ApiEnum.orderYiRefund.code,ApiEnum.orderYiRefund.msg);
            }
            if(!"004001".equals(order_status)){//判断订单状态，是否未消费
                return ResultMsg.getResultMsg(ApiEnum.cancelOrderNotAccord.code,ApiEnum.cancelOrderNotAccord.msg);
            }
            long playDaySdf = play_time.getTime();//游玩当天时间
            long todaySdf = DateUtil.getsdfDayTime();//现在时间
            if(todaySdf>playDaySdf){//判断票是否过期
                return ResultMsg.getResultMsg(ApiEnum.orderOutTime.code,ApiEnum.orderOutTime.msg);
            }
        }
        //logger.debug("取消订单：状态检测结束==> 通过检测");
        return ResultMsg.getOK();
    }

    @Override
    public int cancelOrder(RequestVo requestVo,ResultMsg resultMsg) {
        OrderSpotDO orderSpotDO = new OrderSpotDO();
        orderSpotDO.setOrderDistributor(requestVo.getDistributionNo());
        orderSpotDO.setOrderNo(JSONObject.parseObject(requestVo.getData()).getString("orderNo"));
        orderSpotDO.setOrderStatus("004003");
        return orderSpotDao.cancelOrder(orderSpotDO);
    }

    @Override
    public List<OrderSpotDO> getCancelOrder(RequestVo requestVo,String type) {
        String data = requestVo.getData();
        JSONObject json = JSONObject.parseObject(data);
        String orderNo = json.getString("orderNo");
        Map<String, Object> map = new HashMap<>();
        map.put("orderDistributor",requestVo.getDistributionNo());
        map.put("orderNo",orderNo);
        if("refund".equals(type) || "modify".equals(type) ){
            StringBuffer stringBuffer = new StringBuffer();
            data = json.getString("data");
            if(StringUtils.isNotBlank(data)){
                JSONArray jsonArray = JSON.parseArray(data);
                for(int i=0;i<jsonArray.size();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    stringBuffer.append(jsonObject.getString("electronicTicket")+",");
                }
                if (stringBuffer.length()>0){
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    map.put("electronicTicket",stringBuffer.toString());
                }
            }
        }
        return orderSpotDao.getCancelOrder(map);
    }

    @Override
    public ResultMsg allowRefund(RequestVo requestVo,ResultMsg resultMsg) {
        CooperationDistributionDO coo = requestVo.getCooperationDistributionDO();//查询分销商信息
        List<OrderSpotDO> list = getCancelOrder(requestVo,"refund");
        //logger.debug("退票:检测开始");
        String COO_EXPIRED_REFUND = coo.getExpiredRefund();//是否支持过期退票(分销商控制)
        String COO_AFTER_TAKE_SCENE_REFUND = coo.getAfterTakeSceneRefund();//是否支持取票后退票(分销商控制)
        String name = coo.getName();
        if(list ==null || list.size()==0) return ResultMsg.getResultMsg(ApiEnum.orderNotExists.code, ApiEnum.orderNotExists.msg);
//        List<OrderSpotDO> orderList = new ArrayList<OrderSpotDO>();
//        orderList.addAll(list);
//        for (OrderSpotDO pageData : list) {
//            List<PageData> forList = executeQuery("querySecondOrders", pageData);
//            if(forList !=null && forList.size()>0){
//                orderList.addAll(forList);
//            }
//        }
        PageData productDatas = new PageData();
        String distributionNo = requestVo.getDistributionNo();
        for(OrderSpotDO bean:list){
            bean.setOrderDistributor(distributionNo);
            String product_no = bean.getProductNo();
            String PRODUCT_NAME = bean.getProductName();
            SpotTicketDO product = spotTicketDao.get(product_no);
            String WHETHER_REFUND = product.getWhetherRefund();
            if("0".equals(WHETHER_REFUND)){//不允许退票
                return ResultMsg.getResultMsg(ApiEnum.productNotRefundException.code,ApiEnum.productNotRefundException.msg);
            }
            //logger.debug("退票:分销商："+name+"的产品"+product_no+"==>"+PRODUCT_NAME+"==>允许退票");
            String product_type = product.getProductType();//产品类型
//            if(!CodeUtil.CODE_043008.equals(product_type)) {//判断是否为套票产品
//                product = clientHelperProductService.getProduct(product_no);
//            }
            productDatas.put(product_no,product);
            String ORDER_STATUS = bean.getOrderStatus();
            String REFUND_STATUS = bean.getRefundStatus();
            if("043001".equals(product_type)){//单车票
                Integer IS_TRANSIT = bean.getIsTransit();//是否乘车
                if(IS_TRANSIT != null){
                    int isTransit = Integer.valueOf(IS_TRANSIT);
                    if(isTransit>0){
                        return ResultMsg.getResultMsg(ApiEnum.ticketUseNotRefund.code,ApiEnum.ticketUseNotRefund.msg);
                    }
                }
            }
            if(!"002001".equals(REFUND_STATUS) && !"002005".equals(REFUND_STATUS) && !"002007".equals(REFUND_STATUS)){
                if("002003".equals(REFUND_STATUS)){
                    return ResultMsg.getResultMsg(ApiEnum.orderYiRefund.code,ApiEnum.orderYiRefund.msg);
                }
                if("002004".equals(REFUND_STATUS)){
                    return ResultMsg.getResultMsg(ApiEnum.retirementAudit.code,ApiEnum.retirementAudit.msg);
                }
                if("002006".equals(REFUND_STATUS)){
                    return ResultMsg.getResultMsg(ApiEnum.refundRetirementAuditError.code,ApiEnum.refundRetirementAuditError.msg);
                }
                return ResultMsg.getResultMsg(ApiEnum.refundOrderError.code,ApiEnum.refundOrderError.msg);
            }

            if("002007".equals(REFUND_STATUS)){
                String is_self = product.getIsSelf();
                //非自有
                if("1".equals(is_self)){
                    return ResultMsg.getResultMsg(ApiEnum.refundRetirementAuditError.code,ApiEnum.refundRetirementAuditError.msg);
                }
            }
            if(!"005001".equals(bean.getPayStatus())){
                return ResultMsg.getResultMsg(ApiEnum.refundOrderNotPay.code,ApiEnum.refundOrderNotPay.msg);
            }
            if(!"004001".equals(ORDER_STATUS) && !"004008".equals(ORDER_STATUS) && !"004009".equals(ORDER_STATUS)){
                if("004002".equals(ORDER_STATUS)){
                    return ResultMsg.getResultMsg(ApiEnum.orderCheckedRefund.code, ApiEnum.orderCheckedRefund.msg);
                }
                if("004003".equals(ORDER_STATUS)){
                    return ResultMsg.getResultMsg(ApiEnum.orderCanleRefund.code, ApiEnum.orderCanleRefund.msg);
                }
                if("004004".equals(ORDER_STATUS)){
                    return ResultMsg.getResultMsg(ApiEnum.orderYiRefund.code, ApiEnum.orderYiRefund.msg);
                }
                if("004006".equals(ORDER_STATUS)){
                    String PRODUCT_AFTER_TAKE_SCENE_REFUND = product.getAfterTakeSceneRefund();//是否支持取票后退票(产品控制)
                    if("0".equals(COO_AFTER_TAKE_SCENE_REFUND) || "0".equals(PRODUCT_AFTER_TAKE_SCENE_REFUND)) {//不允许取票后退票
                        //logger.debug("退票:分销商："+name+"的产品"+product_no+"==>"+PRODUCT_NAME+"==>不允许取票后退票");
                        return ResultMsg.getResultMsg(ApiEnum.orderGetTicketRefund.code, ApiEnum.orderGetTicketRefund.msg);
                    }
                }
                return ResultMsg.getResultMsg(ApiEnum.refundOrderNotAccord.code,ApiEnum.refundOrderNotAccord.msg);
            }
            if("004009".equals(ORDER_STATUS)){
                String is_self = product.getIsSelf();
                //非自有
                if("1".equals(is_self)){
                    return ResultMsg.getResultMsg(ApiEnum.refundRetirementAuditError.code,ApiEnum.refundRetirementAuditError.msg);
                }
            }
            String PRODUCT_EXPIRED_REFUND = product.getExpiredRefund();//是否可过期退票(产品控制)
            if("0".equals(COO_EXPIRED_REFUND) || "0".equals(PRODUCT_EXPIRED_REFUND)){//不允许过期退票
                Date play_time = bean.getPlayTime();
                long playtime = play_time.getTime();
                long nowtime = DateUtil.getsdfDayTime();
                if(playtime<nowtime){
                    return ResultMsg.getResultMsg(ApiEnum.refundOrderOutTime.code, ApiEnum.refundOrderOutTime.msg);
                }
            }
            //logger.debug("退票:分销商："+name+"的产品"+product_no+"==>"+PRODUCT_NAME+"==>允许过期退票");
        }
        //logger.debug("退票:检测结束==> 检测通过");
        PageData pageData = new PageData();
        pageData.put("orders",list);
        pageData.put("products",productDatas);
        return ResultMsg.getOK(pageData);
    }

    @Override
    public int refundOrder(OrderSpotDO orderSpotDO) {
        return orderSpotDao.refundOrder(orderSpotDO);
    }

    @Override
    public ResultMsg checkUpdateData(RequestVo requestVo) {
        //logger.debug("改单:参数检测开始");
        String data = requestVo.getData();
        JSONObject json =null;
        try {
            json = JSONObject.parseObject(data);
        } catch (Exception e) {
            return ResultMsg.getResultMsg(ApiEnum.jsonException.code,ApiEnum.jsonException.msg);
        }
        String orderNo =  json.getString("orderNo");
        if(StringUtils.isBlank(orderNo)){
            return ResultMsg.getResultMsg(ApiEnum.orderIsNull.code,ApiEnum.orderIsNull.msg);
        }
        JSONArray jsonArray = json.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String electronicTicket =  jsonObject.getString("electronicTicket");
            if(StringUtils.isBlank(electronicTicket)){
                return ResultMsg.getResultMsg(ApiEnum.ElectronicException.code,ApiEnum.ElectronicException.msg);
            }
            String customerPhone = jsonObject.getString("customerPhone");
            if(StringUtils.isNotBlank(customerPhone) && !Tools.checkMobileNumber(customerPhone)){
                return ResultMsg.getResultMsg(ApiEnum.phoneNumException.code,ApiEnum.phoneNumException.msg);
            }
            String customerUserId =  jsonObject.getString("customerUserId");
            if(StringUtils.isNotBlank(customerUserId) && !Tools.is18ByteIdCardComplex(customerUserId)){
                return ResultMsg.getResultMsg(ApiEnum.idCardNumException.code,ApiEnum.idCardNumException.msg);
            }

            if(jsonObject.containsKey("playTime")){
                String playTime = jsonObject.getString("playTime");
                if(StringUtils.isBlank(playTime)){
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"游玩时间不能为空！");
                }
                try {
                    Date parse = jsonObject.getDate("playTime");
                    long today = DateUtil.getsdfDayTime();
                    if(parse.getTime()<today){
                        return ResultMsg.getResultMsg(ApiEnum.buyOutTimeError.code,ApiEnum.buyOutTimeError.msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResultMsg.getResultMsg(ApiEnum.paramError.code,"游玩时间格式异常！");
                }
            }
        }
        //logger.debug("改单:参数检测结束==>通过检测");
        return ResultMsg.getOK();
    }

    @Override
    public ResultMsg allowUpdate(RequestVo requestVo) {
        //logger.debug("改单:规则检测开始");
        List<OrderSpotDO> list = getCancelOrder(requestVo,"modify");
        if(list==null || list.size()==0) return ResultMsg.getResultMsg(ApiEnum.orderNotExists.code, ApiEnum.orderNotExists.msg);
//        List<PageData> orderList = new ArrayList<PageData>();
//        orderList.addAll(executeQuery);
//        for (PageData pageData : executeQuery) {
//            List<PageData> forList = executeQuery("querySecondOrders", pageData);
//            if(forList !=null && forList.size()>0){
//                orderList.addAll(forList);
//            }
//        }
        long todaySdf = DateUtil.getsdfDayTime();//现在时间
        for (OrderSpotDO order : list) {
            long playDaySdf = order.getPlayTime().getTime();//游玩当天时间
            if(playDaySdf<todaySdf)return ResultMsg.getResultMsg(ApiEnum.orderOutTime.code, ApiEnum.orderOutTime.msg);
            String ORDER_STATUS = order.getOrderStatus();
            if(!"004001".equals(ORDER_STATUS)){
                String sname = dictService.getName("order_status",ORDER_STATUS,"00000003");
                return ResultMsg.getResultMsg(ApiEnum.orderStatusException.code, ApiEnum.orderStatusException.msg+"-->订单状态:"+sname);
            }
        }
        //logger.debug("改单:规则检测结束==>通过检测");
        return ResultMsg.getOK(list);
    }

    @Override
    public int updateOrder(OrderSpotDO orderSpotDO,RequestVo requestVo) {
        String data = requestVo.getData();
        JSONObject json =JSONObject.parseObject(data);
        JSONArray jsonArray = json.getJSONArray("data");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String electronicTicket =  jsonObject.getString("electronicTicket");
            if(electronicTicket.equals(orderSpotDO.getElectronicTicket())){
                String customerPhone = jsonObject.getString("customerPhone");
                String customerUserId =  jsonObject.getString("customerUserId");
                String customerName =  jsonObject.getString("customerName");
                Date playTime = jsonObject.getDate("playTime");
                orderSpotDO.setCustomerUserId(customerUserId);
                orderSpotDO.setPlayTime(playTime);
                orderSpotDO.setCustomerPhone(customerPhone);
                orderSpotDO.setCustomerName(customerName);
                break;
            }
        }
        return orderSpotDao.updateOrder(orderSpotDO);
    }

}
