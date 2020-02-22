package com.ecotourism.supplier.inter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.inter.dao.OmsApiFieldconfigDao;
import com.ecotourism.supplier.inter.domain.OmsApiFieldconfigDO;
import com.ecotourism.supplier.inter.service.OmsApiFieldconfigService;



@Service
public class OmsApiFieldconfigServiceImpl implements OmsApiFieldconfigService {
	@Autowired
	private OmsApiFieldconfigDao omsApiFieldconfigDao;
	
	@Override
	public OmsApiFieldconfigDO get(Integer id){
		return omsApiFieldconfigDao.get(id);
	}
	
	@Override
	public List<OmsApiFieldconfigDO> list(Map<String, Object> map){
		return omsApiFieldconfigDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return omsApiFieldconfigDao.count(map);
	}
	
	@Override
	public int save(OmsApiFieldconfigDO omsApiFieldconfig){
		return omsApiFieldconfigDao.save(omsApiFieldconfig);
	}
	
	@Override
	public int update(OmsApiFieldconfigDO omsApiFieldconfig){
		return omsApiFieldconfigDao.update(omsApiFieldconfig);
	}
	
	@Override
	public int remove(Integer id){
		return omsApiFieldconfigDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return omsApiFieldconfigDao.batchRemove(ids);
	}
	
}
