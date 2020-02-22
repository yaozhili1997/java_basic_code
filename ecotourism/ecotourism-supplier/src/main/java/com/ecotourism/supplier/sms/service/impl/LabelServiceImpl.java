package com.ecotourism.supplier.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.sms.dao.LabelDao;
import com.ecotourism.supplier.sms.domain.LabelDO;
import com.ecotourism.supplier.sms.service.LabelService;



@Service
public class LabelServiceImpl implements LabelService {
	@Autowired
	private LabelDao labelDao;
	
	@Override
	public LabelDO get(Integer id){
		return labelDao.get(id);
	}
	
	@Override
	public List<LabelDO> list(Map<String, Object> map){
		return labelDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return labelDao.count(map);
	}
	
	@Override
	public int save(LabelDO label){
		return labelDao.save(label);
	}
	
	@Override
	public int update(LabelDO label){
		return labelDao.update(label);
	}
	
	@Override
	public int remove(Integer id){
		return labelDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return labelDao.batchRemove(ids);
	}
	
}
