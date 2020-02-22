package com.ecotourism.supplier.base.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.domain.Tree;
import com.ecotourism.supplier.common.utils.RandomUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecotourism.supplier.base.domain.RefundStrategyDO;
import com.ecotourism.supplier.base.service.RefundStrategyService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 退票策略
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
 
@Controller
@RequestMapping("/base/refundStrategy")
public class RefundStrategyController extends BaseController{
	@Autowired
	private RefundStrategyService refundStrategyService;
	
	@GetMapping()
	@RequiresPermissions("base:refundStrategy:refundStrategy")
	String RefundStrategy(){
	    return "base/refundStrategy/refundStrategy";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:refundStrategy:refundStrategy")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<RefundStrategyDO> refundStrategyList = refundStrategyService.list(query);
		int total = refundStrategyService.count(query);
		PageUtils pageUtils = new PageUtils(refundStrategyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:refundStrategy:add")
	String add(){
	    return "base/refundStrategy/add";
	}

	@GetMapping("/edit/{strategyId}")
	@RequiresPermissions("base:refundStrategy:edit")
	String edit(@PathVariable("strategyId") Integer strategyId,Model model){
		RefundStrategyDO refundStrategy = refundStrategyService.get(strategyId);
		model.addAttribute("refundStrategy", refundStrategy);
	    return "base/refundStrategy/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:refundStrategy:add")
	public R save( RefundStrategyDO refundStrategy){
		refundStrategy.setStrategyNo(RandomUtils.getRandomString(8));
		refundStrategy.setCompanyNo(getComPanyNo());
		refundStrategy.setCreateTime(new Date());
		refundStrategy.setCreateUser(getUsername());
		if(refundStrategyService.save(refundStrategy)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:refundStrategy:edit")
	public R update( RefundStrategyDO refundStrategy){
		refundStrategy.setUpdateTime(new Date());
		refundStrategy.setUpdateUser(getUsername());
		refundStrategyService.update(refundStrategy);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:refundStrategy:remove")
	public R remove( Integer strategyId){
		if(refundStrategyService.remove(strategyId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:refundStrategy:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] strategyIds){
		refundStrategyService.batchRemove(strategyIds);
		return R.ok();
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<RefundStrategyDO> tree() {
		Map<String, Object> query = new HashMap<>(16);
		query.put("companyNo",getComPanyNo());
		Tree<RefundStrategyDO> tree = new Tree<RefundStrategyDO>();
		tree = refundStrategyService.getTree(query);
		return tree;
	}

	@ResponseBody
	@GetMapping("/listAll")
	public List<RefundStrategyDO> listAll(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<RefundStrategyDO> areaManagementList = refundStrategyService.list(map);
		return areaManagementList;
	}
}
