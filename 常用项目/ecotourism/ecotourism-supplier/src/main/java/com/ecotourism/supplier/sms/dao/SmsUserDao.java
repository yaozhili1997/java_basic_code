package com.ecotourism.supplier.sms.dao;

import com.ecotourism.supplier.sms.domain.SmsUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 短信用户
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:34
 */
@Mapper
public interface SmsUserDao {

	SmsUserDO get(Integer id);
	
	List<SmsUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SmsUserDO user);
	
	int update(SmsUserDO user);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
