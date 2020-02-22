package com.ecotourism.supplier.ums.dao;

import com.ecotourism.supplier.ums.domain.ShoppingAddressDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Mapper
public interface ShoppingAddressDao {

    ShoppingAddressDO get(Integer id);


    int count(Map<String, Object> map);

    List<ShoppingAddressDO> list(Map<String, Object> map);


    int save(ShoppingAddressDO userOrder);

    int update(ShoppingAddressDO userOrder);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
