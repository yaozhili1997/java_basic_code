package com.ecotourism.api.application.service.impl;

import com.ecotourism.api.application.dao.ApplicationApiDetectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ecotourism.api.application.domain.ApplicationApiDetectionDO;
import com.ecotourism.api.application.service.ApplicationApiDetectionService;



@Service
public class ApplicationApiDetectionServiceImpl implements ApplicationApiDetectionService {
	@Autowired
	private ApplicationApiDetectionDao applicationApiDetectionDao;
	
	@Override
	public ApplicationApiDetectionDO get(Integer id){
		return applicationApiDetectionDao.get(id);
	}
	
	@Override
	public List<ApplicationApiDetectionDO> list(Map<String, Object> map){
		return applicationApiDetectionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return applicationApiDetectionDao.count(map);
	}
	
	@Override
	public int save(ApplicationApiDetectionDO applicationApiDetection){
		return applicationApiDetectionDao.save(applicationApiDetection);
	}
	
	@Override
	public int update(ApplicationApiDetectionDO applicationApiDetection){
		return applicationApiDetectionDao.update(applicationApiDetection);
	}
	
	@Override
	public int remove(Integer id){
		return applicationApiDetectionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return applicationApiDetectionDao.batchRemove(ids);
	}
	
}
