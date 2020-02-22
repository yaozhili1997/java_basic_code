package com.ecotourism.manage.system.dao;

import com.ecotourism.manage.system.domain.DictTypeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 字典类型表
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-30 15:33:01
 */
@Mapper
public interface DictTypeDao {

	DictTypeDO get(Long id);
	
	List<DictTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DictTypeDO dictType);
	
	int update(DictTypeDO dictType);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
