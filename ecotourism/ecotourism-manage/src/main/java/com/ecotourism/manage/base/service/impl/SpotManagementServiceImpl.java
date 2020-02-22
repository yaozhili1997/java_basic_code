package com.ecotourism.manage.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.dao.SpotManagementDao;
import com.ecotourism.manage.base.domain.SpotManagementDO;
import com.ecotourism.manage.base.service.SpotManagementService;



@Service
public class SpotManagementServiceImpl implements SpotManagementService {
	@Autowired
	private SpotManagementDao spotManagementDao;
	
	@Override
	public SpotManagementDO get(Integer spotId){
		return spotManagementDao.get(spotId);
	}
	
	@Override
	public List<SpotManagementDO> list(Map<String, Object> map){
		return spotManagementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return spotManagementDao.count(map);
	}
	
	@Override
	public int save(SpotManagementDO spotManagement){
		return spotManagementDao.save(spotManagement);
	}
	
	@Override
	public int update(SpotManagementDO spotManagement){
		return spotManagementDao.update(spotManagement);
	}
	
	@Override
	public int remove(Integer spotId){
		return spotManagementDao.remove(spotId);
	}
	
	@Override
	public int batchRemove(Integer[] spotIds){
		return spotManagementDao.batchRemove(spotIds);
	}
	
}
