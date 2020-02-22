package com.ecotourism.manage.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.dao.TermManagementDao;
import com.ecotourism.manage.base.domain.TermManagementDO;
import com.ecotourism.manage.base.service.TermManagementService;



@Service
public class TermManagementServiceImpl implements TermManagementService {
	@Autowired
	private TermManagementDao termManagementDao;
	
	@Override
	public TermManagementDO get(Integer termId){
		return termManagementDao.get(termId);
	}
	
	@Override
	public List<TermManagementDO> list(Map<String, Object> map){
		return termManagementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return termManagementDao.count(map);
	}
	
	@Override
	public int save(TermManagementDO termManagement){
		return termManagementDao.save(termManagement);
	}
	
	@Override
	public int update(TermManagementDO termManagement){
		return termManagementDao.update(termManagement);
	}
	
	@Override
	public int remove(Integer termId){
		return termManagementDao.remove(termId);
	}
	
	@Override
	public int batchRemove(Integer[] termIds){
		return termManagementDao.batchRemove(termIds);
	}
	
}
