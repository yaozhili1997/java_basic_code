package com.ecotourism.manage.ums.dao;

import com.ecotourism.manage.ums.domain.ShoppingAddressOrderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Mapper
public interface ShoppingAddressOrderDao {

    ShoppingAddressOrderDO get(Integer id);


    int count(Map<String, Object> map);

    List<ShoppingAddressOrderDO> list(Map<String, Object> map);


    int save(ShoppingAddressOrderDO shoppingAddressOrder);

    int update(ShoppingAddressOrderDO shoppingAddressOrder);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
