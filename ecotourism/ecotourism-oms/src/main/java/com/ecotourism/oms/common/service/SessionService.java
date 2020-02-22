package com.ecotourism.oms.common.service;

import com.ecotourism.oms.common.domain.SessionDO;

public interface SessionService {

    SessionDO getSession(String key);

    void updateSession(SessionDO sessionDO);
}
