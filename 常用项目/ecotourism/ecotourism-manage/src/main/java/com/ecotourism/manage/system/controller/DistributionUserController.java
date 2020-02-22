package com.ecotourism.manage.system.controller;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.service.CooperationDistributionService;
import com.ecotourism.manage.system.domain.DistributionUserDO;
import com.ecotourism.manage.system.domain.RoleDO;
import com.ecotourism.manage.system.service.DistributionUserService;
import com.ecotourism.manage.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-27 09:28:04
 */
 
@Controller
@RequestMapping("/system/distributionUser")
public class DistributionUserController extends BaseController{
	@Autowired
	private DistributionUserService distributionUserService;
	@Autowired
	RoleService roleService;
	@Autowired
	private CooperationDistributionService cooperationDistributionService;
	@GetMapping()
	@RequiresPermissions("system:distributionUser:distributionUser")
	String DistributionUser(){
	    return "system/distributionUser/distributionUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:distributionUser:distributionUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DistributionUserDO> distributionUserList = distributionUserService.list(query);
		int total = distributionUserService.count(query);
		PageUtils pageUtils = new PageUtils(distributionUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:distributionUser:add")
	String add(Model model){
		Map<String, Object> query = new HashMap<>(16);
		query.put("companyNo",getComPanyNo());
		List<RoleDO> roles = roleService.list(query);
		model.addAttribute("roles", roles);
		return "system/distributionUser/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("system:distributionUser:edit")
	String edit(@PathVariable("userId") Long userId, Model model){
		DistributionUserDO distributionUser = distributionUserService.get(userId);
		Map<String, Object> query = new HashMap<>(16);
		query.put("companyNo",getComPanyNo());
		List<RoleDO> roles = roleService.list(userId,query);
		List<CooperationDistributionDO> cooperationDistributionList= cooperationDistributionService.list(query);
		model.addAttribute("roles", roles);
		model.addAttribute("distributionUser", distributionUser);
		model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
	    return "system/distributionUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:distributionUser:add")
	public R save( DistributionUserDO distributionUser){
		if(distributionUserService.save(distributionUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:distributionUser:edit")
	public R update( DistributionUserDO distributionUser){
		distributionUserService.update(distributionUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:distributionUser:remove")
	public R remove( Long userId){
		if(distributionUserService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:distributionUser:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] userIds){
		distributionUserService.batchRemove(userIds);
		return R.ok();
	}


	
}
