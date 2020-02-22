package com.ecotourism.manage.cooperation.service.impl;

import com.ecotourism.manage.cooperation.dao.CooperationCapitalFlowDao;
import com.ecotourism.manage.cooperation.domain.CooperationCapitalFlowDo;
import com.ecotourism.manage.cooperation.service.CooperationCapitalFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Service
public class CooperationCapitalFlowServiceImpl implements CooperationCapitalFlowService {

    @Autowired
    private CooperationCapitalFlowDao cooperationCapitalFlowDao;


    @Override
    public List<CooperationCapitalFlowDo> list(Map<String, Object> map) {
        return cooperationCapitalFlowDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return cooperationCapitalFlowDao.count(map);
    }

    @Override
    public int save(CooperationCapitalFlowDo cooperationCapitalFlow) {
        return cooperationCapitalFlowDao.save(cooperationCapitalFlow);
    }

    @Override
    public int update(CooperationCapitalFlowDo cooperationCapitalFlow) {
        return cooperationCapitalFlowDao.update(cooperationCapitalFlow);
    }

    @Override
    public CooperationCapitalFlowDo get(Integer id) {
        return cooperationCapitalFlowDao.get(id);
    }
}
