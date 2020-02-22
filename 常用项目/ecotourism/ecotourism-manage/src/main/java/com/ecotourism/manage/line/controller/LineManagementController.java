package com.ecotourism.manage.line.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.RandomUtils;
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

import com.ecotourism.manage.line.domain.LineManagementDO;
import com.ecotourism.manage.line.service.LineManagementService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-09 16:11:27
 */
 
@Controller
@RequestMapping("/line/management")
public class LineManagementController extends BaseController {
	@Autowired
	private LineManagementService managementService;
	
	@GetMapping()
	@RequiresPermissions("line:management:management")
	String Management(){
	    return "line/management/management";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("line:management:management")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<LineManagementDO> managementList = managementService.list(query);
		int total = managementService.count(query);
		PageUtils pageUtils = new PageUtils(managementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("line:management:add")
	String add(){
	    return "line/management/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("line:management:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LineManagementDO management = managementService.get(id);
		model.addAttribute("management", management);
	    return "line/management/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("line:management:add")
	public R save( LineManagementDO management){
		management.setCompanyNo(getComPanyNo());
		management.setCreateUser(getUsername());
		management.setCreateTime(new Date());
		management.setLineNo(RandomUtils.getRandomString(6));
		if(managementService.save(management)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("line:management:edit")
	public R update( LineManagementDO management){
		management.setUpdateUser(getUsername());
		management.setUpdateTime(new Date());
		managementService.update(management);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("line:management:remove")
	public R remove( Integer id){
		if(managementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("line:management:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		managementService.batchRemove(ids);
		return R.ok();
	}
	
}
