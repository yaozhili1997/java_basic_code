package com.ecotourism.manage.ums.service.impl;

import com.ecotourism.manage.ums.dao.ShoppingAddressDao;
import com.ecotourism.manage.ums.domain.ShoppingAddressDO;
import com.ecotourism.manage.ums.service.ShoppingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Service
public class ShoppingAddressServiceImpl implements ShoppingAddressService {

    @Autowired
    private ShoppingAddressDao shoppingAddressDao;


    public ShoppingAddressDO get(Integer id){
        return shoppingAddressDao.get(id);
    }

    @Override
    public List<ShoppingAddressDO> list(Map<String, Object> map){
        return shoppingAddressDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return shoppingAddressDao.count(map);
    }

    @Override
    public int save(ShoppingAddressDO shoppingAddress){
        shoppingAddress.setCrateTime(new Date());
        return shoppingAddressDao.save(shoppingAddress);
    }

    @Override
    public int update(ShoppingAddressDO shoppingAddress){
        shoppingAddress.setUpdateTime(new Date());
        return shoppingAddressDao.update(shoppingAddress);
    }

    @Override
    public int remove(Integer id){
        return shoppingAddressDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids){
        return shoppingAddressDao.batchRemove(ids);
    }
}
