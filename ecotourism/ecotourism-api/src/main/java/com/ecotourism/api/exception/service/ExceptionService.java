package com.ecotourism.api.exception.service;

import com.ecotourism.api.exception.domain.ExceptionDO;

/**
 * 异常信息记录
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-20 18:04:38
 */
public interface ExceptionService {
	
	int save(ExceptionDO exception);
}
