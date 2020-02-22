package com.ecotourism.mobile.mobile.dao;

import com.ecotourism.mobile.mobile.domain.ApplicationUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 应用用户表
 * @author scotte
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:00:53
 */
@Mapper
public interface ApplicationUserDao {

	ApplicationUserDO get(String openId);
	
	List<ApplicationUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ApplicationUserDO applicationUser);
	
	int updateAccessToken(ApplicationUserDO applicationUser);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
