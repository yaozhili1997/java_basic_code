package com.ecotourism.supplier.commodity.dao;

import com.ecotourism.supplier.commodity.domain.ManagementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 属性管理
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-02 11:12:41
 */
@Mapper
public interface ManagementDao {

	ManagementDO get(Integer id);
	
	List<ManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ManagementDO management);
	
	int update(ManagementDO management);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
