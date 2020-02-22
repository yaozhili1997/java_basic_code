package com.ecotourism.supplier.sms.service;

import com.ecotourism.supplier.sms.domain.TemplateDO;

import java.util.List;
import java.util.Map;

/**
 * 短信模板
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public interface TemplateService {
	
	TemplateDO get(Integer templateId);
	
	List<TemplateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TemplateDO template);
	
	int update(TemplateDO template);
	
	int remove(Integer templateId);
	
	int batchRemove(Integer[] templateIds);
}
