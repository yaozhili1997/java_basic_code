package com.ecotourism.manage.payment.service.impl;

import com.ecotourism.manage.common.utils.ShiroUtils;
import com.ecotourism.manage.common.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.payment.dao.WechatDao;
import com.ecotourism.manage.payment.domain.WechatDO;
import com.ecotourism.manage.payment.service.WechatService;



@Service
public class WechatServiceImpl implements WechatService {
	@Autowired
	private WechatDao wechatDao;
	
	@Override
	public WechatDO get(Integer id){
		return wechatDao.get(id);
	}
	
	@Override
	public List<WechatDO> list(Map<String, Object> map){
		return wechatDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wechatDao.count(map);
	}
	
	@Override
	public int save(WechatDO wechat){
		wechat.setWechatNo(getNo());
		wechat.setCreateTime(new Date());
		wechat.setCreateUser(ShiroUtils.getUser().getUsername());
		return wechatDao.save(wechat);
	}
	private String getNo(){
		String mchNo = Tools.getRandomString(6);
		int countNo = wechatDao.findCountNo(mchNo);
		if(countNo>0){
			return getNo();
		}
		return mchNo;
	}
	@Override
	public int update(WechatDO wechat){
		wechat.setUpdateTime(new Date());
		wechat.setUpdateUser(ShiroUtils.getUser().getUsername());
		return wechatDao.update(wechat);
	}
	
	@Override
	public int remove(Integer id){
		return wechatDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wechatDao.batchRemove(ids);
	}
	
}
