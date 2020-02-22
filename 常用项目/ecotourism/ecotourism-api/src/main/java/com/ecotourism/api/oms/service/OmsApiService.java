package com.ecotourism.api.oms.service;

import com.ecotourism.api.api.domain.order.create.OrderRequestParam;
import com.ecotourism.api.api.domain.order.notice.PayNoticeVo;
import com.ecotourism.api.application.domain.DistributionDO;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.oms.domain.RefundFromOmsDo;


/**
 * 说明：oms下单
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 15:15
 **/
public interface OmsApiService {
	/**
	 * @Description 到oms检测是否可下单
	 * @author 陈启勇
	 * @Date 2018/8/23 16:16
	 * @Param [params, distribution]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R checkCreateOrder(OrderRequestParam params, DistributionDO distribution);
	/**
	 * @Description 到oms下单
	 * @author 陈启勇
	 * @Date 2018/8/23 16:16
	 * @Param [params, distribution]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R createOrder(OrderResult order, PayNoticeVo payNoticeVo);
	/**
	 * @Description 退票
	 * @author 陈启勇
	 * @Date 2018/9/7 16:11
	 * @Param [refundFromOms, distribution]
	 * @return com.alibaba.fastjson.JSONObject
	 */
	R refundOrder(RefundFromOmsDo refundFromOms, DistributionDO distribution);
}
