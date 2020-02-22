package com.ecotourism.api.application.service.impl;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.application.dao.IndexContentDao;
import com.ecotourism.api.application.domain.IndexContentDO;
import com.ecotourism.api.application.service.IndexContentService;
import com.ecotourism.api.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class IndexContentServiceImpl implements IndexContentService {
	@Autowired
	private IndexContentDao indexContentDao;
	
	@Override
	public IndexContentDO get(Long cid){
		return indexContentDao.get(cid);
	}
	
	@Override
	public List<IndexContentDO> list(Map<String, Object> map){
		return indexContentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return indexContentDao.count(map);
	}


	/**
	 * @Description 应用首页轮播图
	 * @author 陈启勇
	 * @Date 2018/12/5 12:01
	 * @Param [requestVo]
	 * @return com.ecotourism.api.common.utils.R
	 */
	public R listAppIndexImgs(RequestVo requestVo){
		Map<String, Object> map = new HashMap<>();
		map.put("belongApp",requestVo.getApplicationNo());
		return R.ok(list(map));
	}

}
