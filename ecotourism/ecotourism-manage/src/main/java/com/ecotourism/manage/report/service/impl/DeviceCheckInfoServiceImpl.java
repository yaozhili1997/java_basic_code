package com.ecotourism.manage.report.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.report.dao.DeviceCheckInfoDao;
import com.ecotourism.manage.report.domain.DeviceCheckInfoDO;
import com.ecotourism.manage.report.service.DeviceCheckInfoService;



@Service
public class DeviceCheckInfoServiceImpl implements DeviceCheckInfoService {
	@Autowired
	private DeviceCheckInfoDao deviceCheckInfoDao;
	
	@Override
	public DeviceCheckInfoDO get(Integer id){
		return deviceCheckInfoDao.get(id);
	}
	
	@Override
	public List<DeviceCheckInfoDO> list(Map<String, Object> map){
		return deviceCheckInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return deviceCheckInfoDao.count(map);
	}
	
	@Override
	public int save(DeviceCheckInfoDO deviceCheckInfo){
		return deviceCheckInfoDao.save(deviceCheckInfo);
	}
	
	@Override
	public int update(DeviceCheckInfoDO deviceCheckInfo){
		return deviceCheckInfoDao.update(deviceCheckInfo);
	}
	
	@Override
	public int remove(Integer id){
		return deviceCheckInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return deviceCheckInfoDao.batchRemove(ids);
	}
	
}
