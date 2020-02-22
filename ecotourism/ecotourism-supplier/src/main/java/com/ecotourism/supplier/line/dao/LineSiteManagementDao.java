package com.ecotourism.supplier.line.dao;

import com.ecotourism.supplier.line.domain.LineSiteManagementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-09 16:11:27
 */
@Mapper
public interface LineSiteManagementDao {

	LineSiteManagementDO get(Integer id);
	
	List<LineSiteManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LineSiteManagementDO siteManagement);
	
	int update(LineSiteManagementDO siteManagement);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
