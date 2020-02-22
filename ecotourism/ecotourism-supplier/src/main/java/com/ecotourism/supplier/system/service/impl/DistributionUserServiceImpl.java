package com.ecotourism.supplier.system.service.impl;

import com.ecotourism.supplier.system.dao.DistributionUserDao;
import com.ecotourism.supplier.system.domain.DistributionUserDO;
import com.ecotourism.supplier.system.service.DistributionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DistributionUserServiceImpl implements DistributionUserService {
	@Autowired
	private DistributionUserDao distributionUserDao;
	
	@Override
	public DistributionUserDO get(Long userId){
		return distributionUserDao.get(userId);
	}
	
	@Override
	public List<DistributionUserDO> list(Map<String, Object> map){
		return distributionUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return distributionUserDao.count(map);
	}
	
	@Override
	public int save(DistributionUserDO distributionUser){
		return distributionUserDao.save(distributionUser);
	}
	
	@Override
	public int update(DistributionUserDO distributionUser){
		return distributionUserDao.update(distributionUser);
	}
	
	@Override
	public int remove(Long userId){
		return distributionUserDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return distributionUserDao.batchRemove(userIds);
	}
	
}
