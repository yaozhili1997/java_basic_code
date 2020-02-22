package com.ecotourism.supplier.sms.dao;

import com.ecotourism.supplier.sms.domain.SendLogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 短信发送日志
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
@Mapper
public interface SendLogDao {

	SendLogDO get(Integer id);
	
	List<SendLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SendLogDO sendLog);
	
	int update(SendLogDO sendLog);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
