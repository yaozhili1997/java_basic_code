package com.ecotourism.supplier.exception.service;

import com.ecotourism.supplier.exception.domain.ExceptionDO;

import java.util.List;
import java.util.Map;

/**
 * 异常信息记录
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-10-15 16:39:30
 */
public interface ExceptionService {
	
	ExceptionDO get(Long id);
	
	List<ExceptionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExceptionDO exception);
	
	int update(ExceptionDO exception);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
