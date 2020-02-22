package com.ecotourism.manage.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.sms.dao.SendDataDao;
import com.ecotourism.manage.sms.domain.SendDataDO;
import com.ecotourism.manage.sms.service.SendDataService;



@Service
public class SendDataServiceImpl implements SendDataService {
	@Autowired
	private SendDataDao sendDataDao;
	
	@Override
	public SendDataDO get(Integer id){
		return sendDataDao.get(id);
	}
	
	@Override
	public List<SendDataDO> list(Map<String, Object> map){
		return sendDataDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sendDataDao.count(map);
	}
	
	@Override
	public int save(SendDataDO sendData){
		return sendDataDao.save(sendData);
	}
	
	@Override
	public int update(SendDataDO sendData){
		return sendDataDao.update(sendData);
	}
	
	@Override
	public int remove(Integer id){
		return sendDataDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return sendDataDao.batchRemove(ids);
	}
	
}
