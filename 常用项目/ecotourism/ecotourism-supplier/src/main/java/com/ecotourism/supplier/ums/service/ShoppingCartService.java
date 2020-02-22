package com.ecotourism.supplier.ums.service;

import com.ecotourism.supplier.ums.domain.ShoppingCartDO;
import java.util.List;
import java.util.Map;

/**
 * 购物车表
 * 
 * @date 2018-10-26 11:34:07
 */
public interface ShoppingCartService {
	
	ShoppingCartDO get(Integer id);
	
	List<ShoppingCartDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ShoppingCartDO shoppingCart);
	
	int update(ShoppingCartDO shoppingCart);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
