package com.ecotourism.supplier.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.sms.dao.SmsUserDao;
import com.ecotourism.supplier.sms.domain.SmsUserDO;
import com.ecotourism.supplier.sms.service.SmsUserService;



@Service
public class SmsUserServiceImpl implements SmsUserService {
	@Autowired
	private SmsUserDao userDao;
	
	@Override
	public SmsUserDO get(Integer id){
		return userDao.get(id);
	}
	
	@Override
	public List<SmsUserDO> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(SmsUserDO user){
		return userDao.save(user);
	}
	
	@Override
	public int update(SmsUserDO user){
		return userDao.update(user);
	}
	
	@Override
	public int remove(Integer id){
		return userDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return userDao.batchRemove(ids);
	}
	
}
