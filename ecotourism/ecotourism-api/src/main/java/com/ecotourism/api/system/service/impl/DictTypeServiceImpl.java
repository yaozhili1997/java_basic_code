package com.ecotourism.api.system.service.impl;

import com.ecotourism.api.common.dao.DictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.api.system.dao.DictTypeDao;
import com.ecotourism.api.system.domain.DictTypeDO;
import com.ecotourism.api.system.service.DictTypeService;



@Service
public class DictTypeServiceImpl implements DictTypeService {
	@Autowired
	private DictTypeDao dictTypeDao;
	@Autowired
	private DictDao dictDao;
	@Override
	public DictTypeDO get(Long id){
		return dictTypeDao.get(id);
	}
	
	@Override
	public List<DictTypeDO> list(Map<String, Object> map){
		return dictTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dictTypeDao.count(map);
	}
	
	@Override
	public int save(DictTypeDO dictType){
		return dictTypeDao.save(dictType);
	}
	
	@Override
	public int update(DictTypeDO dictType){
		return dictTypeDao.update(dictType);
	}

}
