package com.ecotourism.mobile.mobile.service.impl;

import com.ecotourism.mobile.mobile.dao.QrDao;
import com.ecotourism.mobile.mobile.domain.QrDO;
import com.ecotourism.mobile.mobile.service.QrService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QrServiceImpl implements QrService {

    @Autowired
    private QrDao qrDao;

    public List<QrDO> queryOrderInfoList(String orderNo) {
        if (StringUtils.isNotEmpty(orderNo)) {
            return qrDao.queryOrderInfoList(orderNo);
        } else {
            return new ArrayList<>();
        }
    }
}
