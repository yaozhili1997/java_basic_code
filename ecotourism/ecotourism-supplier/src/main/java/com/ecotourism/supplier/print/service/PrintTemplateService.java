package com.ecotourism.supplier.print.service;

import com.ecotourism.supplier.print.domain.PrintTemplateDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
public interface PrintTemplateService {
	
	PrintTemplateDO get(Integer id);
	
	List<PrintTemplateDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PrintTemplateDO printTemplate);
	
	int update(PrintTemplateDO printTemplate);

	void changeStatus(int id, String cmd);
}
