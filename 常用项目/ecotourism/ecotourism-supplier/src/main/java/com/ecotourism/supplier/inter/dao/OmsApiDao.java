package com.ecotourism.supplier.inter.dao;

import com.ecotourism.supplier.inter.domain.OmsApiDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * oms接口注册表
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
@Mapper
public interface OmsApiDao {

	OmsApiDO get(Integer id);

	OmsApiDO getByApino(String apino);

	List<OmsApiDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OmsApiDO omsApi);
	
	int update(OmsApiDO omsApi);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
