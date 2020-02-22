package com.ecotourism.manage.ums.service;

import com.ecotourism.manage.ums.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * 应用用户表
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-10-19 09:30:16
 */
public interface UserService {
	
	UserDO get(Integer id);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
