package com.ecotourism.api.api.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.common.utils.R;

/**
 * 说明：创建订单
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 9:38
 **/
public interface ClientOrderService {

    /**
     * @Description 创建应用订单
     * @Author scotte
     * @Date 2018/8/23 10:23
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R createOrder(RequestVo requestVo);
    /**
     * @Description 退票处理(单个订单退票)
     * @Author scotte
     * @Date 2018/8/24 10:23
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R updateRefundOrder(RequestVo requestVo);

    /**
     * @Description 查询用户订单
     * @Author scotte
     * @Date 2018/8/31 17:57
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R listOrders(RequestVo requestVo);
    /**
     * @Description 获取最近订单中的用户信息
     * @Author scotte
     * @Date 2018/8/31 17:57
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R getOrderUserInfo(RequestVo requestVo);
    /**
     * @Description 通过订单号查询用户订单
     * @Author scotte
     * @Date 2018/8/31 17:57
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R getOrder(RequestVo requestVo);

    /**
     * @Description 获取产品当月销量
     * @Author scotte
     * @Date 2019/3/8 12:25
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R getMonthSellCount(RequestVo requestVo);
}
