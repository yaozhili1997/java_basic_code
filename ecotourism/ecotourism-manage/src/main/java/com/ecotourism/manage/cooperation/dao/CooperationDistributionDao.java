package com.ecotourism.manage.cooperation.dao;

import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @date 2018-06-30 10:09:13
 */
@Mapper
public interface CooperationDistributionDao {

	CooperationDistributionDO get(Integer id);
	
	List<CooperationDistributionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	int findNo(String no);
	int findCid(String cid);

	int save(CooperationDistributionDO cooperationDistribution);
	
	int update(CooperationDistributionDO cooperationDistribution);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<CooperationDistributionDO> listAll(Map<String, Object> map);
	List<CooperationDistributionDO> listEnableCoo();
}
