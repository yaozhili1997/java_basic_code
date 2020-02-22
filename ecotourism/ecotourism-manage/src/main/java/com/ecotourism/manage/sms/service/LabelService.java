package com.ecotourism.manage.sms.service;

import com.ecotourism.manage.sms.domain.LabelDO;

import java.util.List;
import java.util.Map;

/**
 * 短信替换标签
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public interface LabelService {
	
	LabelDO get(Integer id);
	
	List<LabelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LabelDO label);
	
	int update(LabelDO label);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
