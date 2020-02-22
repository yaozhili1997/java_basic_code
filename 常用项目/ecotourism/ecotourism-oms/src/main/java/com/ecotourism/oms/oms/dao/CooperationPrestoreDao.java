package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.CooperationPrestoreDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Mapper
public interface CooperationPrestoreDao {


    int count(Map<String, Object> map);

    List<CooperationPrestoreDO> list(Map<String, Object> map);

    CooperationPrestoreDO get(String distributionNo);

    int save(CooperationPrestoreDO cooperationPrestore);

    int update(CooperationPrestoreDO cooperationPrestore);

    int updatePrestore(CooperationPrestoreDO cooperationPrestore);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
