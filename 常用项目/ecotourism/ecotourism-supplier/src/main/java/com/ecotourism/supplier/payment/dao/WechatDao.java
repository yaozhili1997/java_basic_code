package com.ecotourism.supplier.payment.dao;

import com.ecotourism.supplier.payment.domain.WechatDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 微信公众号或小程序信息管理
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
@Mapper
public interface WechatDao {

	WechatDO get(Integer id);
	
	List<WechatDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	int findCountNo(String wechat_no);

	int save(WechatDO wechat);
	
	int update(WechatDO wechat);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
