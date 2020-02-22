package com.ecotourism.manage.img.dao;

import com.ecotourism.manage.img.domain.ImgDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:40:19
 */
@Mapper
public interface ImgDao {

	ImgDO get(Integer id);
	
	List<ImgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ImgDO img);
	
	int update(ImgDO img);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
