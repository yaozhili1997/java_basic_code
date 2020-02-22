package com.ecotourism.manage.product.dao;

import com.ecotourism.manage.product.domain.HotelDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 文创产品
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
@Mapper
public interface HotelDao {

	HotelDO get(Integer productId);
	
	List<HotelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HotelDO hotel);
	
	int update(HotelDO hotel);
	
	int remove(Integer product_id);
	
	int batchRemove(Integer[] productIds);
}
