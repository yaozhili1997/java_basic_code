package com.ecotourism.oms.supplier.usc.util;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.common.utils.HttpSend;
import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.domain.RefundOrderInfoDO;
import com.ecotourism.oms.oms.util.express.util.SignUtil;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class UscSendUtil {
    private static final String refundTicket = "refundTicket";
    /**
     * 退单
     * @return
     */
    private static PageData getRefundOrderUrl(RefundOrderInfoDO refundOrderInfoDO){
        String basePath = refundOrderInfoDO.getUrl();
        String params = "?sign="+ SignUtil.sign(refundOrderInfoDO.getCid()+refundOrderInfoDO.getAppId()+refundOrderInfoDO.getAppKey())+"&cid="+refundOrderInfoDO.getCid();
        String json = "{'orderNo':'"+refundOrderInfoDO.getPiaogoOrderNo()+
                "'}";
        PageData pageData = new PageData();
        pageData.put("pathParams", basePath+refundTicket+params);
        pageData.put("json", json);
        return pageData;
    }

    public static JSONObject refundUscOrder(RefundOrderInfoDO refundOrderInfoDO){
        PageData UpdateOrderUrl = getRefundOrderUrl(refundOrderInfoDO);
        System.out.println("json====================="+UpdateOrderUrl.getString("json"));
        JSONObject send = HttpSend.send(UpdateOrderUrl.getString("pathParams"),UpdateOrderUrl.getString("json"));
        return send;
    }
}
