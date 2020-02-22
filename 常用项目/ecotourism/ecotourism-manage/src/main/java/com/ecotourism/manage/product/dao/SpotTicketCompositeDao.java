package com.ecotourism.manage.product.dao;

import com.ecotourism.manage.product.domain.SpotTicketCompositeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
@Mapper
public interface SpotTicketCompositeDao {

	SpotTicketCompositeDO get(Integer id);
	
	List<SpotTicketCompositeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SpotTicketCompositeDO spotTicketComposite);
	
	int update(SpotTicketCompositeDO spotTicketComposite);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
