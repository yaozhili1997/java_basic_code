package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.ProductStock;
import com.ecotourism.oms.oms.domain.SpotTicketDO;
import com.ecotourism.oms.product.domain.PriceStockDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 景区门票
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-06 21:36:20
 */
@Mapper
public interface SpotTicketDao {

	SpotTicketDO get(String productNo);

	List<SpotTicketDO> queryProductsInfo(Map<String, Object> map);

	int update(ProductStock productStock);

	int updateRefundStock(ProductStock productStock);

}
