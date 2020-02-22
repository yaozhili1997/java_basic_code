package com.ecotourism.manage.inter.service;

import com.ecotourism.manage.inter.domain.OmsApiFieldconfigDO;

import java.util.List;
import java.util.Map;

/**
 * 接口字段配置信息，将数据库字段转换为标准输出
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
public interface OmsApiFieldconfigService {
	
	OmsApiFieldconfigDO get(Integer id);
	
	List<OmsApiFieldconfigDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OmsApiFieldconfigDO omsApiFieldconfig);
	
	int update(OmsApiFieldconfigDO omsApiFieldconfig);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
