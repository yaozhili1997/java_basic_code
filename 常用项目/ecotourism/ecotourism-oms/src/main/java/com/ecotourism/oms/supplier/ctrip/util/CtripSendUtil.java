package com.ecotourism.oms.supplier.ctrip.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.utils.HttpSend;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.domain.RefundOrderInfoDO;
import java.util.UUID;

public class CtripSendUtil {


    public static JSONObject refundOrder(RefundOrderInfoDO refundOrderInfoDO,long orderItemID){
        //测试参数
        String ICODE = "2a8c23e9a336412297c746cb299abfc4";
        //生产参数
        //String ICODE = "bcb9a8bed0bb446f8db39c3ea5ef817d";
       // PageData UpdateOrderUrl = getRefundOrderUrl(refundOrderInfoDO,ICODE,orderItemID);

        //JSONObject send = HttpSend.send(UpdateOrderUrl.getString("pathParams"),UpdateOrderUrl.getString("json"));
        //return send;
        return null;
    }
    public static JSONObject refundOrderStatus(RefundOrderInfoDO refundOrderInfoDO){
        //检查是否可退
        //测试参数
        String ICODE = "0354f8601b0144ebaf6da82bffbc8b25";
        //生产参数
        //String ICODE = "9ace498c96b8430bbaa7fd45a4ac4c8d";
//        PageData UpdateOrderUrl = getUrl(refundOrderInfoDO,ICODE,false);
//        JSONObject send = HttpSend.send(UpdateOrderUrl.getString("pathParams"),UpdateOrderUrl.getString("json"));
//        return send;
        return null;
    }
    public static JSONObject getOrderInfo(RefundOrderInfoDO refundOrderInfoDO){
        //测试参数
        String ICODE = "39c75ec2b040426681b3595bfad1f786";
        //生产参数
        //String ICODE = "503e93cef33a4c3caa3cb46621a7fa32";
//        PageData UpdateOrderUrl = getUrl(refundOrderInfoDO,ICODE,true);
//        JSONObject send = HttpSend.send(UpdateOrderUrl.getString("pathParams"),UpdateOrderUrl.getString("json"));
//        return send;

        return null;
    }
    private static String getRequestUrl(RefundOrderInfoDO refundOrderInfoDO,String ICODE){
        String basePath = refundOrderInfoDO.getUrl();
        String params = "?AID="+refundOrderInfoDO.getAppId()+"&SID="+refundOrderInfoDO.getAppKey()+"&ICODE="+ICODE+"&UUID="+ UUID.randomUUID().toString()+"&Token="+refundOrderInfoDO.getAccessToken()+"&mode=1&format=json";
        return basePath+params;
    }
    /**
     * 检查是否可退
     * @return
     */
    private static PageData getRefundStatusUrl(RefundOrderInfoDO refundOrderInfoDO){
        //测试参数
        String ICODE = "0354f8601b0144ebaf6da82bffbc8b25";
        //生产参数
        //String ICODE = "9ace498c96b8430bbaa7fd45a4ac4c8d";
        String url = getRequestUrl(refundOrderInfoDO,ICODE);
        JSONObject jsonObject = new JSONObject();
        jsonObject = getCommonParameter(refundOrderInfoDO,true);
        JSONArray arrayItem = new JSONArray();
        JSONObject cancelOrderItem = new JSONObject();
       // cancelOrderItem.put("OrderItemID",orderItemID);
      //  cancelOrderItem.put("Quantity",refundOrderInfoDO.getQuantity());
        arrayItem.add(cancelOrderItem);
        jsonObject.put("OrderItems",arrayItem);
        JSONArray arrayVerifys = new JSONArray();
        JSONObject orderVerifys = new JSONObject();
        orderVerifys.put("VerifyKey","UID");
       // orderVerifys.put("VerifyValue",refundOrderInfoDO.getUid());
        arrayVerifys.add(cancelOrderItem);
        jsonObject.put("OrderVerifys",arrayVerifys);
        PageData pageData = new PageData();
        pageData.put("pathParams", url);
        pageData.put("json", jsonObject);
        return pageData;
    }

    /**
     * 检查门票是否可退
     * @return
     */
    private static PageData getRefundOrderUrl(RefundOrderInfoDO refundOrderInfoDO,String ICODE){
        String url = getRequestUrl(refundOrderInfoDO,ICODE);
        JSONObject jsonObject = new JSONObject();
       // jsonObject = getCommonParameter(refundOrderInfoDO,flag);
        PageData pageData = new PageData();
        pageData.put("pathParams", url);
        pageData.put("json", jsonObject);
        return pageData;
    }

    /**
     * 检查门票是否可退
     * @return
     */
    private static JSONObject getCommonParameter(RefundOrderInfoDO refundOrderInfoDO ,boolean flag){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("OrderID",Long.parseLong(refundOrderInfoDO.getThreeOrderId()));
        jsonObject.put("AllianceID",refundOrderInfoDO.getAppId());
        jsonObject.put("SID",refundOrderInfoDO.getAppKey());
        if(flag){
            jsonObject.put("DistributionChannelID",9);
        }
        return jsonObject;
    }



    private static void getOrderInfo(String ICODE){
        String basePath ="https://sopenservice.ctrip.com/OpenService/ServiceProxy.ashx";
        String params = "?AID=887334&SID=1457831&ICODE="+ICODE+"&UUID="+ UUID.randomUUID().toString()+"&Token=f9ea3c7bd87e4a29ba49447afac72e8d&mode=1&format=json";
        basePath = basePath+params;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("OrderID",Long.parseLong("3078642210"));
        jsonObject.put("AllianceID", 887334);
        jsonObject.put("DistributionChannelID", 9);
        jsonObject.put("SID", 1457831);
        JSONObject send = HttpSend.send(basePath,jsonObject.toJSONString());
        System.out.println("send==============="+send.toString());
    }

    /**
     * 检查是否可退
     * @return
     */
    private static void getRefundStatus(String ICODE,String token){
        String basePath ="https://sopenservice.ctrip.com/OpenService/ServiceProxy.ashx";
        String params = "?AID=887334&SID=1457831&ICODE="+ICODE+"&UUID="+ UUID.randomUUID().toString()+"&Token="+token+"&mode=1&format=json";
        basePath = basePath+params;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("OrderID",Long.parseLong("3078642342"));
        jsonObject.put("AllianceID", 887334);
        jsonObject.put("SID", 1457831);
        JSONObject send = HttpSend.send(basePath,jsonObject.toJSONString());
        System.out.println("send==============="+send.toString());
    }

    /**
     * 检查是否可退
     * @return
     */
    private static void getRefund(String ICODE,String token){
        String basePath ="https://sopenservice.ctrip.com/OpenService/ServiceProxy.ashx";
        String params = "?AID=887334&SID=1457831&ICODE="+ICODE+"&UUID="+ UUID.randomUUID().toString()+"&Token="+token+"&mode=1&format=json";
        basePath = basePath+params;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("OrderID",Long.parseLong("3078642342"));
        jsonObject.put("AllianceID", 887334);
        jsonObject.put("DistributionChannelID", 9);
        jsonObject.put("SID", 1457831);
        JSONObject orderItems = new JSONObject();
       // JSONArray JSONArray
        JSONObject send = HttpSend.send(basePath,jsonObject.toJSONString());
        System.out.println("send==============="+send.toString());
    }

    public static void main(String[] args) {
       // getRefundStatus("0354f8601b0144ebaf6da82bffbc8b25","74eb685c107d4b48b32da8b1c9012af7");
    }
}
