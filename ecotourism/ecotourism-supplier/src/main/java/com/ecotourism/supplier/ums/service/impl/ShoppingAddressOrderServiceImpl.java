package com.ecotourism.supplier.ums.service.impl;

import com.ecotourism.supplier.ums.dao.ShoppingAddressOrderDao;
import com.ecotourism.supplier.ums.domain.ShoppingAddressOrderDO;
import com.ecotourism.supplier.ums.service.ShoppingAddressOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Service
public class ShoppingAddressOrderServiceImpl implements ShoppingAddressOrderService{

    @Autowired
    private ShoppingAddressOrderDao shoppingAddressOrderDao;


    public ShoppingAddressOrderDO get(Integer id){
        return shoppingAddressOrderDao.get(id);
    }

    @Override
    public List<ShoppingAddressOrderDO> list(Map<String, Object> map){
        return shoppingAddressOrderDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return shoppingAddressOrderDao.count(map);
    }

    @Override
    public int save(ShoppingAddressOrderDO shoppingAddressOrder){
        shoppingAddressOrder.setCrateTime(new Date());
        return shoppingAddressOrderDao.save(shoppingAddressOrder);
    }

    @Override
    public int update(ShoppingAddressOrderDO shoppingAddressOrder){
        shoppingAddressOrder.setUpdateTime(new Date());
        return shoppingAddressOrderDao.update(shoppingAddressOrder);
    }

    @Override
    public int remove(Integer id){
        return shoppingAddressOrderDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids){
        return shoppingAddressOrderDao.batchRemove(ids);
    }
}
