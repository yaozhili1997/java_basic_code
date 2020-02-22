package com.ecotourism.api.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.api.application.dao.ApplicationUserDao;
import com.ecotourism.api.application.domain.ApplicationUserDO;
import com.ecotourism.api.application.service.ApplicationUserService;



@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
	@Autowired
	private ApplicationUserDao applicationUserDao;
	
	@Override
	public ApplicationUserDO get(String openId){
		return applicationUserDao.get(openId);
	}
	
	@Override
	public List<ApplicationUserDO> list(Map<String, Object> map){
		return applicationUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return applicationUserDao.count(map);
	}
	
	@Override
	public int save(ApplicationUserDO applicationUser){
		return applicationUserDao.save(applicationUser);
	}
	
	@Override
	public int update(ApplicationUserDO applicationUser){
		return applicationUserDao.update(applicationUser);
	}
	
	@Override
	public int remove(Integer id){
		return applicationUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return applicationUserDao.batchRemove(ids);
	}
	
}
