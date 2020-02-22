package com.ecotourism.manage.cooperation.dao;

import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.domain.CooperationPrestoreDo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Mapper
public interface CooperationPrestoreDao {


    int count(Map<String, Object> map);

    List<CooperationPrestoreDo> list(Map<String, Object> map);
    List<CooperationDistributionDO> findListCoo();
    CooperationPrestoreDo get(Integer id);

    int save(CooperationPrestoreDo cooperationPrestore);

    int update(CooperationPrestoreDo cooperationPrestore);

}
