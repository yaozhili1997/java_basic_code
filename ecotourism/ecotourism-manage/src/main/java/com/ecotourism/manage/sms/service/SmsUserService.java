package com.ecotourism.manage.sms.service;

import com.ecotourism.manage.sms.domain.SmsUserDO;

import java.util.List;
import java.util.Map;

/**
 * 短信用户
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:34
 */
public interface SmsUserService {

	SmsUserDO get(Integer id);
	
	List<SmsUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SmsUserDO user);
	
	int update(SmsUserDO user);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
