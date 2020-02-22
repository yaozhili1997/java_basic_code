package com.ecotourism.supplier.base.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.base.domain.AreaManagementDO;
import com.ecotourism.supplier.base.service.AreaManagementService;
import com.ecotourism.supplier.common.controller.BaseController;
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

import com.ecotourism.supplier.base.domain.SpotManagementDO;
import com.ecotourism.supplier.base.service.SpotManagementService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 景点管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
 
@Controller
@RequestMapping("/base/spotManagement")
public class SpotManagementController extends BaseController{
	@Autowired
	private SpotManagementService spotManagementService;
	@Autowired
	private AreaManagementService areaManagementService;
	
	@GetMapping()
	@RequiresPermissions("base:spotManagement:spotManagement")
	String SpotManagement(){
	    return "base/spotManagement/spotManagement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:spotManagement:spotManagement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SpotManagementDO> spotManagementList = spotManagementService.list(query);
		int total = spotManagementService.count(query);
		PageUtils pageUtils = new PageUtils(spotManagementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:spotManagement:add")
	String add(){
	    return "base/spotManagement/add";
	}

	@GetMapping("/edit/{spotId}")
	@RequiresPermissions("base:spotManagement:edit")
	String edit(@PathVariable("spotId") Integer spotId,Model model){
		SpotManagementDO spotManagement = spotManagementService.get(spotId);
		List<AreaManagementDO> areaList = areaManagementService.list(new HashMap<>());
		model.addAttribute("spotManagement", spotManagement);
		model.addAttribute("areaLists", areaList);
	    return "base/spotManagement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:spotManagement:add")
	public R save( SpotManagementDO spotManagement){
		spotManagement.setSpotNo(RandomUtils.getRandomString(8));
		spotManagement.setCreateUser(getUsername());
		spotManagement.setCreateTime(new Date());
		if(spotManagementService.save(spotManagement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:spotManagement:edit")
	public R update( SpotManagementDO spotManagement){
		spotManagementService.update(spotManagement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:spotManagement:remove")
	public R remove( Integer spotId){
		if(spotManagementService.remove(spotId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:spotManagement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] spotIds){
		spotManagementService.batchRemove(spotIds);
		return R.ok();
	}
	
}
