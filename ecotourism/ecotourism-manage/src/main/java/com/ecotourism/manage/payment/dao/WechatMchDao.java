package com.ecotourism.manage.payment.dao;

import com.ecotourism.manage.payment.domain.WechatMchDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 微信商户号管理配置
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
@Mapper
public interface WechatMchDao {

	WechatMchDO get(Integer id);
	
	List<WechatMchDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	int findCountNo(String mch_no);

	int save(WechatMchDO wechatMch);
	
	int update(WechatMchDO wechatMch);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
