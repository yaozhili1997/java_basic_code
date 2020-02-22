package com.ecotourism.manage.sms.service;

import com.ecotourism.manage.sms.domain.SendLogDO;

import java.util.List;
import java.util.Map;

/**
 * 短信发送日志
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public interface SendLogService {
	
	SendLogDO get(Integer id);
	
	List<SendLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SendLogDO sendLog);
	
	int update(SendLogDO sendLog);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
