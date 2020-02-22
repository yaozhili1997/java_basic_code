package com.ecotourism.manage.product.service;

import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.product.domain.HotelDO;
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
public interface HotelService {

	HotelDO get(Integer productId);

	List<HotelDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	R save(HotelDO hotel, MultipartFile img, MultipartFile[] files);

	R update(HotelDO creativeProduct, MultipartFile img, MultipartFile[] files);

	int remove(Integer productId);

	int batchRemove(Integer[] productIds);

	List<DictDO> list(List<DictDO> list, HotelDO hotel);
}
