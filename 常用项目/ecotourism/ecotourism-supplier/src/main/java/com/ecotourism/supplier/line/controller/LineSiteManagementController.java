package com.ecotourism.supplier.line.controller;

import java.util.List;
import java.util.Map;

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

import com.ecotourism.supplier.line.domain.LineSiteManagementDO;
import com.ecotourism.supplier.line.service.LineSiteManagementService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-09 16:11:27
 */
 
@Controller
@RequestMapping("/line/siteManagement")
public class LineSiteManagementController {
	@Autowired
	private LineSiteManagementService siteManagementService;
	
	@GetMapping()
	@RequiresPermissions("line:siteManagement:siteManagement")
	String SiteManagement(){
	    return "line/siteManagement/siteManagement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("line:siteManagement:siteManagement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LineSiteManagementDO> siteManagementList = siteManagementService.list(query);
		int total = siteManagementService.count(query);
		PageUtils pageUtils = new PageUtils(siteManagementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("line:siteManagement:add")
	String add(){
	    return "line/siteManagement/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("line:siteManagement:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LineSiteManagementDO siteManagement = siteManagementService.get(id);
		model.addAttribute("siteManagement", siteManagement);
	    return "line/siteManagement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("line:siteManagement:add")
	public R save( LineSiteManagementDO siteManagement){
		if(siteManagementService.save(siteManagement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("line:siteManagement:edit")
	public R update( LineSiteManagementDO siteManagement){
		siteManagementService.update(siteManagement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("line:siteManagement:remove")
	public R remove( Integer id){
		if(siteManagementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("line:siteManagement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		siteManagementService.batchRemove(ids);
		return R.ok();
	}
	
}
