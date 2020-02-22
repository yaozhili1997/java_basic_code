package com.ecotourism.api.api.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.order.refund.RefundMoneyDo;
import com.ecotourism.api.api.domain.pay.PayBuildParams;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.payment.domain.PaymentAlipayDO;

/**
 * @Description 支付宝相关
 * @Author scotte
 * @Date 2018/9/3 11:38
 * @Param
 * @return
 */
public interface ClientAlipayService {
    /**
     * @Description 获取支付宝参数
     * @Author scotte
     * @Date 2018/8/21 10:47
     * @Param [applicationDO] 应用数据
     * @return com.ecotourism.api.payment.domain.PaymentAlipayDO 支付宝支付参数实体
     */
    PaymentAlipayDO getAliPay(ApplicationDO applicationDO);
    /**
     * @Description 获取用户信息
     * @Author scotte
     * @Date 2018/10/8 16:19
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R getUserInfo(RequestVo requestVo);
    /**
     * @Description 创建支付宝订单
     * @Author scotte
     * @Date 2018/9/4 9:40
     * @Param [order, requestVo]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    R buildAlipayPayResult(PayBuildParams payBuildParams, RequestVo requestVo);
    /**
     * @Description 支付宝通知接口
     * @Author scotte
     * @Date 2018/9/6 16:23
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R payNotify(RequestVo requestVo);
    /**
     * @Description 支付成功跳转
     * @Author scotte
     * @Date 2018/9/7 9:56
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R payReturn(RequestVo requestVo);

    /**
     * @Description 支付宝退款
     * @Author scotte
     * @Date 2018/9/7 14:44
     * @Param [refundMoneyDo, requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R refundMoney(RefundMoneyDo refundMoneyDo, RequestVo requestVo);
}
