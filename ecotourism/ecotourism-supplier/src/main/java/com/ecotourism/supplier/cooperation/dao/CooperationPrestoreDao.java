package com.ecotourism.supplier.cooperation.dao;

import com.ecotourism.supplier.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.supplier.cooperation.domain.CooperationPrestoreDo;
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
