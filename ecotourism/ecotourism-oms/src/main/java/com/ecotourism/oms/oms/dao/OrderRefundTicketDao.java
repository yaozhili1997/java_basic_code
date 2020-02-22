package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.OrderRefundTicketDO;
import com.ecotourism.oms.oms.domain.RefundOrderInfoDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * 退票管理
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface OrderRefundTicketDao {
	int save(OrderRefundTicketDO orderRefundTicket);

	RefundOrderInfoDO queryRefundOrderByOrderNo(RefundOrderInfoDO refundOrderInfoDO);
}
