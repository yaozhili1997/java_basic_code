package com.ecotourism.manage.print.dao;

import com.ecotourism.manage.print.domain.PrintImgDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
@Mapper
public interface PrintImgDao {

	PrintImgDO get(Long id);
	
	List<PrintImgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PrintImgDO printImg);
	
	int update(PrintImgDO printImg);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
