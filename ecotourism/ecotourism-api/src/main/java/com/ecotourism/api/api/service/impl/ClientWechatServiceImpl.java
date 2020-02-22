package com.ecotourism.api.api.service.impl;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.order.notice.PayNoticeVo;
import com.ecotourism.api.api.domain.order.refund.RefundMoneyDo;
import com.ecotourism.api.api.domain.pay.PayBuildParams;
import com.ecotourism.api.api.domain.wechat.DecodeUserParam;
import com.ecotourism.api.api.domain.wechat.RequestgetOpenIdParam;
import com.ecotourism.api.api.service.ClientWechatService;
import com.ecotourism.api.api.util.ApiUtils;
import com.ecotourism.api.api.util.ReflexApiUtil;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.application.domain.ApplicationUserDO;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.application.service.ApplicationOrderService;
import com.ecotourism.api.application.service.ApplicationService;
import com.ecotourism.api.application.service.ApplicationUserService;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.Tools;
import com.ecotourism.api.pay.wechat.domain.WechatConfig;
import com.ecotourism.api.pay.wechat.domain.pay.WechatParams;
import com.ecotourism.api.pay.wechat.domain.pay.WechatRefundParams;
import com.ecotourism.api.pay.wechat.domain.pay.WechatUserParams;
import com.ecotourism.api.pay.wechat.util.PayConfig;
import com.ecotourism.api.pay.wechat.util.WechatUtils;
import com.ecotourism.api.pay.wechat.util.cons.WeChatCons;
import com.ecotourism.api.pay.wechat.util.sdk.WXPayUtil;
import com.ecotourism.api.payment.domain.PaymentWechatDO;
import com.ecotourism.api.payment.domain.PaymentWechatMchDO;
import com.ecotourism.api.payment.domain.PaymentWechatProviderDO;
import com.ecotourism.api.payment.service.PaymentWechatMchService;
import com.ecotourism.api.payment.service.PaymentWechatProviderService;
import com.ecotourism.api.payment.service.PaymentWechatService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：微信支付
 * 创建人：陈启勇
 * 创建时间: 2018/9/3 11:30
 **/
@Service
public class ClientWechatServiceImpl implements ClientWechatService{
    @Autowired
    private PaymentWechatMchService wechatMchService;
    @Autowired
    private PaymentWechatProviderService wechatProviderService;
    @Autowired
    private PaymentWechatService wechatService;
    @Autowired
    private ApplicationUserService applicationUserService;
    @Autowired
    private ApplicationOrderService applicationOrderService;
    @Autowired
    private ApplicationService applicationService;

    /**
     * @Description 获取微信公众号参数
     * @Author scotte
     * @Date 2018/8/21 11:06
     * @Param [applicationDO]应用数据
     * @return com.ecotourism.api.payment.domain.PaymentWechatDO 微信公众号参数实体
     */
    private PaymentWechatDO getWechat(ApplicationDO applicationDO) {
        String wechatNo = applicationDO.getWechatId();
        if(StringUtils.isBlank(wechatNo)) return null;
        PaymentWechatDO wechat = wechatService.getWechat(wechatNo);//公众号参数
        if(wechat==null)return null;
        return wechat;
    }

    /**
     * @Description 获取微信商户配置
     * @Author scotte
     * @Date 2018/8/21 11:23
     * @Param [mch_no] 商户编号
     * @return com.ecotourism.api.payment.domain.PaymentWechatMchDO
     */
    private PaymentWechatMchDO getWechatMch(String mch_no){
        if(StringUtils.isBlank(mch_no)) return null;
        PaymentWechatMchDO wechatMch = wechatMchService.getWechatMch(mch_no);
        return wechatMch;
    }

    /**
     * @Description 获取微信服务商配置
     * @Author scotte
     * @Date 2018/8/21 11:23
     * @Param [provider_no] 服务商编号
     * @return com.ecotourism.api.payment.domain.PaymentWechatProviderDO
     */
    private PaymentWechatProviderDO getWechatProvider(String provider_no){
        if(StringUtils.isBlank(provider_no)) return null;
        PaymentWechatProviderDO wechatProvider = wechatProviderService.getWechatProvider(provider_no);
        return wechatProvider;
    }

    /**
     * 获取微信支付配置
     * @author: scotte
     * @create: 2018/6/21 10:00
     **/
    public PaymentWechatDO getWechatConfig(ApplicationDO applicationDO){
        PaymentWechatDO wechat = getWechat(applicationDO);
        if(wechat!=null){
            PaymentWechatMchDO wechatMch = getWechatMch(wechat.getMchNo());
            WechatConfig wechatConfig = new WechatConfig();
            wechatConfig.setKey(wechatMch.getPrivateKey());
            wechatConfig.setCertLocalPath(wechatMch.getCertLocalPath());
            wechatConfig.setCertPassword(wechatMch.getCertPassword());
            wechatConfig.setBase_url(wechatMch.getBaseUrl());
            wechatConfig.setMuchId(wechatMch.getMchId());
            if(wechatMch!=null){
                PaymentWechatProviderDO wechatProvider = getWechatProvider(wechatMch.getProviderNo());
                if(wechatProvider!=null){
                    wechatConfig.setKey(wechatProvider.getPrivateKey());
                    wechatConfig.setCertLocalPath(wechatProvider.getCertLocalPath());
                    wechatConfig.setCertPassword(wechatProvider.getCertPassword());
                    wechatConfig.setBase_url(wechatProvider.getBaseUrl());
                    wechatConfig.setAppid(wechatProvider.getAppId());
                    wechatConfig.setProvider(true);
                    wechatConfig.setMuchId(wechatProvider.getMchId());
                    wechatConfig.setSubMchId(wechatMch.getMchId());
                }
            }
            wechat.setWechatConfig(wechatConfig);
        }
        return wechat;
    }
    /**
     * @Description 微信小程序获取openId
     * @Author scotte
     * @Date 2018/8/21 15:22
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    @Transactional
    public R getWechatOpenId(RequestVo requestVo){
        ApplicationDO applicationDO = requestVo.getApplicationDO();
        RequestgetOpenIdParam dataParam = ApiUtils.getRequestVoDataObject(requestVo, RequestgetOpenIdParam.class);
        PaymentWechatDO wechat = getWechat(applicationDO);
        if(wechat==null)return R.error(ApiEnum.wechatNull.code,ApiEnum.wechatNull.msg);
        ApplicationUserDO applicationUser = WechatUtils.getOpenId(dataParam.getCode(), wechat);
        if(!applicationUser.isCode())return R.error(ApiEnum.wechatGetOpenidError.code,applicationUser.getErrorMsg()).setUseMsg(false);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("openid",applicationUser.getOpenid());
        int count = applicationUserService.count(map);
        if(count>0){
            applicationUserService.update(applicationUser);
        }else{
            applicationUser.setUserSource(WeChatCons.WECHAT);
            applicationUserService.save(applicationUser);
        }
        return R.ok(applicationUser);
    }
    /**
     * @Description 微信小程序解密用户信息
     * @Author scotte
     * @Date 2018/8/21 15:23
     * @Param [requestVo]
     * @return void
     */
    @Transactional
    public R updateDecodeUserInfo(RequestVo requestVo){
        DecodeUserParam param = ApiUtils.getRequestVoDataObject(requestVo, DecodeUserParam.class);
        R r = ReflexApiUtil.checkByReflex(param);
        if(!r.isSuccess()){
            return r;
        }
        ApplicationUserDO user = applicationUserService.get(param.getOpenId());
        if(user==null){
            return R.error(ApiEnum.wechatUserNull.code,ApiEnum.wechatUserNull.msg);
        }
        user = WechatUtils.decodeUserInfo(param.getEncryptedData(), param.getIv(), user.getSessionKey());
        if(user!=null){
            applicationUserService.update(user);
            return R.ok();
        }
        return R.error(ApiEnum.wechatUserDecodeError.code,ApiEnum.wechatUserDecodeError.msg);
    }
    /**
     * @Description 解密获取用户信息
     * @Author scotte
     * @Date 2018/10/8 14:13
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    @Transactional
    public R getUserinfo(RequestVo requestVo){
        RequestgetOpenIdParam param = (RequestgetOpenIdParam) requestVo.getParamsVo();
        PaymentWechatDO wechat = getWechat(requestVo.getApplicationDO());
        if(wechat==null){
            return R.error(ApiEnum.wechatNull.code,ApiEnum.wechatNull.msg);
        }
        ApplicationUserDO applicationUserDO = WechatUtils.wechatOauth(param.getCode(), wechat);
        if(!applicationUserDO.isCode()){
            return R.error(ApiEnum.wechatGetOpenidError.code,applicationUserDO.getErrorMsg()).setUseMsg(false);
        }
        ApplicationUserDO applicationUserDO1 = applicationUserService.get(applicationUserDO.getOpenid());
        if(applicationUserDO1==null){
            applicationUserDO.setApplicationNo(requestVo.getApplicationNo());
            if("snsapi_userinfo".equals(applicationUserDO.getScope())){
                applicationUserDO = WechatUtils.getWeiXinUserInfo(applicationUserDO);
            }
            String nickName = applicationUserDO.getNickName();
            if(StringUtils.isBlank(nickName)){
                applicationUserDO.setNickName("微信用户");
            }
            applicationUserService.save(applicationUserDO);
            return R.ok(applicationUserDO);
        }
        return R.ok(applicationUserDO1);
    }


    /**
     * @Description 创建微信支付
     * @Author scotte
     * @Date 2018/8/23 17:43
     * @Param [orders, requestVo]
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    public R buildWechatPayResult(PayBuildParams payBuildParams, RequestVo requestVo){
        WechatUserParams wechatUserParams = new WechatUserParams();
        HttpServletRequest req = requestVo.getRequest();
        ApplicationDO applicationDO = requestVo.getApplicationDO();
        wechatUserParams.setSpbill_create_ip(req.getRemoteAddr());// 用户终端IP
        wechatUserParams.setNotify_url(applicationDO.getNoticeBaseUrl()+"app/clientHelper/payNotice/wechatNotice?appNo="+requestVo.getApplicationNo());
        wechatUserParams.setTrade_type("JSAPI");// 交易类型
        OrderResult order = payBuildParams.getOrder();
        BigDecimal totalPrice = order.getTotalAmount();
        wechatUserParams.setBody(payBuildParams.getBody());
        wechatUserParams.setOut_trade_no(order.getOrderNo());
        wechatUserParams.setOpenid(order.getOpenId());
        wechatUserParams.setDetail(payBuildParams.getJsonDetail());
        wechatUserParams.setTotal_fee(totalPrice.multiply(new BigDecimal(100)).intValue());
        //获取应用微信支付相关参数
        PaymentWechatDO wechatConfig = getWechatConfig(applicationDO);
        //参数支付组装
        WechatParams wechatPayParams = PayConfig.getWechatPayParams(wechatUserParams, wechatConfig);
        R r = PayConfig.weChatUnifiedOrder(wechatPayParams, wechatConfig);
        return r;
    }
    /**
     * @Description 微信退款
     * @Author scotte
     * @Date 2018/9/7 17:17
     * @Param [refundMoneyDo, requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R buildWechatRefundResult(RefundMoneyDo refundMoneyDo, RequestVo requestVo){
        WechatRefundParams wechatRefundParams = new WechatRefundParams();
        wechatRefundParams.setOut_trade_no(refundMoneyDo.getOrderNo());
        // 商户退款单号
        wechatRefundParams.setOut_refund_no("refund" + new Date().getTime()+ Tools.getRandomString(13));
        BigDecimal totalprice = refundMoneyDo.getTotalAmount();
        BigDecimal refundMoney = refundMoneyDo.getRefundAmount();
        wechatRefundParams.setRefund_fee(refundMoney.multiply(new BigDecimal(100)).intValue());
        wechatRefundParams.setTotal_fee(totalprice.multiply(new BigDecimal(100)).intValue());
        PayConfig payConfig = new PayConfig();
        PaymentWechatDO wechatConfig = getWechatConfig(requestVo.getApplicationDO());
        wechatRefundParams = payConfig.getWechatRefundParams(wechatRefundParams,wechatConfig);
        return PayConfig.weChatRefund(wechatRefundParams,wechatConfig);
    }

    /**
     * @Description 微信支付通知处理
     * @Author scotte
     * @Date 2018/8/24 15:01
     * @Param [req]
     * @return com.ecotourism.api.common.utils.R
     */
    public R wechatNotice(RequestVo requestVo){
        StringBuffer xmlStr = new StringBuffer();
        HttpServletRequest req = requestVo.getRequest();
        BufferedReader reader =null;
        String result = "";
        try {
            reader = req.getReader();
            String line = null;
            while ((line = reader.readLine()) != null) {
                xmlStr.append(line);
            }
            String xml = xmlStr.toString();
            Map<String, String> map = WXPayUtil.xmlToMap(xml);
            if (map != null) {
                String applicationNo = map.get("appNo");
                if(StringUtils.isBlank(applicationNo)){
                    return R.error(ApiEnum.wechatNoticeError.code,"微信通知，应用参数为空!").setUseMsg(false);
                }
                if ("SUCCESS".equals(map.get("return_code"))) {
                    if ("SUCCESS".equals(map.get("result_code"))) {
                        String out_trade_no = map.get("out_trade_no");
                        if (StringUtils.isNotBlank(out_trade_no)) {
                            OrderResult order = applicationOrderService.getNotPayByOrderNo(out_trade_no,applicationNo);
                            if (order != null && order.getOrders().size() > 0) {
                                order.setPayType("006001");
                                requestVo.setApplicationNo(applicationNo);
                                R r = applicationService.getApplication(order.getApplicationNo());
                                if (!r.isSuccess()) return r;
                                ApplicationDO app = (ApplicationDO) r.getObj();
                                requestVo.setApplicationDO(app);
                                if (app != null) {
                                    PaymentWechatDO wechatConfig = getWechatConfig(app);
                                    if (wechatConfig != null) {
                                        // 检查xml是否有效
                                        boolean flag = WXPayUtil.isSignatureValid(xml, wechatConfig.getWechatConfig().getKey());
                                        if (flag) {
                                            applicationOrderService.updatePayStatusSuccessByOrderNo(out_trade_no,order.getPayType(),applicationNo);
                                            String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort();
                                            PayNoticeVo payNoticeVo = new PayNoticeVo();
                                            payNoticeVo.setBasePath(basePath);
                                            payNoticeVo.setApp(app);
                                            payNoticeVo.setOrder(order);
                                            payNoticeVo.setOutTradeNo(out_trade_no);
                                            payNoticeVo.setTotalAmount(Integer.valueOf(map.get("total_fee")));
                                            payNoticeVo.setOpenId(map.get("openid") == null ? "" : map.get("openid").toString());
                                            r = applicationOrderService.updateOrderByPaySuccess(payNoticeVo);
                                            if (!r.isSuccess()) return r;
                                            return R.ok(WXPayUtil.getOkResultXml()); // 告诉微信服务器，我收到信息了
                                        } else {
                                            result = "支付失败！微信返回xml不合法！";
                                        }
                                    }
                                }
                            }else {return R.ok(WXPayUtil.getOkResultXml());} // 告诉微信服务器，我收到信息了
                        } else {
                            result = map.get("out_trade_no") + ":支付失败！" + map.get("err_code_des");
                        }
                    } else {
                        result = map.get("out_trade_no") + ":支付失败！" + map.get("return_msg");
                    }
                }
            }
        } catch (Exception e) {
            result = ApiUtils.getExceptionString(e);
            return R.error(ApiEnum.wechatNoticeError.code,result).setUseMsg(false);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return R.error(ApiEnum.wechatNoticeError.code,result);
    }

}
