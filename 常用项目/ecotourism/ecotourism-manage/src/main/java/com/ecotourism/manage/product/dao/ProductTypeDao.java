package com.ecotourism.manage.product.dao;

import com.ecotourism.manage.product.domain.ProductTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-15 09:47:13
 */
@Mapper
public interface ProductTypeDao {

	ProductTypeDO get(Integer id);

	List<ProductTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProductTypeDO productType);
	
	int update(ProductTypeDO productType);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	int countChildrenType(Integer[] ids);
	String findProductTypeNo(Map<String, Object> map);

	List<ProductTypeDO> listParent(Map<String, Object> map);

	List<ProductTypeDO> listChildren(Map<String, Object> map);

}
