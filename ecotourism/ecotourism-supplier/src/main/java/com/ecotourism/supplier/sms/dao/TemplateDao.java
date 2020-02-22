package com.ecotourism.supplier.sms.dao;

import com.ecotourism.supplier.sms.domain.TemplateDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 短信模板
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
@Mapper
public interface TemplateDao {

	TemplateDO get(Integer templateId);
	
	List<TemplateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TemplateDO template);
	
	int update(TemplateDO template);
	
	int remove(Integer template_id);
	
	int batchRemove(Integer[] templateIds);
}
