package com.ecotourism.oms.common.service.impl;

import com.ecotourism.oms.common.domain.SessionDO;
import com.ecotourism.oms.common.service.SessionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionDAO sessionDAO;
    @Override
    public SessionDO getSession(String key) {
        SessionDO sessionDO = new SessionDO();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            if (session.getAttribute(key) == null) {
                continue;
            } else {
                sessionDO.setRetuenFlag(true);
                sessionDO.setSession(session);
            }
        }
        if(!sessionDO.isRetuenFlag()){
            Session session = SecurityUtils.getSubject().getSession();
            sessionDO.setRetuenFlag(false);
            sessionDO.setSession(session);
        }
        return sessionDO;
    }

    @Override
    public void updateSession(SessionDO sessionDO) {
        try{
            sessionDAO.update(sessionDO.getSession());
        }catch (UnknownSessionException e){
            //e.printStackTrace();
        }
    }
}
