package com.ecotourism.supplier.system.dao;

import com.ecotourism.supplier.system.domain.DistributionUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-27 09:28:04
 */
@Mapper
public interface DistributionUserDao {

	DistributionUserDO get(Long userId);
	
	List<DistributionUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DistributionUserDO distributionUser);
	
	int update(DistributionUserDO distributionUser);
	
	int remove(Long user_id);
	
	int batchRemove(Long[] userIds);
}
