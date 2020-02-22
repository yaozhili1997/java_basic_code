package com.ecotourism.manage.cooperation.dao;

import com.ecotourism.manage.cooperation.domain.CooperationPrestoreDo;
import com.ecotourism.manage.cooperation.domain.CooperationRechargeRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Mapper
public interface CooperationRechargeRecordDao {
    List<CooperationRechargeRecordDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CooperationRechargeRecordDO cooperationRechargeRecord);
}
