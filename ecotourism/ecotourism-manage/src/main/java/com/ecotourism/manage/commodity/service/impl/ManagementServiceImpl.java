package com.ecotourism.manage.commodity.service.impl;

import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.commodity.dao.ManagementDao;
import com.ecotourism.manage.commodity.domain.ManagementDO;
import com.ecotourism.manage.commodity.service.ManagementService;



@Service
public class ManagementServiceImpl implements ManagementService {
	@Autowired
	private ManagementDao managementDao;

	@Autowired
	private DictService dictService;

	@Override
	public ManagementDO get(Integer id){
		return managementDao.get(id);
	}
	
	@Override
	public List<ManagementDO> list(Map<String, Object> map){
		List<ManagementDO> list = managementDao.list(map);
		for (ManagementDO managementDO : list) {
			managementDO.setAttributeType(dictService.getName("attribute_type", managementDO.getAttributeType(), ShiroUtils.getUser().getCompanyNo()));
		}
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return managementDao.count(map);
	}
	
	@Override
	public int save(ManagementDO management){
		return managementDao.save(management);
	}
	
	@Override
	public int update(ManagementDO management){
		return managementDao.update(management);
	}
	
	@Override
	public int remove(Integer id){
		return managementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return managementDao.batchRemove(ids);
	}
	
}
