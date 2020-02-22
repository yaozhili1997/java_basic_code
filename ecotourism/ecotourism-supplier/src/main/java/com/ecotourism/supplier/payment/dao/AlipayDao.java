package com.ecotourism.supplier.payment.dao;

import com.ecotourism.supplier.payment.domain.AlipayDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
@Mapper
public interface AlipayDao {

	AlipayDO get(Long id);
	
	List<AlipayDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	int findCountNo(String alipay_no);

	int save(AlipayDO alipay);
	
	int update(AlipayDO alipay);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
