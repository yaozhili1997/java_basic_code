package com.ecotourism.manage.product.service;

import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.product.domain.ProductTypeDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-15 09:47:13
 */
public interface ProductTypeService {
	
	ProductTypeDO get(Integer id);
	
	List<ProductTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(ProductTypeDO productType, MultipartFile icon, MultipartFile[] files);

	R update(ProductTypeDO productType, MultipartFile icon, MultipartFile[] files);

	R remove(Integer id);

	R batchRemove(Integer[] ids);

	Tree<ProductTypeDO> getTree(Map<String, Object> map);
}
