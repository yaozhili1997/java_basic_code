package com.ecotourism.manage.users.service;

import com.ecotourism.manage.users.domain.PushUserDO;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
public interface PushUserService {
    List<PushUserDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    PushUserDO get(Integer id);

    int save(PushUserDO pushUser);

    int update(PushUserDO pushUser);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    File downLoadQr(Integer id);
}
