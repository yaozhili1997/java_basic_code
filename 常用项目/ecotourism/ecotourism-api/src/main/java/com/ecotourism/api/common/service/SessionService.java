package com.ecotourism.api.common.service;

import com.ecotourism.api.common.domain.SessionDO;

public interface SessionService {

    public SessionDO getSession(String key);

    public void updateSession(SessionDO sessionDO);
}
