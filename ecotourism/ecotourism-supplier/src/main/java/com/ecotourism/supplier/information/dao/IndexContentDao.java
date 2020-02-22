package com.ecotourism.supplier.information.dao;

import com.ecotourism.supplier.information.domain.IndexContentDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文章内容
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-10-24 11:55:37
 */
@Mapper
public interface IndexContentDao {

	IndexContentDO get(Long cid);
	
	List<IndexContentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IndexContentDO indexContent);
	
	int update(IndexContentDO indexContent);
	
	int remove(Long cid);
	
	int batchRemove(Long[] cids);
}
