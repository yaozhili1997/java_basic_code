package com.ecotourism.manage.system.service;

import com.ecotourism.manage.system.domain.DistributionUserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-27 09:28:04
 */
public interface DistributionUserService {
	
	DistributionUserDO get(Long userId);
	
	List<DistributionUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DistributionUserDO distributionUser);
	
	int update(DistributionUserDO distributionUser);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);
}
