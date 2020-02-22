package com.ecotourism.manage.cooperation.service;

import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.domain.CooperationPrestoreDo;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
public interface CooperationPrestoreService {
    List<CooperationPrestoreDo> list(Map<String, Object> map);
    List<CooperationDistributionDO> findListCoo();
    int count(Map<String, Object> map);

    CooperationPrestoreDo get(Integer id);

    int save(CooperationPrestoreDo cooperationPrestore);

    int update(CooperationPrestoreDo cooperationPrestore);


}
