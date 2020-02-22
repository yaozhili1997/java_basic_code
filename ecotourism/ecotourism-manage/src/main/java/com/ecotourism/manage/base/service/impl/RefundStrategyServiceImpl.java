package com.ecotourism.manage.base.service.impl;

import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.dao.RefundStrategyDao;
import com.ecotourism.manage.base.domain.RefundStrategyDO;
import com.ecotourism.manage.base.service.RefundStrategyService;



@Service
public class RefundStrategyServiceImpl implements RefundStrategyService {
	@Autowired
	private RefundStrategyDao refundStrategyDao;
	
	@Override
	public RefundStrategyDO get(Integer strategyId){
		return refundStrategyDao.get(strategyId);
	}
	
	@Override
	public List<RefundStrategyDO> list(Map<String, Object> map){
		return refundStrategyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return refundStrategyDao.count(map);
	}
	
	@Override
	public int save(RefundStrategyDO refundStrategy){
		return refundStrategyDao.save(refundStrategy);
	}
	
	@Override
	public int update(RefundStrategyDO refundStrategy){
		return refundStrategyDao.update(refundStrategy);
	}
	
	@Override
	public int remove(Integer strategyId){
		return refundStrategyDao.remove(strategyId);
	}
	
	@Override
	public int batchRemove(Integer[] strategyIds){
		return refundStrategyDao.batchRemove(strategyIds);
	}

	@Override
	public Tree<RefundStrategyDO> getTree(Map<String, Object> map) {
		List<Tree<RefundStrategyDO>> trees = new ArrayList<Tree<RefundStrategyDO>>();
		List<RefundStrategyDO> sysDepts = refundStrategyDao.list(map);
		for (RefundStrategyDO sysDept : sysDepts) {
			Tree<RefundStrategyDO> tree = new Tree<RefundStrategyDO>();
			tree.setId(sysDept.getStrategyNo());
			tree.setParentId("0");
			tree.setText(sysDept.getStrategyName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<RefundStrategyDO> t = BuildTree.build(trees);
		return t;
	}

}
