package com.ecotourism.supplier.product.service;

import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.product.domain.CarAddTicketDO;
import com.ecotourism.supplier.product.domain.CarTicketDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 文创产品
 *
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
public interface CarAddTicketService {

	CarAddTicketDO get(Integer productId);

	List<CarAddTicketDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	R save(CarAddTicketDO carTicket, MultipartFile img, MultipartFile[] files);

	R update(CarAddTicketDO carTicket, MultipartFile img, MultipartFile[] files);

	int remove(Integer productId);

	int batchRemove(Integer[] productIds);

	List<DictDO> list(List<DictDO> list, CarAddTicketDO carTicket);
}
