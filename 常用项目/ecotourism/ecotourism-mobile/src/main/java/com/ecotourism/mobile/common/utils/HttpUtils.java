package com.ecotourism.mobile.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

public class HttpUtils {
	public static String sendGetRequest(String uri) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(uri);
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
//		method.setRequestBody(params);
		client.getParams().setContentCharset("UTF-8");
		client.executeMethod(method);
		String result = method.getResponseBodyAsString();
		return result;
	}

	public static String post(String uri, NameValuePair... params) throws IOException {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(uri);
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
		method.setRequestBody(params);
		client.getParams().setContentCharset("UTF-8");
		client.executeMethod(method);
		String result = method.getResponseBodyAsString();
		return result;
	}

	public static String post(String uri, Object object) throws IOException {
		return post(uri, objectToNameValuePairs(object));
	}

	private static NameValuePair[] objectToNameValuePairs(Object object) {
		JSONObject json;
		if (object instanceof String) {
			json = JSONObject.parseObject((String)object);
		} else {
			json = JSONObject.parseObject(JSONObject.toJSONString(object));
		}

		Set<String> keys = json.keySet();
		NameValuePair[] nameValuePairs = new NameValuePair[keys.size()];
		int i = 0;
		for (String key : keys) {
			nameValuePairs[i++] = new NameValuePair(key, json.getString(key));
		}
		return nameValuePairs;
	}
	

	
	public  static void sendData(String urlStr) throws Exception {
//		HttpClient client = new HttpClient();
//		GetMethod method = new GetMethod(uri);
//		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
////		method.setRequestBody(params);
//		client.getParams().setContentCharset("UTF-8");
//		client.executeMethod(method);
//		String result = method.getResponseCharSet();
//		return result;
		 URL url = new URL(urlStr);
         HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
         urlcon.connect();         //获取连接
         InputStream is = urlcon.getInputStream();
         BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
         StringBuffer bs = new StringBuffer();
         String l = null;
         while((l=buffer.readLine())!=null){
             bs.append(l).append("/n");
         }
         System.out.println(bs.toString());
	}

	/**
	 * 功能: postBody形式发送数据
	 * @param url 对方地址
	 * @param json 要传送的数据
	 * @return
	 * @throws Exception
	 */
	public static String postBody(String url, String json) throws Exception {
		try{
			// Configure and open a connection to the site you will send the request
			HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
			// 设置doOutput属性为true表示将使用此urlConnection写入数据
			urlConnection.setDoOutput(true);
			// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
			urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			// 得到请求的输出流对象
			OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
			// 把数据写入请求的Body
			out.write(json);
			out.flush();
			out.close();

			// 从服务器读取响应
			InputStream inputStream = urlConnection.getInputStream();
			String encoding = urlConnection.getContentEncoding();
			String body = IOUtils.toString(inputStream, encoding);
			if(urlConnection.getResponseCode() == 200){
				return body;
			}else{
				throw new Exception(body);
			}
		} catch(IOException e) {
			e.getMessage();
			throw e;
		}
	}

	/**
	 * 功能: postBody形式发送数据
	 * @param url 对方地址
	 * @param json 要传送的数据
	 * @return
	 * @throws Exception
	 */
	public static String postJson(String url, String json) throws Exception {
		try{
			// Configure and open a connection to the site you will send the request
			HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
			// 设置doOutput属性为true表示将使用此urlConnection写入数据
			urlConnection.setDoOutput(true);
			// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
			urlConnection.setRequestProperty("content-type", "application/json");
			// 得到请求的输出流对象
			OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
			// 把数据写入请求的Body
			out.write(json);
			out.flush();
			out.close();

			// 从服务器读取响应
			InputStream inputStream = urlConnection.getInputStream();
			String encoding = urlConnection.getContentEncoding();
			String body = IOUtils.toString(inputStream, encoding);
			if(urlConnection.getResponseCode() == 200){
				return body;
			}else{
				throw new Exception(body);
			}
		} catch(IOException e) {
			e.getMessage();
			throw e;
		}
	}
	
	public static void main(String[] args) {
		try {
			sendData("http://cloudprint.cainiao.com/cloudprint/lodop/convert2cainiao.json?lodopData=@w0Luru1dt1vovf0ncLzatfvfptincG0kw1astLrpuf0ncKLuru1qyw5LBfaqveW9mb0ksvrftte9nty3dqPjvevnmJ01otmncG0kw1astKXfrLrDdqPjvevnugfUzwXqufrmptbncKLuru0XptCncKLuru0YptKncG0kw1astLDjrfrixq0ksvrftvaHBMvSufautd0ZnZGncKLuru0Xptm1nG0ksvrftti9mtiWdqOncLTquK5iruLhsfrDdqPjvevnugfUzwXqufrmpty4mb0ksvrftte9nZKncKLuru0YptiWdqOncLTdteftu0Lorevyxq0ksvrftte9mG0ksvrftti9mG0kdqPBq29UDgvUDf0ncKLuru0XpxL2m0j2Es9kEK1Hm3CVDxP4As9kEKX6u3nLrem2nK9VDtD2utalt3bncKLuru0YpxD2uZGWCKC0mtzjpq0kdqPBsxrLBu5HBwvDdqPjvevnmt1NB29KCY1UDw0TDgL0BguTy29Kzs13CMfWdqPjvevnmJ1ZzwXSzxjFBwvTBW0kdqPBve1wrvjtsu9oxq0kve1wrvjtsu9optiWmtyTmdGTmZeTmdeTmJencLTjvevnru5exq0k&charSet=GBK&cdata=true&displayContent=true&hasVar=true&specialTag=true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
