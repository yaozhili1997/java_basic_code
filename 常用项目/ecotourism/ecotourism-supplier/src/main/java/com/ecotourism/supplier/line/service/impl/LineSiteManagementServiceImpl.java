package com.ecotourism.supplier.line.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.line.dao.LineSiteManagementDao;
import com.ecotourism.supplier.line.domain.LineSiteManagementDO;
import com.ecotourism.supplier.line.service.LineSiteManagementService;



@Service
public class LineSiteManagementServiceImpl implements LineSiteManagementService {
	@Autowired
	private LineSiteManagementDao siteManagementDao;
	
	@Override
	public LineSiteManagementDO get(Integer id){
		return siteManagementDao.get(id);
	}
	
	@Override
	public List<LineSiteManagementDO> list(Map<String, Object> map){
		return siteManagementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return siteManagementDao.count(map);
	}
	
	@Override
	public int save(LineSiteManagementDO siteManagement){
		return siteManagementDao.save(siteManagement);
	}
	
	@Override
	public int update(LineSiteManagementDO siteManagement){
		return siteManagementDao.update(siteManagement);
	}
	
	@Override
	public int remove(Integer id){
		return siteManagementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return siteManagementDao.batchRemove(ids);
	}
	
}
