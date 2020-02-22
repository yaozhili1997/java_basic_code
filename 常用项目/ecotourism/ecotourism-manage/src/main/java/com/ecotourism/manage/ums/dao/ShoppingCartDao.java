package com.ecotourism.manage.ums.dao;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.ums.domain.ShoppingCartDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 购物车表
 * @date 2018-10-26 11:34:07
 */
@Mapper
public interface ShoppingCartDao {

	ShoppingCartDO get(Integer id);
	
	List<ShoppingCartDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ShoppingCartDO shoppingCart);

	int update(ShoppingCartDO shoppingCart);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
