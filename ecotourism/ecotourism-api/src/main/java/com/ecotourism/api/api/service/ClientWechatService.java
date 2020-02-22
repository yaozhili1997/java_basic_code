package com.ecotourism.api.api.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.order.refund.RefundMoneyDo;
import com.ecotourism.api.api.domain.pay.PayBuildParams;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.payment.domain.PaymentWechatDO;

/**
 * 说明：微信相关
 * 创建人：陈启勇
 * 创建时间: 2018/9/3 11:30
 **/
public interface ClientWechatService {
    /**
     * 获取微信支付配置
     * @author: scotte
     * @create: 2018/6/21 10:00
     **/
    PaymentWechatDO getWechatConfig(ApplicationDO applicationDO);
    /**
     * @Description 微信小程序获取openId
     * @Author scotte
     * @Date 2018/8/21 15:22
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R getWechatOpenId(RequestVo requestVo);
    /**
     * @Description 微信小程序解密用户信息
     * @Author scotte
     * @Date 2018/8/21 15:23
     * @Param [requestVo]
     * @return void
     */
    R updateDecodeUserInfo(RequestVo requestVo);
    /**
     * @Description 解密获取用户信息
     * @Author scotte
     * @Date 2018/10/8 14:13
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R getUserinfo(RequestVo requestVo);
    /**
     * @Description 创建微信支付
     * @Author scotte
     * @Date 2018/8/23 17:43
     * @Param [orders, requestVo]
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    R buildWechatPayResult(PayBuildParams payBuildParams, RequestVo requestVo);

    /**
     * @Description 微信支付通知处理
     * @Author scotte
     * @Date 2018/8/24 15:01
     * @Param [req]
     * @return com.ecotourism.api.common.utils.R
     */
    R wechatNotice(RequestVo requestVo);
    /**
     * @Description 微信退款
     * @Author scotte
     * @Date 2018/9/7 17:17
     * @Param [refundMoneyDo, requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R buildWechatRefundResult(RefundMoneyDo refundMoneyDo, RequestVo requestVo);
}
