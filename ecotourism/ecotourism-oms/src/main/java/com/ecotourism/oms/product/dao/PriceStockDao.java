package com.ecotourism.oms.product.dao;

import com.ecotourism.oms.product.domain.PriceStockDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 产品价格库存日历表
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-12-18 09:10:33
 */
@Mapper
public interface PriceStockDao {

	PriceStockDO get(Integer id);
	
	List<PriceStockDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PriceStockDO priceStock);
	
	int update(PriceStockDO priceStock);

	int updateRefundStock(PriceStockDO priceStock);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
