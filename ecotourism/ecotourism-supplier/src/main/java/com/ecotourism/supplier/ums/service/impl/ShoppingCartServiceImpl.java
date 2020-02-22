package com.ecotourism.supplier.ums.service.impl;

import com.ecotourism.supplier.ums.dao.ShoppingCartDao;
import com.ecotourism.supplier.ums.domain.ShoppingCartDO;
import com.ecotourism.supplier.ums.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Override
	public ShoppingCartDO get(Integer id){
		return shoppingCartDao.get(id);
	}
	
	@Override
	public List<ShoppingCartDO> list(Map<String, Object> map){
		return shoppingCartDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return shoppingCartDao.count(map);
	}
	
	@Override
	public int save(ShoppingCartDO shoppingCart){
		return shoppingCartDao.save(shoppingCart);
	}

	@Override
	public int update(ShoppingCartDO shoppingCart){
		return shoppingCartDao.update(shoppingCart);
	}
	
	@Override
	public int remove(Integer id){
		return shoppingCartDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return shoppingCartDao.batchRemove(ids);
	}
	
}
