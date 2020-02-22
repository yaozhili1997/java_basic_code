package com.ecotourism.api.pay.wechat.util;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.api.application.domain.ApplicationUserDO;
import com.ecotourism.api.common.utils.EmojiCharacterUtil;
import com.ecotourism.api.pay.wechat.domain.pay.WechatParam;
import com.ecotourism.api.pay.wechat.util.cons.WeChatCons;
import com.ecotourism.api.payment.domain.PaymentWechatDO;
import org.apache.commons.lang.StringUtils;

import javax.net.ssl.*;
import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;


/**
 * 说明：微信工具类
 * @author 陈启勇
 * 创建时间：2017年11月1日
 * @version
 */
public class WechatUtils {
	/**
	 * 微信网页授权(第二步，通过code换取网页授权access_token)
	 * @param wechatConfig
	 * @return
	 */
	public static ApplicationUserDO wechatOauth(String code, PaymentWechatDO wechatConfig){
         String params = "appid=" + wechatConfig.getAppId() + "&secret=" +wechatConfig.getAppSecret()+"&code="+code+ "&grant_type=authorization_code";
         // 获取网页授权凭证
         String sendGet = sendPost(WeChatCons.oauth2AccessTokenUrl,params);
         JSONObject jsonObject = JSONObject.parseObject(sendGet);
        ApplicationUserDO applicationUserDO = new ApplicationUserDO();
        applicationUserDO.setCode(false);
         try {
        	 String openid = jsonObject.getString("openid");
        	 if(StringUtils.isBlank(openid)){
                 applicationUserDO.setErrorMsg("获取openID失败！==>"+sendGet);
        	     return applicationUserDO;
             }
             applicationUserDO.setCode(true);
             applicationUserDO.setOpenid(openid);
             applicationUserDO.setAccessToken(jsonObject.getString("access_token"));
             applicationUserDO.setScope(jsonObject.getString("scope"));
             applicationUserDO.setUserSource("006001");
             return applicationUserDO;
         } catch (Exception e) {
             String errorCode = jsonObject.getString("errcode");
             String errorMsg = jsonObject.getString("errmsg");
             applicationUserDO.setErrorMsg(errorMsg);
             return applicationUserDO;
         }
	}
	
	/**
     * 网页授权获取用户信息（第四步：拉取用户信息(需scope为 snsapi_userinfo)）
     * accessToken 网页授权接口调用凭证
     * openId 用户标识
     * @return SNSUserInfo
     */
    public static ApplicationUserDO getWeiXinUserInfo(ApplicationUserDO applicationUserDO) {
        // 通过网页授权获取用户信息
        String params = "access_token=" + applicationUserDO.getAccessToken() + "&openid=" + applicationUserDO.getOpenid();
        // 获取网页授权凭证
        String sendGet = sendPost(WeChatCons.oauth2UserInfoUrl,params);
        JSONObject jsonObject = JSONObject.parseObject(sendGet);
            try {
                applicationUserDO.setCode(true);
                // 用户的标识
                applicationUserDO.setOpenid(jsonObject.getString("openid"));
                // 昵称
                String nickname = jsonObject.getString("nickname");
                if(StringUtils.isBlank(nickname)){
                    applicationUserDO.setNickName("微信用户");
                }else{
                    nickname = EmojiCharacterUtil.filter(nickname);
                }
                applicationUserDO.setNickName(nickname);
                // 性别（1是男性，2是女性，0是未知）
                Integer sex = jsonObject.getInteger("sex");
                String sexZ = "";
                if(sex==1){
                    sexZ = "m";
                }
                if(sex==2){
                    sexZ = "w";
                }
                applicationUserDO.setGender(sexZ);
                // 用户所在国家
                applicationUserDO.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                applicationUserDO.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                applicationUserDO.setCity(jsonObject.getString("city"));
                // 用户头像
                applicationUserDO.setAvatar(jsonObject.getString("headimgurl"));
                applicationUserDO.setUnionid(jsonObject.getString("unionid"));
            } catch (Exception e) {
                applicationUserDO.setCode(false);
                int errorCode = jsonObject.getInteger("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                applicationUserDO.setErrorMsg(errorMsg);
            }
        return applicationUserDO;
    }
    /**
     * 获取公众号的全局唯一接口调用凭据
     * @return
     */
    public static String getAccessToken(WechatParam wechatConfig) {
    	String appId = wechatConfig.getAppId();
    	String access_token = (String) CacheUtil.getCache(WeChatCons.AccessToken+appId);
    	if(StringUtils.isNotBlank(access_token)) return access_token;
    	String params = "grant_type=client_credential&appid=" + appId  + "&secret=" + wechatConfig.getAppSecret();
    	JSONObject jsonObject = httpRequest(WeChatCons.AccessToken+"?"+params, "POST",null);
    	if(null != jsonObject){
    		try {
    			access_token = jsonObject.getString("access_token");
    			if(StringUtils.isNotBlank(access_token)){
    				CacheUtil.setCache(WeChatCons.AccessToken+appId, access_token);//设置缓存
    			}else{
    			}
    		} catch (Exception e) {
    			int errorCode = jsonObject.getInteger("errcode");
    			String errorMsg = jsonObject.getString("errmsg");
    		}
    	}
    	return access_token;
    }

    /**
     *jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket的有效期为7200秒
     * @return
     */
    public static String getJsApiTicket(WechatParam wechatConfig) {
    	String ticket = (String) CacheUtil.getCache(WeChatCons.jsapi_ticket);
    	if(StringUtils.isNotBlank(ticket)) return ticket;
    	String accessToken = getAccessToken(wechatConfig);
    	String params = "access_token=" + accessToken  + "&type=jsapi";
    	JSONObject jsonObject = httpRequest(WeChatCons.jsapi_ticket+"?"+params, "POST",null);
    	if(null !=jsonObject){
    		String errmsg = jsonObject.getString("errmsg");
    		if("ok".equals(errmsg)){
    			ticket = jsonObject.getString("ticket");
    			CacheUtil.setCache(WeChatCons.jsapi_ticket, ticket);//设置缓存
    			return ticket;
    		}else{
    			int errorCode = jsonObject.getInteger("errcode");
    			String errorMsg = jsonObject.getString("errmsg");
    		}
    	}
		return ticket;
    }


    /**
     * 微信小程序获取openId
     * @return
     */
    public static ApplicationUserDO getOpenId(String code,PaymentWechatDO wechat){
        String params = "appid=" + wechat.getAppId() + "&secret=" +wechat.getAppSecret()+"&js_code="+code+ "&grant_type=authorization_code";
        // 获取网页授权凭证
        String sendGet = sendPost(WeChatCons.jscode2session,params);
        JSONObject jsonObject = JSONObject.parseObject(sendGet);
        ApplicationUserDO applicationUserDO = new ApplicationUserDO();
        applicationUserDO.setCode(false);
        try {
            String openid = jsonObject.getString("openid");
            if(StringUtils.isBlank(openid)){
                applicationUserDO.setErrorMsg(sendGet);
                return applicationUserDO;
            }
            applicationUserDO.setCode(true);
            applicationUserDO.setOpenid(openid);
            applicationUserDO.setSessionKey(jsonObject.getString("session_key"));
            applicationUserDO.setNickName(WeChatCons.WECHAT_NICK_NAME);
        } catch (Exception e) {
            String errorCode = jsonObject.getString("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            String msg = "微信小程序获取openId失败 errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}";
            applicationUserDO.setErrorMsg(msg);
        }
        return applicationUserDO;
    }
    /**
     * 微信小程序解密用户信息
     * @param encryptedData 明文,加密数据
     * @param iv            加密算法的初始向量
     * @param session_key          用户允许登录后，回调内容会带上 code（有效期五分钟），开发者需要将 code 发送到开发者服务器后台，使用code 换取 session_key api，将 code 换成 openid 和 session_key
     * @return
     */
    public static ApplicationUserDO decodeUserInfo(String encryptedData, String iv, String session_key){
        ApplicationUserDO  applicationUserDO =null;
        try {
            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                applicationUserDO = new ApplicationUserDO();
                JSONObject userInfoJSON =  JSONObject.parseObject(result);
                Object nickName = userInfoJSON.get("nickName");
                if(nickName ==null){
                    nickName = "未授权用户";
                }
                applicationUserDO.setNickName(nickName.toString());
                applicationUserDO.setOpenid(userInfoJSON.getString("openId"));
                String gender = "m";
                Object gender1 = userInfoJSON.get("gender");
                if(gender1 !=null && !"1".equals(gender1.toString())){
                    gender="w";
                }
                applicationUserDO.setGender(gender);
                applicationUserDO.setCity(userInfoJSON.getString("city"));
                applicationUserDO.setProvince(userInfoJSON.getString("province"));
                applicationUserDO.setCountry(userInfoJSON.getString("country"));
                applicationUserDO.setAvatar(userInfoJSON.getString("avatarUrl"));
                applicationUserDO.setUnionid(userInfoJSON.getString("unionId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationUserDO;
    }

    /**
     * 获取短链接
     * @param url
     * @return
     */
    public static String getShortUrl(String url,WechatParam wechatConfig){
    	String accessToken = getAccessToken(wechatConfig);
    	String params = "access_token=" + accessToken  + "&action=long2short&long_url="+url;
    	JSONObject jsonObject = httpRequest(WeChatCons.longToShortUrl+"?"+params, "POST",null);
    	String short_url = "";
    	if(null !=jsonObject){
    		String errmsg = jsonObject.getString("errmsg");
    		if("ok".equals(errmsg)){
    			short_url = jsonObject.getString("short_url");
    		}else{
    			int errorCode = jsonObject.getInteger("errcode");
    			String errorMsg = jsonObject.getString("errmsg");
    		}
    	}
    	return short_url;
    }
	
	
	/*================================发送请求==============================================*/
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    /**  
     * 发起https请求并获取结果  
     *   
     * @param requestUrl 请求地址  
     * @param requestMethod 请求方式（GET、POST）  
     * @param outputStr 提交的数据  
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)  
     */    
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();    
        try {    
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化    
            TrustManager[] tm = { new MyX509TrustManager() };    
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");    
            sslContext.init(null, tm, new java.security.SecureRandom());    
            // 从上述SSLContext对象中得到SSLSocketFactory对象    
            SSLSocketFactory ssf = sslContext.getSocketFactory();    
    
            URL url = new URL(requestUrl);    
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();    
            httpUrlConn.setSSLSocketFactory(ssf);    
    
            httpUrlConn.setDoOutput(true);    
            httpUrlConn.setDoInput(true);    
            httpUrlConn.setUseCaches(false);    
            // 设置请求方式（GET/POST）    
            httpUrlConn.setRequestMethod(requestMethod);    
    
            if ("GET".equalsIgnoreCase(requestMethod))    
                httpUrlConn.connect();    
    
            // 当有数据需要提交时    
            if (null != outputStr) {    
                OutputStream outputStream = httpUrlConn.getOutputStream();    
                // 注意编码格式，防止中文乱码    
                outputStream.write(outputStr.getBytes("UTF-8"));    
                outputStream.close();    
            }    
    
            // 将返回的输入流转换成字符串    
            InputStream inputStream = httpUrlConn.getInputStream();    
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
    
            String str = null;    
            while ((str = bufferedReader.readLine()) != null) {    
                buffer.append(str);    
            }    
            bufferedReader.close();    
            inputStreamReader.close();    
            // 释放资源    
            inputStream.close();    
            inputStream = null;    
            httpUrlConn.disconnect();    
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
        } catch (Exception e) {
        }    
        return jsonObject;    
    }    
    
    /**  
     * 证书信任管理器（用于https请求）  
     */    
    static class MyX509TrustManager implements X509TrustManager {    
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {    
        }    
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {    
        }    
        public X509Certificate[] getAcceptedIssuers() {    
            return null;    
        }    
    }   
}
