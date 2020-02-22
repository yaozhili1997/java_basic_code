package com.ecotourism.supplier.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.sms.dao.SendLogDao;
import com.ecotourism.supplier.sms.domain.SendLogDO;
import com.ecotourism.supplier.sms.service.SendLogService;



@Service
public class SendLogServiceImpl implements SendLogService {
	@Autowired
	private SendLogDao sendLogDao;
	
	@Override
	public SendLogDO get(Integer id){
		return sendLogDao.get(id);
	}
	
	@Override
	public List<SendLogDO> list(Map<String, Object> map){
		return sendLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sendLogDao.count(map);
	}
	
	@Override
	public int save(SendLogDO sendLog){
		return sendLogDao.save(sendLog);
	}
	
	@Override
	public int update(SendLogDO sendLog){
		return sendLogDao.update(sendLog);
	}
	
	@Override
	public int remove(Integer id){
		return sendLogDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return sendLogDao.batchRemove(ids);
	}
	
}
