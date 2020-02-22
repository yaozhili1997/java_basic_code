package com.ecotourism.manage.payment.service.impl;

import com.ecotourism.manage.common.utils.ShiroUtils;
import com.ecotourism.manage.common.utils.Tools;
import com.ecotourism.manage.payment.dao.PaymentUserDao;
import com.ecotourism.manage.payment.domain.PaymentUserDO;
import com.ecotourism.manage.payment.service.PaymentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;



@Service
public class PaymentUserServiceImpl implements PaymentUserService {
	@Autowired
	private PaymentUserDao userDao;
	
	@Override
	public PaymentUserDO get(Integer id){
		return userDao.get(id);
	}
	
	@Override
	public List<PaymentUserDO> list(Map<String, Object> map){
		return userDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public int save(PaymentUserDO user){
		user.setUserNo(getNo());
		user.setCreateTime(new Date());
		user.setCreateUser(ShiroUtils.getUser().getUsername());
		return userDao.save(user);
	}
	private String getNo(){
		String userNo = Tools.getRandomString(6);
		int countNo = userDao.findCountNo(userNo);
		if(countNo>0){
			return getNo();
		}
		return userNo;
	}
	@Override
	public int update(PaymentUserDO user){
		user.setUpdateTime(new Date());
		user.setUpdateUser(ShiroUtils.getUser().getUsername());
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
