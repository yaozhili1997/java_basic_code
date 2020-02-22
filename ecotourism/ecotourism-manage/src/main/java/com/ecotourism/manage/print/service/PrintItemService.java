package com.ecotourism.manage.print.service;

import com.ecotourism.manage.print.domain.PrintItemDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
public interface PrintItemService {
	
	PrintItemDO get(String id);
	
	List<PrintItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PrintItemDO printItem);
	
	int update(PrintItemDO printItem);
	
	int remove(String id);
	
	int batchRemove(String[] ids);
}
