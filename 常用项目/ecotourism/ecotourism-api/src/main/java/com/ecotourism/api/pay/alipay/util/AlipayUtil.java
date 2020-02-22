package com.ecotourism.api.pay.alipay.util;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.ecotourism.api.api.util.DateUtil;
import com.ecotourism.api.application.domain.ApplicationUserDO;
import com.ecotourism.api.common.utils.EmojiCharacterUtil;
import com.ecotourism.api.payment.domain.PaymentAlipayDO;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * 说明：支付宝工具类
 * 创建人：陈启勇
 * 创建时间: 2018/10/8 15:01
 **/
public class AlipayUtil {

    public static final String URL = "https://openapi.alipay.com/gateway.do";

    // 授权
    public static ApplicationUserDO oauth(String authCode, PaymentAlipayDO alipay) {
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("app_id",alipay.getAppid());
        treeMap.put("method", "alipay.system.oauth.token");
        treeMap.put("charset", "UTF-8");
        treeMap.put("sign_type", "RSA2");
        treeMap.put("timestamp", DateUtil.getTime());
        treeMap.put("version", "1.0");
        treeMap.put("grant_type", "authorization_code");
        treeMap.put("code", authCode);
        ApplicationUserDO applicationUserDO = new ApplicationUserDO();
        applicationUserDO.setCode(false);
        try {
            String sign = AlipaySignature.rsa256Sign(AlipaySignature.getSignContent(treeMap), alipay.getRsaPrivateKey(),alipay.getCharset());
            treeMap.put("sign", sign);
        } catch (Exception e) {
            e.printStackTrace();
            applicationUserDO.setErrorMsg(e.getMessage());
            return applicationUserDO;
        }
        ApiRequest entity = new ApiRequest(URL, treeMap);
        try {
            String responseStr = sendRequest(entity);
            if (StringUtils.isNotEmpty(responseStr)) {
                JSONObject rsp = JSONObject.parseObject(responseStr)
                        .getJSONObject("alipay_system_oauth_token_response");
                if (rsp != null) {
                    applicationUserDO.setCode(true);
                    applicationUserDO.setOpenid(rsp.getString("user_id"));
                    String access_token = rsp.getString("access_token");
                    applicationUserDO.setAccessToken(access_token);
                    String scope = "";
                    if(access_token.startsWith("authbse")){
                        scope = "auth_base";
                    }
                    if(access_token.startsWith("authusr")){
                        scope = "auth_user";
                    }
                    applicationUserDO.setScope(scope);
                    applicationUserDO.setUserSource("006002");
                    return applicationUserDO;
                }
            }
            applicationUserDO.setErrorMsg("获取user_id失败");
        } catch (Exception e) {
            e.printStackTrace();
            applicationUserDO.setErrorMsg(e.getMessage());
        }
        return applicationUserDO;
    }

    // 授权获取用户信息
    public static void oauthUerInfo(PaymentAlipayDO alipay,ApplicationUserDO applicationUserDO) {
        AlipayClient alipayClient = new DefaultAlipayClient(URL, alipay.getAppid(), alipay.getRsaPrivateKey(), "json",alipay.getCharset(), alipay.getAlipayPublicKey(), alipay.getSigntype());
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        try {
            AlipayUserInfoShareResponse userinfo = alipayClient.execute(request, applicationUserDO.getAccessToken());
            if(userinfo.isSuccess()){
                applicationUserDO.setNickName(EmojiCharacterUtil.filter(userinfo.getNickName()));
                applicationUserDO.setAvatar(userinfo.getAvatar());
                applicationUserDO.setProvince(userinfo.getProvince());
                applicationUserDO.setCity(userinfo.getCity());
                String gender = userinfo.getGender().toLowerCase();
                applicationUserDO.setGender(gender);
            }
        } catch (Exception e) {
            //处理异常
            e.printStackTrace();
        }
    }

    private static String sendRequest(ApiRequest request) throws Exception {
        try {
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(request.getUri());
            method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
            method.setRequestBody(request.getParams());
            client.getParams().setContentCharset("UTF-8");
            client.executeMethod(method);
            InputStream is = method.getResponseBodyAsStream();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] bytes = new byte[100];
            int rc;
            while ((rc = is.read(bytes, 0, 100)) > 0) {
                os.write(bytes, 0, rc);
            }
            String result = new String(os.toByteArray(), "UTF-8");
            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
