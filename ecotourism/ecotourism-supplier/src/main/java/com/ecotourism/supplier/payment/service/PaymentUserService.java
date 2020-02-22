package com.ecotourism.supplier.payment.service;

import com.ecotourism.supplier.payment.domain.PaymentUserDO;

import java.util.List;
import java.util.Map;

/**
 * 调用支付接口用户信息
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
public interface PaymentUserService {

	PaymentUserDO get(Integer id);
	
	List<PaymentUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaymentUserDO user);
	
	int update(PaymentUserDO user);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
