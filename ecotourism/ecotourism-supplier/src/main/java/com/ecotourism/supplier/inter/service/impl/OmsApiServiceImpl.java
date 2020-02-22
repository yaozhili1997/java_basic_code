package com.ecotourism.supplier.inter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.inter.dao.OmsApiDao;
import com.ecotourism.supplier.inter.domain.OmsApiDO;
import com.ecotourism.supplier.inter.service.OmsApiService;



@Service
public class OmsApiServiceImpl implements OmsApiService {
	@Autowired
	private OmsApiDao omsApiDao;
	
	@Override
	public OmsApiDO get(Integer id){
		return omsApiDao.get(id);
	}

	@Override
	public OmsApiDO getByApino(String apino) {
		return omsApiDao.getByApino(apino);
	}

	@Override
	public List<OmsApiDO> list(Map<String, Object> map){
		return omsApiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return omsApiDao.count(map);
	}
	
	@Override
	public int save(OmsApiDO omsApi){
		return omsApiDao.save(omsApi);
	}
	
	@Override
	public int update(OmsApiDO omsApi){
		return omsApiDao.update(omsApi);
	}
	
	@Override
	public int remove(Integer id){
		return omsApiDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return omsApiDao.batchRemove(ids);
	}
	
}
