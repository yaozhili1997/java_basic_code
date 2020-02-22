package com.ecotourism.manage.cooperation.service.impl;

import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.cooperation.dao.CooperationRechargeRecordDao;
import com.ecotourism.manage.cooperation.domain.CooperationPrestoreDo;
import com.ecotourism.manage.cooperation.domain.CooperationRechargeRecordDO;
import com.ecotourism.manage.cooperation.service.CooperationRechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Service
public class CooperationRechargeRecordServiceImpl implements CooperationRechargeRecordService{

        @Autowired
    private CooperationRechargeRecordDao cooperationRechargeRecordDao;

    @Override
    public List<CooperationRechargeRecordDO> list(Map<String, Object> map) {
        return cooperationRechargeRecordDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return cooperationRechargeRecordDao.count(map);
    }

    @Override
    public R save(CooperationPrestoreDo cooperationPrestore) {

        CooperationRechargeRecordDO cooperationRechargeRecord=new CooperationRechargeRecordDO();
        //获取分销商编号
        cooperationRechargeRecord.setDistributionNo(cooperationPrestore.getDistributionNo());
        //获取充值金额
        cooperationRechargeRecord.setRechargePrice(cooperationPrestore.getUpRechargeAmount());
        //获取预存款余额
        cooperationRechargeRecord.setPreDepositBalance(cooperationPrestore.getPrestoreAmount());
        //获取充值时间
        cooperationRechargeRecord.setRechargeTime(cooperationPrestore.getUpdateTime());
        //获取充值人
        cooperationRechargeRecord.setCreateUser(cooperationPrestore.getUpdateUser());
        //获取备注
        cooperationRechargeRecord.setRemarks(cooperationPrestore.getRemarks());
        //设置充值流水号
        long t1=System.currentTimeMillis()+1;
        cooperationRechargeRecord.setRechargeFlowing(Long.toString(t1));
        if(cooperationRechargeRecordDao.save(cooperationRechargeRecord)>0){
           return R.ok();
        }
        return R.error();
    }
}
