package com.ecotourism.manage.base.service.impl;

import com.ecotourism.manage.base.dao.SpotManagementDao;
import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.common.utils.BuildTree;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.dao.AreaManagementDao;
import com.ecotourism.manage.base.domain.AreaManagementDO;
import com.ecotourism.manage.base.service.AreaManagementService;



@Service
public class AreaManagementServiceImpl implements AreaManagementService {
	@Autowired
	private AreaManagementDao areaManagementDao;
	@Autowired
	private SpotManagementDao spotManagementDao;
	
	@Override
	public AreaManagementDO get(Integer areaId){
		return areaManagementDao.get(areaId);
	}
	
	@Override
	public List<AreaManagementDO> list(Map<String, Object> map){
		return areaManagementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return areaManagementDao.count(map);
	}
	
	@Override
	public int save(AreaManagementDO areaManagement){
		return areaManagementDao.save(areaManagement);
	}
	
	@Override
	public int update(AreaManagementDO areaManagement){
		return areaManagementDao.update(areaManagement);
	}
	
	@Override
	public R remove(Integer areaId){
		AreaManagementDO bean = get(areaId);
		if(StringUtils.isNotBlank(bean.getAreaNo())){
			Map<String, Object> map = new HashMap<>();
			map.put("areaNo",bean.getAreaNo());
			int count = spotManagementDao.countAll(map);
			if(count>0){
				return R.error("存在使用景点，无法删除!");
			}
			if(areaManagementDao.remove(areaId)>0){
				return R.ok();
			}
		}
		return R.error();
	}
	
	@Override
	public R batchRemove(Integer[] areaIds){
		for(int i=0;i<areaIds.length;i++){
			AreaManagementDO bean = get(areaIds[i]);
			if(StringUtils.isNotBlank(bean.getAreaNo())){
				Map<String, Object> map = new HashMap<>();
				map.put("areaNo",bean.getAreaNo());
				int count = spotManagementDao.countAll(map);
				if(count>0){
					return R.error("存在使用景点，无法删除!");
				}
			}
		}
		if(areaManagementDao.batchRemove(areaIds) >0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public Tree<AreaManagementDO> getTree(Map<String, Object> map) {
		List<Tree<AreaManagementDO>> trees = new ArrayList<Tree<AreaManagementDO>>();
		List<AreaManagementDO> sysDepts = areaManagementDao.list(map);
		for (AreaManagementDO sysDept : sysDepts) {
			Tree<AreaManagementDO> tree = new Tree<AreaManagementDO>();
			tree.setId(sysDept.getAreaNo());
			tree.setParentId("0");
			tree.setText(sysDept.getAreaName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<AreaManagementDO> t = BuildTree.build(trees);
		return t;
	}

}
