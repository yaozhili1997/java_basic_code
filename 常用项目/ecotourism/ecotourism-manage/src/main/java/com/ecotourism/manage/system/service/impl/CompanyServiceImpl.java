package com.ecotourism.manage.system.service.impl;

import com.ecotourism.manage.system.dao.CompanyDao;
import com.ecotourism.manage.system.domain.CompanyDO;
import com.ecotourism.manage.system.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public CompanyDO get(String departmentId){
		return companyDao.get(departmentId);
	}
	
	@Override
	public List<CompanyDO> list(Map<String, Object> map){
		return companyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return companyDao.count(map);
	}
	
	@Override
	public int save(CompanyDO company){
		return companyDao.save(company);
	}
	
	@Override
	public int update(CompanyDO company){
		return companyDao.update(company);
	}
	
	@Override
	public int remove(String departmentId){
		return companyDao.remove(departmentId);
	}
	
	@Override
	public int batchRemove(String[] departmentIds){
		return companyDao.batchRemove(departmentIds);
	}
	
}
