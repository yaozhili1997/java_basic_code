package com.ecotourism.manage.users.service.impl;

import com.ecotourism.manage.common.config.BootdoConfig;
import com.ecotourism.manage.common.config.Constant;
import com.ecotourism.manage.common.utils.MatrixToImageWriter;
import com.ecotourism.manage.payment.dao.PaymentUserDao;
import com.ecotourism.manage.payment.domain.PaymentUserDO;
import com.ecotourism.manage.users.dao.PushUserDao;
import com.ecotourism.manage.users.domain.PushUserDO;
import com.ecotourism.manage.users.service.PushUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Service
public class PushUserServiceImpl implements PushUserService{

    @Autowired
    private PushUserDao pushUserDao;
    @Autowired
    private PaymentUserDao userDao;
    @Autowired
    private BootdoConfig bootdoConfig;
    @Override
    public List<PushUserDO> list(Map<String, Object> map) {
        return pushUserDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return pushUserDao.count(map);
    }

    @Override
    public PushUserDO get(Integer id) {
        return pushUserDao.get(id);
    }

    @Override
    public int save(PushUserDO pushUser) {
        pushUser.setCreateTime(new Date());
        return pushUserDao.save(pushUser);
    }

    @Override
    public int update(PushUserDO pushUser) {
        pushUser.setUpdateTime(new Date());
        return pushUserDao.update(pushUser);
    }

    @Override
    public int remove(Integer id) {
        return pushUserDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return pushUserDao.batchRemove(ids);
    }
    @Override
    public File downLoadQr(Integer id) {
        PushUserDO pushUserDO = get(id);
        if(pushUserDO !=null){
            String userNo = pushUserDO.getDistributionNo();
            PaymentUserDO paymentUserDO = userDao.getByUserNo(userNo);
            if(paymentUserDO !=null){
                String authorizedAddress = paymentUserDO.getAuthorizedAddress();
                if(StringUtils.isNotBlank(authorizedAddress)){
                    String rootPath = bootdoConfig.getUploadPath()+ Constant.UPDATE_LODE_PATH+pushUserDO.getUserName()+".jpg";
                    try {
                        File file = MatrixToImageWriter.outQrcode(authorizedAddress + "?userNo=" + pushUserDO.getUserNo()+"&applicationNo="+paymentUserDO.getUserNo(), rootPath);
                        PushUserDO pushUser = new PushUserDO();
                        pushUser.setId(id);
                        rootPath = "/files/"+Constant.UPDATE_LODE_PATH+pushUserDO.getUserName()+".jpg";
                        pushUser.setQrCodeImg(rootPath);
                        update(pushUser);
                        return file;
                    }catch (Exception e){
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
