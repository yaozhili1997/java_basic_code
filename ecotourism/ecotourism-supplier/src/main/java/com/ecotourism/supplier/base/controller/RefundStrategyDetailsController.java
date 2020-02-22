package com.ecotourism.supplier.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.base.domain.RefundStrategyDO;
import com.ecotourism.supplier.base.service.RefundStrategyService;
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

import com.ecotourism.supplier.base.domain.RefundStrategyDetailsDO;
import com.ecotourism.supplier.base.service.RefundStrategyDetailsService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 退票策略明细
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
 
@Controller
@RequestMapping("/base/refundStrategyDetails")
public class RefundStrategyDetailsController extends BaseController{
	@Autowired
	private RefundStrategyDetailsService refundStrategyDetailsService;
	@Autowired
	private RefundStrategyService refundStrategyService;
	@GetMapping()
	@RequiresPermissions("base:refundStrategyDetails:refundStrategyDetails")
	String RefundStrategyDetails(){
	    return "base/refundStrategyDetails/refundStrategyDetails";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:refundStrategyDetails:refundStrategyDetails")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<RefundStrategyDetailsDO> refundStrategyDetailsList = refundStrategyDetailsService.list(query);
		int total = refundStrategyDetailsService.count(query);
		PageUtils pageUtils = new PageUtils(refundStrategyDetailsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:refundStrategyDetails:add")
	String add(){
	    return "base/refundStrategyDetails/add";
	}

	@GetMapping("/edit/{strategyDetailId}")
	@RequiresPermissions("base:refundStrategyDetails:edit")
	String edit(@PathVariable("strategyDetailId") Integer strategyDetailId,Model model){
		RefundStrategyDetailsDO refundStrategyDetails = refundStrategyDetailsService.get(strategyDetailId);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<RefundStrategyDO> refundStrategyList = refundStrategyService.list(map);
		model.addAttribute("refundStrategyDetails", refundStrategyDetails);
		model.addAttribute("refundStrategyLists", refundStrategyList);
	    return "base/refundStrategyDetails/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:refundStrategyDetails:add")
	public R save( RefundStrategyDetailsDO refundStrategyDetails){
		refundStrategyDetails.setStrategyDetailNo(RandomUtils.getRandomString(8));
		refundStrategyDetails.setCompanyNo(getComPanyNo());
		if(refundStrategyDetailsService.save(refundStrategyDetails)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:refundStrategyDetails:edit")
	public R update( RefundStrategyDetailsDO refundStrategyDetails){
		refundStrategyDetailsService.update(refundStrategyDetails);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:refundStrategyDetails:remove")
	public R remove( Integer strategyDetailId){
		if(refundStrategyDetailsService.remove(strategyDetailId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:refundStrategyDetails:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] strategyDetailIds){
		refundStrategyDetailsService.batchRemove(strategyDetailIds);
		return R.ok();
	}

	@GetMapping("/treeView")
	String treeView() {
		return  "base/refundStrategyDetails/refundStrategyTree";
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<RefundStrategyDO> tree() {
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		Tree<RefundStrategyDO> tree = new Tree<RefundStrategyDO>();
		tree = refundStrategyDetailsService.getTree(map);
		return tree;
	}
	
}
