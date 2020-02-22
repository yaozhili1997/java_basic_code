package com.ecotourism.supplier.system.service.impl;

import com.ecotourism.supplier.common.dao.DictDao;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.common.utils.StringUtils;
import com.ecotourism.supplier.system.dao.DictTypeDao;
import com.ecotourism.supplier.system.domain.DictTypeDO;
import com.ecotourism.supplier.system.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DictTypeServiceImpl implements DictTypeService {
	@Autowired
	private DictTypeDao dictTypeDao;
	@Autowired
	private DictDao dictDao;
	@Override
	public DictTypeDO get(Long id){
		return dictTypeDao.get(id);
	}
	
	@Override
	public List<DictTypeDO> list(Map<String, Object> map){
		return dictTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dictTypeDao.count(map);
	}
	
	@Override
	public int save(DictTypeDO dictType){
		return dictTypeDao.save(dictType);
	}
	
	@Override
	public int update(DictTypeDO dictType){
		return dictTypeDao.update(dictType);
	}
	
	@Override
	public R remove(Long id){
		DictTypeDO bean = get(id);
		if(StringUtils.isNotBlank(bean.getType())){
			Map<String, Object> map = new HashMap<>();
			map.put("type",bean.getType());
			int count = dictDao.countAll(map);
			if(count>0){
				return R.error("存在使用类型，无法删除!");
			}
			if(dictTypeDao.remove(id)>0){
				R.ok();
			}
		}
		return R.error();
	}
	
	@Override
	public R batchRemove(Long[] ids){
		for(int i=0;i<ids.length;i++){
			DictTypeDO bean = get(ids[i]);
			if(StringUtils.isNotBlank(bean.getType())){
				Map<String, Object> map = new HashMap<>();
				map.put("type",bean.getType());
				int count = dictDao.countAll(map);
				if(count>0){
					return R.error("存在使用类型，无法删除!");
				}
			}
		}
		if(dictTypeDao.batchRemove(ids)>0){
			R.ok();
		}
		return R.error();
	}
	
}
