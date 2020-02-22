package com.ecotourism.api.api.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.alipay.AlipayUserInfo;
import com.ecotourism.api.api.domain.order.notice.PayNoticeVo;
import com.ecotourism.api.api.domain.order.refund.RefundMoneyDo;
import com.ecotourism.api.api.domain.pay.PayBuildParams;
import com.ecotourism.api.api.service.ClientAlipayService;
import com.ecotourism.api.api.util.ApiUtils;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.application.domain.ApplicationUserDO;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.application.service.ApplicationOrderService;
import com.ecotourism.api.application.service.ApplicationService;
import com.ecotourism.api.application.service.ApplicationUserService;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.pay.alipay.util.AlipayUtil;
import com.ecotourism.api.payment.domain.PaymentAlipayDO;
import com.ecotourism.api.payment.service.PaymentAlipayService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 说明：支付宝相关
 * 创建人：陈启勇
 * 创建时间: 2018/9/3 11:37
 **/
@Service
public class ClientAlipayServiceImpl implements ClientAlipayService{
    @Autowired
    private PaymentAlipayService alipayService;
    @Autowired
    private ApplicationOrderService applicationOrderService;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ApplicationUserService applicationUserService;
    /**
     * @Description 获取支付宝参数
     * @Author scotte
     * @Date 2018/8/21 10:47
     * @Param [applicationDO] 应用数据
     * @return com.ecotourism.api.payment.domain.PaymentAlipayDO 支付宝支付参数实体
     */
    public PaymentAlipayDO getAliPay(ApplicationDO applicationDO){
        String alipayId = applicationDO.getAlipayId();
        if(StringUtils.isBlank(alipayId)) return null;
        PaymentAlipayDO alipayDO = alipayService.getAlipayDO(alipayId);
        if(alipayDO==null)return null;
        return alipayDO;
    }
    /**
     * @Description 获取用户信息
     * @Author scotte
     * @Date 2018/10/8 16:19
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    @Transactional
    public R getUserInfo(RequestVo requestVo){
        AlipayUserInfo param = (AlipayUserInfo) requestVo.getParamsVo();
        PaymentAlipayDO aliPay = getAliPay(requestVo.getApplicationDO());
        ApplicationUserDO oauth = AlipayUtil.oauth(param.getAuth_code(), aliPay);
        if(!oauth.isCode()){
            return R.error(ApiEnum.alipayGetOpenidError.code,oauth.getErrorMsg()).setUseMsg(false);
        }
        ApplicationUserDO applicationUserDO = applicationUserService.get(oauth.getOpenid());
        if(applicationUserDO!=null)return R.ok(applicationUserDO);
        oauth.setApplicationNo(requestVo.getApplicationNo());
        if("auth_user".equals(oauth.getScope())){
            AlipayUtil.oauthUerInfo(aliPay,oauth);
        }
        String nickName = oauth.getNickName();
        if(StringUtils.isBlank(nickName)){
            oauth.setNickName("支付宝用户");
        }
        applicationUserService.save(oauth);
        return R.ok(oauth);
    }

    /**
     * @Description 创建支付宝订单
     * @Author scotte
     * @Date 2018/9/4 9:40
     * @Param [order, requestVo]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public R buildAlipayPayResult(PayBuildParams payBuildParams, RequestVo requestVo){
        ApplicationDO applicationDO = requestVo.getApplicationDO();
        PaymentAlipayDO aliPay = getAliPay(applicationDO);
        if(aliPay==null) return R.error(ApiEnum.alipayNull.code,ApiEnum.alipayNull.msg);
        try {
            // 商户订单号，商户网站订单系统中唯一订单号，必填
            // 订单名称，必填
            String subject = payBuildParams.getBody();
            // 超时时间 可空
            String timeout_express = "2m";
            // 销售产品码 必填
            String product_code = "QUICK_WAP_PAY";
            // String out_trade_no = "";
            /**********************/
            // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
            // 调用RSA签名方式
            AlipayClient client = new DefaultAlipayClient(aliPay.getDomain(),
                    aliPay.getAppid(), aliPay.getRsaPrivateKey(),
                    aliPay.getFormat(), aliPay.getCharset(),
                    aliPay.getAlipayPublicKey(),aliPay.getSigntype());
            AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();
            // 封装请求支付信息
            AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
            model.setOutTradeNo(payBuildParams.getOrderNo());
            model.setSubject(subject);
            OrderResult order = payBuildParams.getOrder();
            model.setTotalAmount(order.getTotalAmount().toString());
            model.setBody(payBuildParams.getBody());
            model.setTimeoutExpress(timeout_express);
            model.setProductCode(product_code);
            ExtendParams extendParams = new ExtendParams();
            extendParams.setSysServiceProviderId(aliPay.getSysserviceproviderid());//系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
            model.setExtendParams(extendParams);
            alipay_request.setBizModel(model);
            //必填，不能修改
            //服务器异步通知页面路径
            String applicationNo = requestVo.getApplicationNo();
            String notify_url = applicationDO.getNoticeBaseUrl() + "app/clientHelper/payNotice/alipayNotice?appNo="+applicationNo;
            //需http://格式的完整路径，不能加?id=123这类自定义参数
            //页面跳转同步通知页面路径
            String return_url = applicationDO.getNoticeBaseUrl() + "app/clientHelper/payNotice/alipayPayReturn?appNo="+applicationNo;
            // 设置异步通知地址
            alipay_request.setNotifyUrl(notify_url);
            // 设置同步地址
            alipay_request.setReturnUrl(return_url);
            // form表单生产 调用SDK生成表单
            String form = client.pageExecute(alipay_request).getBody();
            return R.ok(form);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(ApiEnum.alipayPayError.code,e.getMessage()).setUseMsg(false);
        }
    }
    /**
     * @Description 支付宝通知接口
     * @Author scotte
     * @Date 2018/9/6 16:23
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R payNotify(RequestVo requestVo) {
        HttpServletRequest request = requestVo.getRequest();
        try {
            //获取支付宝POST过来反馈信息
            Map<String,String> params = new HashMap<String,String>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
                params.put(name, valueStr);
            }
            String applicationNo = params.get("appNo");
            params.remove("appNo");
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            //String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            //计算得出通知验证结果
            OrderResult order = applicationOrderService.getNotPayByOrderNo(out_trade_no,applicationNo);
            if (order != null && order.getOrders().size() > 0) {
                order.setPayType("006002");
                R r = applicationService.getApplication(applicationNo);
                if (!r.isSuccess()) return r;
                ApplicationDO app = (ApplicationDO) r.getObj();
                if (app != null) {
                    PaymentAlipayDO aliPay = getAliPay(app);
                    if (aliPay != null) {
                        boolean verify_result =AlipaySignature.rsaCheckV1(params, aliPay.getAlipayPublicKey(), aliPay.getCharset(),aliPay.getSigntype());
                        if(verify_result){//验证成功
                            //////////////////////////////////////////////////////////////////////////////////////////
                            //请在这里加上商户的业务逻辑程序代码
                            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
                            if(trade_status.equals("TRADE_FINISHED")){
                                //判断该笔订单是否在商户网站中已经做过处理
                                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                                //如果有做过处理，不执行商户的业务程序

                                //注意：
                                //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                                //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                            } else if (trade_status.equals("TRADE_SUCCESS")){
                                //判断该笔订单是否在商户网站中已经做过处理
                                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                                //如果有做过处理，不执行商户的业务程序

                                //注意：
                                //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
                                // 做业务逻辑
                                applicationOrderService.updatePayStatusSuccessByOrderNo(out_trade_no,order.getPayType(),applicationNo);
                                String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
                                PayNoticeVo payNoticeVo = new PayNoticeVo();
                                payNoticeVo.setBasePath(basePath);
                                payNoticeVo.setApp(app);
                                payNoticeVo.setOrder(order);
                                payNoticeVo.setTradeNo(params.get("trade_no"));
                                payNoticeVo.setOutTradeNo(out_trade_no);
                                String total_amount = params.get("total_amount");
                                int totalPrice = new BigDecimal(total_amount).multiply(new BigDecimal(100)).intValue();
                                payNoticeVo.setTotalAmount(totalPrice);
                                payNoticeVo.setOpenId(params.get("buyer_id") == null ? "" : params.get("buyer_id").toString());
                                r = applicationOrderService.updateOrderByPaySuccess(payNoticeVo);
                                if (!r.isSuccess()) return r;
                            }
                            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                            return R.ok("success");
                            //////////////////////////////////////////////////////////////////////////////////////////
                        } else {//验证失败
                            return R.error(ApiEnum.alipayNoticeSignError.code,ApiEnum.alipayNoticeSignError.msg);
                        }
                    }
                }
            }
            return R.error(ApiEnum.alipayNoticeError.code,ApiEnum.alipayNoticeError.msg);
        } catch (Exception e) {
            return R.error(ApiEnum.alipayNoticeError.code,e.getMessage()).setUseMsg(false);
        }
    }
    /**
     * @Description 支付成功跳转
     * @Author scotte
     * @Date 2018/9/7 9:56
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R payReturn(RequestVo requestVo) {
        try {
            HttpServletRequest request = requestVo.getRequest();
            //PrintWriter out = response.getWriter();
            //获取支付宝GET过来反馈信息
            Map<String,String> params = new HashMap<String,String>();
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }
            String applicationNo = params.get("appNo");
            params.remove("appNo");
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
            //商户订单号
            //String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            //String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
            //计算得出通知验证结果
            OrderResult order = applicationOrderService.getOrder(params.get("out_trade_no"),applicationNo,"",null,null);
            if(order!=null){
                R r = applicationService.getApplication(applicationNo);
                if (!r.isSuccess()) return r;
                ApplicationDO app = (ApplicationDO) r.getObj();
                PaymentAlipayDO aliPay = getAliPay(app);
                boolean verify_result = AlipaySignature.rsaCheckV1(params, aliPay.getAlipayPublicKey(),aliPay.getCharset(), aliPay.getSigntype());
                if(verify_result){//验证成功
                    //请在这里加上商户的业务逻辑程序代码
                    //该页面可做页面美工编辑
                    Thread.sleep(1000);
                    return R.ok(aliPay.getReturnUrl()+order.getOrderNo());
                    //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                    //////////////////////////////////////////////////////////////////////////////////////////
                } else {
                    //该页面可做页面美工编辑
                    return R.error(ApiEnum.alipayPayReturnSignError.code,ApiEnum.alipayPayReturnSignError.msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error(ApiEnum.alipayPayReturnError.code,ApiEnum.alipayPayReturnError.msg);
    }
    /**
     * @Description 支付宝退款
     * @Author scotte
     * @Date 2018/9/7 14:44
     * @Param [refundMoneyDo, requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R refundMoney(RefundMoneyDo refundMoneyDo, RequestVo requestVo){
        //商户订单号和支付宝交易号不能同时为空。 trade_no、  out_trade_no如果同时存在优先取trade_no
        //商户订单号，和支付宝交易号二选一
        String out_trade_no = refundMoneyDo.getOrderNo();
        //退款金额，不能大于订单总金额
        String refund_amount=refundMoneyDo.getRefundAmount().toString();
        //退款的原因说明
        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
        String out_request_no=refundMoneyDo.getOutRefundNo();
        /**********************/
        // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
        PaymentAlipayDO aliPay = getAliPay(requestVo.getApplicationDO());
        AlipayClient client = new DefaultAlipayClient(aliPay.getDomain(),aliPay.getAppid(), aliPay.getRsaPrivateKey(),aliPay.getFormat(),aliPay.getCharset(), aliPay.getAlipayPublicKey(),aliPay.getSigntype());
        AlipayTradeRefundRequest alipay_request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel model=new AlipayTradeRefundModel();
        model.setOutTradeNo(out_trade_no);
        model.setRefundAmount(refund_amount);
        model.setRefundReason(refundMoneyDo.getRefundMsg());
        model.setOutRequestNo(out_request_no);
        alipay_request.setBizModel(model);
        AlipayTradeRefundResponse alipay_response = null;
        try {
            alipay_response = client.execute(alipay_request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return R.error(ApiEnum.alipayRefundError.code, ApiUtils.getExceptionString(e)).setUseMsg(false);
        }
        if(alipay_response.isSuccess()){
            return R.ok();
        } else {
            return R.error(ApiEnum.alipayRefundError.code,ApiEnum.alipayRefundError.msg);
        }
    }
}
