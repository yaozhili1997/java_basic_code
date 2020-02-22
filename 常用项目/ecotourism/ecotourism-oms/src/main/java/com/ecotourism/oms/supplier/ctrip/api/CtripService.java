package com.ecotourism.oms.supplier.ctrip.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.RefundOrderInfoDO;
import com.ecotourism.oms.oms.domain.SupplierDO;
import com.ecotourism.oms.oms.service.SupplierApi;
import com.ecotourism.oms.supplier.ctrip.util.CtripSendUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CtripService implements SupplierApi {
    private static Logger logger = LoggerFactory.getLogger(CtripService.class);

    @Override
    public OrderSpotDO refundOrder(RefundOrderInfoDO refundOrderInfoDO, OrderSpotDO order) {
        JSONObject refundStatus = CtripSendUtil.refundOrderStatus(refundOrderInfoDO);
        JSONObject resultStatus = refundStatus.getJSONObject("ResultStatus");
        String errorMessage = resultStatus.getString("ErrorMessage");
        long orderItemID = 0;
        if(resultStatus.getBoolean("IsSuccess")){
            JSONArray jsonArray = refundStatus.getJSONArray("CancelItems");
            if(jsonArray.size()>0){
                JSONObject cancelItem = jsonArray.getJSONObject(0);
                String cancelItemStatus = cancelItem.getString("CancelItemStatus");
                if("1".equals(cancelItemStatus)){
                    orderItemID = cancelItem.getLong("OrderItemID");
                    JSONObject refundOrder = CtripSendUtil.refundOrder(refundOrderInfoDO,orderItemID);
                }else{
                    order.setRefundStatus("002003");
                    order.setOrderStatus("004004");
                    order.setSupplierResultStatus("退票失败");
                    order.setSupplierResultMsg("订单不可取消");
                }
            }
        }else{
            order.setSupplierResultStatus("退票失败");
            order.setSupplierResultMsg(errorMessage);
            order.setRefundStatus("002007");
            order.setOrderStatus("004009");
        }

//        JSONObject json = CtripSendUtil.refundOrder(refundOrderInfoDO);
//        System.out.println("json====="+json.toString());
//        UscQueryOrderInDO uscQueryOrderInDO = new UscQueryOrderInDO();
//        uscQueryOrderInDO.setPiaogoOrderNo(orderData.getOrderNo());
//        uscQueryOrderInDO.setProductNo(orderData.getProductNo());
//        JSONObject resultStatus = json.getJSONObject("ResultStatus");
//        String errorMessage = resultStatus.getString("ErrorMessage");
//        String customerErrorMessage = resultStatus.getString("CustomerErrorMessage");
//        String orderId = json.getString("OrderID");
//        if(resultStatus.getBoolean("IsSuccess") || "615006".equals(resultStatus.getString("ErrorCode"))){
//            JSONObject jsonOrder = CtripSendUtil.getOrderInfo(supplier,orderId);
//            System.out.println("jsonOrder=============="+jsonOrder.toString());
//            if(jsonOrder.getJSONObject("ResultStatus").getBoolean("IsSuccess")){
//                JSONObject orderInfo = jsonOrder.getJSONObject("OrderInfo");
//                JSONArray jsonArray  = new JSONArray();
//                jsonArray = orderInfo.getJSONArray("OrderItemInfos");
//                if(jsonArray.size()>0){
//                    JSONObject jsonObject = jsonArray.getJSONObject(0);
//                    String vendorVoucher = jsonObject.getString("VoucherCode");
//                    uscQueryOrderInDO.setElectronicTicket(vendorVoucher);
//                    if(StringUtils.isBlank(vendorVoucher)){
//                        uscQueryOrderInDO.setElectronicTicket(orderId);
//                    }
//                    uscQueryOrderInDO.setOrderVoucherno(orderId);
//                    uscQueryOrderInDO.setThreeOrderId(orderId);
//                    uscQueryOrderInDO.setOrderStatus("004001");
//                    uscQueryOrderInDO.setStatus("下单成功");
//                    uscQueryOrderInDO.setMsg("下单成功");
//                }else{
//                    uscQueryOrderInDO.setOrderStatus("004001");
//                }
//            }
//        }else{
//            uscQueryOrderInDO.setOrderStatus("004008");
//            uscQueryOrderInDO.setStatus("下单失败");
//            uscQueryOrderInDO.setMsg("ErrorMessage:"+errorMessage+"======CustomerErrorMessage:"+customerErrorMessage);
//        }
//        logger.debug(supplier.getSupplierName()+"Token errcode===="+json.toString());
//        return uscQueryOrderInDO;
        return null;
    }
}
