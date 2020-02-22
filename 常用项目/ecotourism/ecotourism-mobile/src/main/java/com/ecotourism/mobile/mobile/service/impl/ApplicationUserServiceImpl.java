package com.ecotourism.mobile.mobile.service.impl;

import com.ecotourism.mobile.mobile.dao.ApplicationUserDao;
import com.ecotourism.mobile.mobile.domain.ApplicationUserDO;
import com.ecotourism.mobile.mobile.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserDao applicationUserDao;

    public void saveAccessToken(String accessToken, String openid) {
        ApplicationUserDO userDO = new ApplicationUserDO();
        userDO.setOpenid(openid);
        userDO.setSessionKey(accessToken);
        int count = applicationUserDao.updateAccessToken(userDO);
        if (count == 0) {
            applicationUserDao.save(userDO);
        }
    }
}
