package com.ecotourism.api.application.dao;

import com.ecotourism.api.api.domain.order.create.AddressParams;
import com.ecotourism.api.api.domain.order.query.QueryOrderListRequestParams;
import com.ecotourism.api.application.domain.ApplicationOrderDO;
import java.util.List;

import com.ecotourism.api.application.domain.OrderResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 门票订单
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:00:53
 */
@Mapper
public interface ApplicationOrderDao{

	ApplicationOrderDO findUserInfo(String openId);
	OrderResult getByOrderNo(@Param("orderNo")String orderNo,@Param("applicationNo")String applicationNo,@Param("openId")String openId,@Param("productNo")String productNo,@Param("subOrderNo")String subOrderNo);
	OrderResult getNotPayByOrderNo(@Param("orderNo")String orderNo,@Param("applicationNo")String applicationNo);
	List<OrderResult> listOrders(QueryOrderListRequestParams param);
	int findOrderCount(@Param("orderNo")String orderNo,@Param("applicationNo")String applicationNo);
	int findOrderCountByProduct(String productNo);
	int save(ApplicationOrderDO applicationOrder);
	int updateOrderByOmsResult(ApplicationOrderDO applicationOrder);
	int updateOrderByOmsRefundResult(ApplicationOrderDO applicationOrder);
	int updateRefundStatusByRefundMoney(ApplicationOrderDO applicationOrder);
	int updatePaySuccessByOrderNo(@Param("orderNo") String orderNo,@Param("payType")String payType,@Param("applicationNo")String applicationNo);
	int updateOrderByCreateOmsOrderError(@Param("orderNo")String orderNo,@Param("omsResult")String omsResult,@Param("applicationNo")String applicationNo);

	int saveOrderAddress(AddressParams addressParams);
}
