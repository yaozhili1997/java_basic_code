package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.CooperationDistributionDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:09:13
 */
@Mapper
public interface CooperationDistributionDao {

	CooperationDistributionDO get(Integer id);
	
	List<CooperationDistributionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CooperationDistributionDO cooperationDistribution);
	
	int update(CooperationDistributionDO cooperationDistribution);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<CooperationDistributionDO> listAll(Map<String, Object> map);
	List<CooperationDistributionDO> listEnableCoo();

	CooperationDistributionDO queryCooperationDistribution(CooperationDistributionDO cooperationDistribution);

}
