package com.ecotourism.oms.supplier.usc.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.utils.HttpSend;
import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.RefundOrderInfoDO;
import com.ecotourism.oms.oms.service.SupplierApi;
import com.ecotourism.oms.supplier.usc.util.UscSendUtil;

import java.util.Date;

public class UscService implements SupplierApi {
    @Override
    public OrderSpotDO refundOrder(RefundOrderInfoDO refundOrderInfoDO,OrderSpotDO order) {
        JSONObject jsonObject = UscSendUtil.refundUscOrder(refundOrderInfoDO);
        System.out.println("JSONObject======================"+jsonObject.toString());
        String status = jsonObject.getString("status");
        String errorMsg = jsonObject.getString("errorMsg");
        if("success".equals(status)){
            JSONArray jsonArray = JSON.parseArray(jsonObject.getString("data"));
            if(jsonArray.size()>0){
                JSONObject json = jsonArray.getJSONObject(0);
                String orderStatus = json.getString("orderStatus");
                String refundStatus = json.getString("refundStatus");
                if("004004".equals(orderStatus) && "002003".equals(refundStatus)){
                    order.setRefundStatus("002003");
                    order.setOrderStatus("004004");
                    order.setRefundTime(new Date());
                    order.setSupplierResultStatus("退票成功");
                    order.setSupplierResultMsg("退票成功");
                }else{
                    order.setSupplierResultStatus("退票失败");
                    order.setSupplierResultMsg("退票失败");
                    order.setRefundStatus("002007");
                    order.setOrderStatus("004009");
                }
            }else{
                order.setSupplierResultStatus("退票失败");
                order.setSupplierResultMsg("退票失败");
                order.setRefundStatus("002007");
                order.setOrderStatus("004009");
            }
        }else{
            order.setSupplierResultStatus("退票失败");
            order.setSupplierResultMsg(errorMsg);
            order.setRefundStatus("002007");
            order.setOrderStatus("004009");
        }
        return order;
    }
}
