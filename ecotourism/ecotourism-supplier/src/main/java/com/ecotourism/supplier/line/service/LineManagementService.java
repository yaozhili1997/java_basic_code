package com.ecotourism.supplier.line.service;

import com.ecotourism.supplier.line.domain.LineManagementDO;
import com.ecotourism.supplier.product.domain.CarTicketDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-09 16:11:27
 */
public interface LineManagementService {
	
	LineManagementDO get(Integer id);
	
	List<LineManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(LineManagementDO management);
	
	int update(LineManagementDO management);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<LineManagementDO> listLineManagement(Map<String, Object> map, String subordinateLine);
}
