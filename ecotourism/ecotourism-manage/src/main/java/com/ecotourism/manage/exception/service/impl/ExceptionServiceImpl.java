package com.ecotourism.manage.exception.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.exception.dao.ExceptionDao;
import com.ecotourism.manage.exception.domain.ExceptionDO;
import com.ecotourism.manage.exception.service.ExceptionService;



@Service
public class ExceptionServiceImpl implements ExceptionService {
	@Autowired
	private ExceptionDao exceptionDao;
	
	@Override
	public ExceptionDO get(Long id){
		return exceptionDao.get(id);
	}
	
	@Override
	public List<ExceptionDO> list(Map<String, Object> map){
		return exceptionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return exceptionDao.count(map);
	}
	
	@Override
	public int save(ExceptionDO exception){
		return exceptionDao.save(exception);
	}
	
	@Override
	public int update(ExceptionDO exception){
		return exceptionDao.update(exception);
	}
	
	@Override
	public int remove(Long id){
		return exceptionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return exceptionDao.batchRemove(ids);
	}
	
}
