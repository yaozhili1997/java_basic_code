package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.OmsApiFieldconfigDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 接口字段配置信息，将数据库字段转换为标准输出
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-05 19:39:45
 */
@Mapper
public interface OmsApiFieldconfigDao {

	OmsApiFieldconfigDO get(Integer id);
	
	List<OmsApiFieldconfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OmsApiFieldconfigDO omsApiFieldconfig);
	
	int update(OmsApiFieldconfigDO omsApiFieldconfig);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
