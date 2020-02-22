package com.ecotourism.manage.payment.dao;

import com.ecotourism.manage.payment.domain.PaymentUserDO;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

/**
 * 调用支付接口用户信息
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
@Mapper
public interface PaymentUserDao {

	PaymentUserDO get(Integer id);

	PaymentUserDO getByUserNo(String userNo);
	
	List<PaymentUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PaymentUserDO user);
	int findCountNo(String user_no);
	int update(PaymentUserDO user);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
