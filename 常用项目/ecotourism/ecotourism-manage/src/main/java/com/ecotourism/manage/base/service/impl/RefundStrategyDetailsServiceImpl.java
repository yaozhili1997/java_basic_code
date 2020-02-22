package com.ecotourism.manage.base.service.impl;

import com.ecotourism.manage.base.domain.RefundStrategyDO;
import com.ecotourism.manage.base.service.RefundStrategyService;
import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.common.utils.BuildTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.dao.RefundStrategyDetailsDao;
import com.ecotourism.manage.base.domain.RefundStrategyDetailsDO;
import com.ecotourism.manage.base.service.RefundStrategyDetailsService;



@Service
public class RefundStrategyDetailsServiceImpl implements RefundStrategyDetailsService {
	@Autowired
	private RefundStrategyDetailsDao refundStrategyDetailsDao;
	@Autowired
	private RefundStrategyService refundStrategyService;
	@Override
	public RefundStrategyDetailsDO get(Integer strategyDetailId){
		return refundStrategyDetailsDao.get(strategyDetailId);
	}
	
	@Override
	public List<RefundStrategyDetailsDO> list(Map<String, Object> map){
		return refundStrategyDetailsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return refundStrategyDetailsDao.count(map);
	}
	
	@Override
	public int save(RefundStrategyDetailsDO refundStrategyDetails){
		return refundStrategyDetailsDao.save(refundStrategyDetails);
	}
	
	@Override
	public int update(RefundStrategyDetailsDO refundStrategyDetails){
		return refundStrategyDetailsDao.update(refundStrategyDetails);
	}
	
	@Override
	public int remove(Integer strategyDetailId){
		return refundStrategyDetailsDao.remove(strategyDetailId);
	}
	
	@Override
	public int batchRemove(Integer[] strategyDetailIds){
		return refundStrategyDetailsDao.batchRemove(strategyDetailIds);
	}

	@Override
	public Tree<RefundStrategyDO> getTree(Map<String, Object> map) {
		List<Tree<RefundStrategyDO>> trees = new ArrayList<Tree<RefundStrategyDO>>();
		List<RefundStrategyDO> refundStrategys = refundStrategyService.list(map);
		List<RefundStrategyDetailsDO> refundStrategyDetails = refundStrategyDetailsDao.list(map);
		for (RefundStrategyDO dept : refundStrategys) {
			Tree<RefundStrategyDO> tree = new Tree<RefundStrategyDO>();
			tree.setId(dept.getStrategyNo());
			tree.setParentId("0");
			tree.setText(dept.getStrategyName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			state.put("mType", "dept");
			tree.setState(state);
			trees.add(tree);
		}
		for (RefundStrategyDetailsDO refundStrategy : refundStrategyDetails) {
			Tree<RefundStrategyDO> tree = new Tree<RefundStrategyDO>();
			tree.setId(refundStrategy.getStrategyDetailNo());
			tree.setParentId(refundStrategy.getStrategyNo());
			tree.setText(refundStrategy.getStrategyDetailName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			state.put("mType", "user");
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<RefundStrategyDO> t = BuildTree.build(trees);
		return t;
	}

}
