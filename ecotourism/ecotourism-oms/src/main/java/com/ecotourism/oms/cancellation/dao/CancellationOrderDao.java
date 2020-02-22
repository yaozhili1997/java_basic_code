package com.ecotourism.oms.cancellation.dao;

import com.ecotourism.oms.cancellation.domain.CancellationDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门票订单
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface CancellationOrderDao {

	/**
	 * 订单核销
	 * @param cancellationDO
	 * @return
	 */
	int cancellationOrder(CancellationDO cancellationDO);

	/**
	 * APP、H5订单状态
	 * @param cancellationDO
	 * @return
	 */
	int cancellationAppOrder(CancellationDO cancellationDO);

}
