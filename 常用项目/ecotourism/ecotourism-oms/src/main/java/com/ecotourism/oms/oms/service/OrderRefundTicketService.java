package com.ecotourism.oms.oms.service;

import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.RequestVo;

import java.util.List;

/**
 * 退票管理
 * 
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-11 10:23:50
 */
public interface OrderRefundTicketService {

	void saveRefundTicketLog(List<OrderSpotDO> list, RequestVo requestVo);

	void refundTicked(List<OrderSpotDO> list, RequestVo requestVo);

}
