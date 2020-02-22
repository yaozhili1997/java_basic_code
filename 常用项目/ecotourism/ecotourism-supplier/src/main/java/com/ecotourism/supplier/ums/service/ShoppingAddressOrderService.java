package com.ecotourism.supplier.ums.service;

import com.ecotourism.supplier.ums.domain.ShoppingAddressOrderDO;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
public interface ShoppingAddressOrderService {

    ShoppingAddressOrderDO get(Integer id);

    List<ShoppingAddressOrderDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShoppingAddressOrderDO shoppingAddressOrder);

    int update(ShoppingAddressOrderDO userOrder);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
