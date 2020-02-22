package com.ecotourism.mobile.mobile.service;

import com.ecotourism.mobile.mobile.domain.QrDO;

import java.util.List;

public interface QrService {
    List<QrDO> queryOrderInfoList(String orderNo);
}
