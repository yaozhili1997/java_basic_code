package com.ecotourism.supplier.ums.service;

import com.ecotourism.supplier.ums.domain.ShoppingAddressDO;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
public interface ShoppingAddressService {

    ShoppingAddressDO get(Integer id);

    List<ShoppingAddressDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShoppingAddressDO shoppingAddress);

    int update(ShoppingAddressDO shoppingAddress);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
