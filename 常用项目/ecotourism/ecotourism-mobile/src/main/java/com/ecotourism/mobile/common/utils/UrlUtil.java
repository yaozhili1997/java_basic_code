package com.ecotourism.mobile.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class UrlUtil {

	  
    public static int TIMEOUT = 30 * 1000;  
    public static String ENCODING = "UTF-8";  
    /**  
     * 通过HttpConnection 获取返回的字符串  
     * @param connection  
     * @return  
     * @throws IOException  
     */  
    private static String getResponseStr(HttpURLConnection connection)   
            throws IOException{  
        StringBuffer result = new StringBuffer();  
        int responseCode = connection.getResponseCode();  
  
        if (responseCode == HttpURLConnection.HTTP_OK) {  
            InputStream in = connection.getInputStream();  
            BufferedReader reader = new BufferedReader(  
                new InputStreamReader(in, ENCODING));  
            String inputLine = "";  
            while ((inputLine = reader.readLine()) != null) {  
                result.append(inputLine);  
            }  
        }  
        return String.valueOf(result);  
    } 
    
	/**
	 * 生成短网址
	 * 
	 * @author
	 * @return
	 */
	public static String createShortUrl(String longUrl) {
		String url_short = null;
		String url_long = null;
		try {
			//1681459862,3271760578
			// 调用新浪短网址生成API
			URL url = new URL("http://api.t.sina.com.cn/short_url/shorten.json?source=1681459862");// 接口地址
			// URL url = new
			// URL("https://api.weibo.com/2/short_url/shorten.json");//接口地址
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setConnectTimeout(TIMEOUT);
			connection.setRequestMethod("GET");
			// 原始长网址
			longUrl = "url_long=" + longUrl; 
			connection.getOutputStream().write(longUrl.getBytes());
			connection.connect();
			String responseStr = getResponseStr(connection);
			JSONArray arr = JSONObject.parseArray(responseStr);
			JSONObject object = arr.getJSONObject(0);
			url_short = (String) object.get("url_short");
			url_long = (String) object.get("url_long");
			int type = (Integer) object.get("type");
			System.out.println("长链接:" + url_long + "  返回类型：" + type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url_short;
	}
	public static void main(String[] args) {
		System.out.println(createShortUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxe4605d2785c03420&redirect_uri=http%3a%2f%2ftest.leleu.cn%2fapp%2findex&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect"));
	}
}
