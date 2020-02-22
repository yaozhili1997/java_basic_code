package com.ecotourism.api.exception.service.impl;

import com.ecotourism.api.exception.dao.ExceptionDao;
import com.ecotourism.api.exception.domain.ExceptionDO;
import com.ecotourism.api.exception.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExceptionServiceImpl implements ExceptionService {
	@Autowired
	private ExceptionDao exceptionDao;
	
	@Override
	public int save(ExceptionDO exception){
		return exceptionDao.save(exception);
	}

}
