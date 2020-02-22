package com.ecotourism.oms.oms.util;

import com.alibaba.fastjson.JSONObject;

public class Error {

    public static String getError(String errorCode,String errorMsg) {
        JSONObject result = new JSONObject();
        result.put("status", "false");
        result.put("errorCode", errorCode);
        result.put("errorMsg", errorMsg);
        result.put("data", "{}");
        result.put("sign", "");
        return result.toJSONString();
    }
}
