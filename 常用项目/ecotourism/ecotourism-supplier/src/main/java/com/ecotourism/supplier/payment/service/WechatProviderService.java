package com.ecotourism.supplier.payment.service;

import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.payment.domain.WechatProviderDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 微信商户号管理配置
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
public interface WechatProviderService {
	
	WechatProviderDO get(Integer id);
	
	List<WechatProviderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(WechatProviderDO wechatProvider, MultipartFile file);
	
	R update(WechatProviderDO wechatProvider, MultipartFile file);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
