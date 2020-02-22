package com.ecotourism.manage.payment.service;

import com.ecotourism.manage.payment.domain.WechatDO;

import java.util.List;
import java.util.Map;

/**
 * 微信公众号或小程序信息管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
public interface WechatService {
	
	WechatDO get(Integer id);
	
	List<WechatDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WechatDO wechat);
	
	int update(WechatDO wechat);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
