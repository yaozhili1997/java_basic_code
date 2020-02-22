package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.StockDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 产品库存表
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-10-12 09:21:06
 */
@Mapper
public interface StockDao {

	StockDO findProductStock(StockDO stock);

	int updateProductStockNum(StockDO stock);
}
