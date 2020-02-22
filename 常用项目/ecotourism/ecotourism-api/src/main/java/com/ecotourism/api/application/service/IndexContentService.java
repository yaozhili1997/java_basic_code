package com.ecotourism.api.application.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.application.domain.IndexContentDO;
import com.ecotourism.api.common.utils.R;

import java.util.List;
import java.util.Map;

/**
 * 应用首页轮播
 * @author 陈启勇
 * @date 2018-12-05 11:44:31
 */
public interface IndexContentService {
	
	IndexContentDO get(Long cid);
	
	List<IndexContentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	/**
	 * @Description 应用首页轮播图
	 * @author 陈启勇
	 * @Date 2018/12/5 12:01
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	R listAppIndexImgs(RequestVo requestVo);
}
