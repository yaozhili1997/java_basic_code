package com.ecotourism.manage.report.service.impl;

import com.ecotourism.manage.common.utils.PageTotal;
import com.ecotourism.manage.report.dao.PushUserReadDao;
import com.ecotourism.manage.report.domain.PushUserReportDO;
import com.ecotourism.manage.report.service.PushUserReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PushUserReportServiceImpl implements PushUserReportService {
    @Autowired
    PushUserReadDao pushUserReadDao;
    @Override
    public List<PushUserReportDO> list(Map<String, Object> map) {
        return pushUserReadDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return pushUserReadDao.count(map);
    }

    @Override
    public PageTotal getPushUserReportSum(Map<String, Object> map) {
        return pushUserReadDao.getPushUserReportSum(map);
    }
}
