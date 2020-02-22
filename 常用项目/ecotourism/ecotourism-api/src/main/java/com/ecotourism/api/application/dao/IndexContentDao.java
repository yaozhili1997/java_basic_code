package com.ecotourism.api.application.dao;

import com.ecotourism.api.application.domain.IndexContentDO;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 应用首页轮播
 * @author 陈启勇
 * @date 2018-12-05 11:44:31
 */
@Mapper
public interface IndexContentDao {

	IndexContentDO get(Long cid);
	
	List<IndexContentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
}
