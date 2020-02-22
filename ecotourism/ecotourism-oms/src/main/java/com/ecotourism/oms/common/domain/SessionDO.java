package com.ecotourism.oms.common.domain;

import org.apache.shiro.session.Session;

public class SessionDO {

    public boolean retuenFlag =false;
    public Session session;

    public boolean isRetuenFlag() {
        return retuenFlag;
    }

    public void setRetuenFlag(boolean retuenFlag) {
        this.retuenFlag = retuenFlag;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
