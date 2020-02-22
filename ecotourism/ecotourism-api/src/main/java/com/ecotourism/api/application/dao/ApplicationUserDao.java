package com.ecotourism.api.application.dao;

import com.ecotourism.api.application.domain.ApplicationUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 应用用户表
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:00:53
 */
@Mapper
public interface ApplicationUserDao {

	ApplicationUserDO get(String openId);
	
	List<ApplicationUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ApplicationUserDO applicationUser);
	
	int update(ApplicationUserDO applicationUser);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
