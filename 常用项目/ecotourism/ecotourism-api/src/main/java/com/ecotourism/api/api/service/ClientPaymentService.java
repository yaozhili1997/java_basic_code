package com.ecotourism.api.api.service;


import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.common.utils.R;

/**
 * 说明：支付服务类
 * 创建人：陈启勇
 * 创建时间: 2018/8/21 10:39
 **/
public interface ClientPaymentService {
    /**
     * @Description 创建微信支付
     * @Author scotte
     * @Date 2018/9/3 11:46
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R buildWechatResult(RequestVo requestVo);
    /**
     * @Description 创建支付宝支付
     * @Author scotte
     * @Date 2018/9/3 11:46
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R buildAlipayResult(RequestVo requestVo);
}
