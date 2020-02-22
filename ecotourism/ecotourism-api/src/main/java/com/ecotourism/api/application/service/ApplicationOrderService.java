package com.ecotourism.api.application.service;

import com.ecotourism.api.api.domain.order.create.AddressParams;
import com.ecotourism.api.api.domain.order.notice.PayNoticeVo;
import com.ecotourism.api.api.domain.order.query.QueryOrderListRequestParams;
import com.ecotourism.api.application.domain.ApplicationOrderDO;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.common.utils.R;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 应用订单
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:00:53
 */
public interface ApplicationOrderService {

	int save(ApplicationOrderDO applicationOrder);
	int saveOrderAddress(AddressParams addressParams);
	/**
	 * @Description 获取产品当月销量
	 * @author 陈启勇
	 * @Date 2019/3/8 12:18
	 * @Param [productNo]
	 * @return int
	 */
	int findOrderCountByProduct(String productNo);
	/**
	 * @Description 根据订单号修改订单支付状态为已支付
	 * @author 陈启勇
	 * @Date 2018/9/5 17:11
	 * @Param [orderNo]
	 * @return int
	 */
	int updatePayStatusSuccessByOrderNo(String orderNo,String payType,String applicationNo);
	/**
	 * @Description 支付成功,订单处理
	 * @author 陈启勇
	 * @Date 2018/8/24 11:02
	 * @Param [payNoticeVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R updateOrderByPaySuccess(PayNoticeVo payNoticeVo);
	/**
	 * @Description 从oms退单成功返回结果
	 * @author 陈启勇
	 * @Date 2018/9/7 17:12
	 * @Param [applicationOrder]
	 * @return int
	 */
	int updateOrderByOmsRefundResult(ApplicationOrderDO applicationOrder);
    /**
     * @Description 修改退款状态：退款失败
     * @author 陈启勇
     * @Date 2018/10/17 16:22
     * @Param [applicationOrder]
     * @return int
     */
    int updateRefundStatusByRefundMoney(ApplicationOrderDO applicationOrder);
	/**
	 * @Description 查询订单列表，带分页
	 * @author 陈启勇
	 * @Date 2018/9/3 10:29
	 * @Param [param]
	 * @return java.util.List<com.ecotourism.api.application.domain.OrderResult>
	 */
	List<OrderResult> listOrdersResult(QueryOrderListRequestParams param);
	/**
	 * @Description 通过订单号获取
	 * @author 陈启勇
	 * @Date 2018/9/3 11:13
	 * @Param [param]
	 * @return com.ecotourism.api.application.domain.OrderResult
	 */
	OrderResult getOrder(String orderNo,String applicationNo,String openId,String productNo,String subOrderNo);
	/**
	 * @Description 通过订单号获取未支付订单
	 * @author 陈启勇
	 * @Date 2018/9/5 17:07
	 * @Param [orderNo]
	 * @return com.ecotourism.api.application.domain.OrderResult
	 */
	OrderResult getNotPayByOrderNo(String orderNo,String applicationNo);

	/**
	 * @Description 获取最近订单中的用户信息
	 * @author 陈启勇
	 * @Date 2018/9/7 14:12
	 * @Param [openId]
	 * @return com.ecotourism.api.application.domain.ApplicationOrderDO
	 */
	ApplicationOrderDO getOrderUserInfo(String openId);
	/**
	 * @Description 获取不重复订单号
	 * @author 陈启勇
	 * @Date 2018/11/5 11:30
	 * @Param [applicationNo]
	 * @return java.lang.String
	 */
	String getOrderNo(String applicationNo);
}
