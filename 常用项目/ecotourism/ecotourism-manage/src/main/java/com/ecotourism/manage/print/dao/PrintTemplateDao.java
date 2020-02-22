package com.ecotourism.manage.print.dao;

import com.ecotourism.manage.print.domain.PrintTemplateDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
@Mapper
public interface PrintTemplateDao {

	PrintTemplateDO get(Integer id);
	
	List<PrintTemplateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PrintTemplateDO printTemplate);
	
	int update(PrintTemplateDO printTemplate);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
