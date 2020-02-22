package com.ecotourism.supplier.cooperation.service.impl;

import com.ecotourism.supplier.cooperation.dao.CooperationPrestoreDao;
import com.ecotourism.supplier.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.supplier.cooperation.domain.CooperationPrestoreDo;
import com.ecotourism.supplier.cooperation.service.CooperationPrestoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Service
public class CooperationPrestoreServiceImpl implements CooperationPrestoreService {

    @Autowired
    private CooperationPrestoreDao cooperationPrestoreDao;

    @Override
    public List<CooperationPrestoreDo> list(Map<String, Object> map) {
        return cooperationPrestoreDao.list(map) ;
    }
    @Override
    public List<CooperationDistributionDO> findListCoo() {
        return cooperationPrestoreDao.findListCoo() ;
    }

    @Override
    public int count(Map<String, Object> map) {
        return cooperationPrestoreDao.count(map);
    }

    @Override
    public CooperationPrestoreDo get(Integer id) {
        return cooperationPrestoreDao.get(id);
    }

    @Override
    public int save(CooperationPrestoreDo cooperationPrestore) {
        return cooperationPrestoreDao.save(cooperationPrestore);
    }

    @Override
    public int update(CooperationPrestoreDo cooperationPrestore) {
        return cooperationPrestoreDao.update(cooperationPrestore);
    }

}
