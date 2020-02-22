package com.ecotourism.supplier.report.service;

import com.ecotourism.supplier.report.domain.DeviceCheckInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-14 10:02:02
 */
public interface DeviceCheckInfoService {
	
	DeviceCheckInfoDO get(Integer id);
	
	List<DeviceCheckInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeviceCheckInfoDO deviceCheckInfo);
	
	int update(DeviceCheckInfoDO deviceCheckInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
