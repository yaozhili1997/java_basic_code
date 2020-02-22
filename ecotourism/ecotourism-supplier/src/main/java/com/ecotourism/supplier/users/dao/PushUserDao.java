package com.ecotourism.supplier.users.dao;

import com.ecotourism.supplier.users.domain.PushUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Mapper
public interface PushUserDao {
    List<PushUserDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    PushUserDO get(Integer id);

    int save(PushUserDO pushUser);

    int update(PushUserDO pushUser);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
