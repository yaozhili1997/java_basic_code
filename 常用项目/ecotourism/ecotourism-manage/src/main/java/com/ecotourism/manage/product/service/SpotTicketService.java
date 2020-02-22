package com.ecotourism.manage.product.service;

import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.product.domain.SpotTicketDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 景区门票
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
public interface SpotTicketService {
	
	SpotTicketDO get(Integer productId);
	
	List<SpotTicketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(SpotTicketDO spotTicket, MultipartFile img, MultipartFile[] files);
	
	R update(SpotTicketDO spotTicket, MultipartFile img, MultipartFile[] files);
	
	int remove(Integer productId);

	R changeSort( Integer productId,Integer sort);

	
	int batchRemove(Integer[] productIds);

	List<DictDO> list(List<DictDO> list,SpotTicketDO spotTicket);
}
