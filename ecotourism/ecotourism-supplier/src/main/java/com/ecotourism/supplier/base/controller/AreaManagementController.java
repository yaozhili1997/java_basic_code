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

import com.ecotourism.supplier.base.domain.AreaManagementDO;
import com.ecotourism.supplier.base.service.AreaManagementService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 景区管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
 
@Controller
@RequestMapping("/base/areaManagement")
public class AreaManagementController extends BaseController{
	@Autowired
	private AreaManagementService areaManagementService;
	
	@GetMapping()
	@RequiresPermissions("base:areaManagement:areaManagement")
	String AreaManagement(){
	    return "base/areaManagement/areaManagement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:areaManagement:areaManagement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AreaManagementDO> areaManagementList = areaManagementService.list(query);
		int total = areaManagementService.count(query);
		PageUtils pageUtils = new PageUtils(areaManagementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:areaManagement:add")
	String add(){
	    return "base/areaManagement/add";
	}

	@GetMapping("/edit/{areaId}")
	@RequiresPermissions("base:areaManagement:edit")
	String edit(@PathVariable("areaId") Integer areaId,Model model){
		AreaManagementDO areaManagement = areaManagementService.get(areaId);
		model.addAttribute("areaManagement", areaManagement);
	    return "base/areaManagement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:areaManagement:add")
	public R save( AreaManagementDO areaManagement){
		areaManagement.setCreateUser(getUsername());
		areaManagement.setCreateTime(new Date());
		areaManagement.setAreaNo(RandomUtils.getRandomString(8));
		if(areaManagementService.save(areaManagement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:areaManagement:edit")
	public R update( AreaManagementDO areaManagement){
		areaManagement.setUpdateTime(new Date());
		areaManagement.setUpdateUser(getUsername());
		areaManagementService.update(areaManagement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:areaManagement:remove")
	public R remove( Integer areaId){
		return areaManagementService.remove(areaId);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:areaManagement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] areaIds){
		return areaManagementService.batchRemove(areaIds);
	}
	@GetMapping("/tree")
	@ResponseBody
	public Tree<AreaManagementDO> tree() {
		Map<String, Object> query = new HashMap<>(16);
		Tree<AreaManagementDO> tree = new Tree<AreaManagementDO>();
		tree = areaManagementService.getTree(query);
		return tree;
	}

	@ResponseBody
	@GetMapping("/listAll")
	public List<AreaManagementDO> listAll(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		List<AreaManagementDO> areaManagementList = areaManagementService.list(map);
		return areaManagementList;
	}
	
}
