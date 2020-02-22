package com.ecotourism.mobile.mobile.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.mobile.common.config.OrderApiUrlConfig;
import com.ecotourism.mobile.common.controller.BaseController;
import com.ecotourism.mobile.common.utils.HttpUtils;
import com.ecotourism.mobile.mobile.domain.PaymentAlipayDO;
import com.ecotourism.mobile.mobile.domain.PaymentWechatDO;
import com.ecotourism.mobile.mobile.service.PaymentAlipayService;
import com.ecotourism.mobile.mobile.service.PaymentWechatService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private OrderApiUrlConfig orderApiUrlConfig;

    @Autowired
    private PaymentWechatService paymentWechatService;

    @Autowired
    private PaymentAlipayService paymentAlipayService;

    @RequestMapping({"/wx/login"})
    public String wxLogin(HttpServletResponse response) {
        String echostr = request.getParameter("echostr");
        if (StringUtils.isNotEmpty(echostr)) {
            try {
                response.getWriter().write(echostr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String code = request.getParameter("code");
//            String uri = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + wxAppConfig.getAppID() +"&secret=" + wxAppConfig.getAppsecret() + "&code=" + code + "&grant_type=authorization_code";
            try {
                JSONObject param = new JSONObject();
                param.put("code", code);
                String result = HttpUtils.postJson(orderApiUrlConfig.getWechatUserinfo(), param.toString());
                return checkResult(result, LOGIN_PLATFORM_WX, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping({"/wx/auth"})
    public void wxAuth(HttpServletResponse response) {
        PaymentWechatDO paymentWechatDO = paymentWechatService.getPaymentWechatByUserNo(orderApiUrlConfig.getApplicationNo());
        String authUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + paymentWechatDO.getAppId() + "&redirect_uri=" + paymentWechatDO.getRedirectUri() + "&response_type=code&scope=snsapi_userinfo&state=auth#wechat_redirect";
        try {
            response.sendRedirect(authUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping({"/alipay/login"})
    public String alipayLogin(HttpServletResponse response) {
        String code = request.getParameter("auth_code");
        if (StringUtils.isNotEmpty(code)) {
            try {
                JSONObject param = new JSONObject();
                param.put("auth_code", code);
                String result = HttpUtils.postJson(orderApiUrlConfig.getAlipayUserinfo(), param.toString());
                return checkResult(result, LOGIN_PLATFORM_ALIPAY, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @RequestMapping({"/alipay/auth"})
    public void alipayAuth(HttpServletResponse response) {
        PaymentAlipayDO paymentAlipayDO = paymentAlipayService.getPaymentAlipayByUserNo(orderApiUrlConfig.getApplicationNo());
        String authUrl = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id=" + paymentAlipayDO.getAppid() + "&redirect_uri=" + paymentAlipayDO.getRedirectUri() + "&scope=auth_user&state=auth#alipay_redirect";
        try {
            response.sendRedirect(authUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/auth")
    public void auth(HttpServletResponse response) throws IOException {
        String header = request.getHeader("User-Agent").toLowerCase();
        if (header.contains("micromessenger")) {
            wxAuth(response);
        } else {
            alipayAuth(response);
        }
    }


    private String checkResult(String result, String platform, HttpServletResponse response) {
        if (StringUtils.isNotEmpty(result)) {
            JSONObject json = JSONObject.parseObject(result);
            if ("success".equals(json.getString("status"))) {
                String openid = json.getJSONObject("data").getString("openid");
                if (StringUtils.isNotEmpty(openid)) {
                    setLoginOpenid(openid, platform);
                    return "redirect:/index";
                } else {
                    try {
                        response.getWriter().write(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }


    @RequestMapping("/turnView")
    public void turnView(String userNo, String applicationNo, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(userNo) || StringUtils.isBlank(applicationNo)) {
            return;
        }
        String header = request.getHeader("User-Agent").toLowerCase();
        request.getSession().setAttribute("pushUserNo", userNo);
        if (header.contains("micromessenger")) {
            wxAuth(response);
        } else {
            alipayAuth(response);
        }
    }
}
