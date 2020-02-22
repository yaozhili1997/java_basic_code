package com.ecotourism.manage.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PhoneAscriptionUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        JSONObject json = loadJSON("18602869082");
        System.out.println(json.get("province"));
    }

    public static JSONObject loadJSON (String phone) {
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+phone;
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(), "GBK"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
            JSONObject jObject = JSON.parseObject(json.toString().split("__GetZoneResult_ = ")[1]);
            JSONObject object = new JSONObject();
            object.put("province",jObject.get("province"));
            object.put("catName",jObject.get("catName"));
            return object;
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
