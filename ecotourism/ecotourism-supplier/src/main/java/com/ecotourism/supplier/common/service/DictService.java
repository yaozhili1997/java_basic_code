package com.ecotourism.supplier.common.service;

import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2017-09-29 18:28:07
 */
public interface DictService {
	
	DictDO get(Long id);
	
	List<DictDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DictDO dict);
	
	int update(DictDO dict);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<DictDO> listType();
	
	String getName(String type, String value, String companyNo);

	/**
	 * 获取爱好列表
	 * @return
     * @param userDO
	 */
	List<DictDO> getHobbyList(UserDO userDO);

	/**
	 * 获取性别列表
 	 * @return
	 */
	List<DictDO> getSexList();

	/**
	 * 根据type获取数据
	 * @param map
	 * @return
	 */
	List<DictDO> listByType(String type);

    /**
     * 将对象中的字典字段变为name
     * @param obj
     * @return
     */
	Object buildDictName(Object obj);
}
