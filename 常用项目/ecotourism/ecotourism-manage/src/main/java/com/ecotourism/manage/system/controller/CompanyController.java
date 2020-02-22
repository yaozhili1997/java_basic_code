package com.ecotourism.manage.system.controller;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.*;
import com.ecotourism.manage.system.domain.CompanyDO;
import com.ecotourism.manage.system.service.CompanyService;
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
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-05-29 21:50:51
 */
 
@Controller
@RequestMapping("/system/company")
public class CompanyController extends BaseController{
	@Autowired
	private CompanyService companyService;
	
	@GetMapping()
	@RequiresPermissions("system:company:company")
	String Company(){
	    return "system/company/company";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:company:company")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CompanyDO> companyList = companyService.list(query);
		int total = companyService.count(query);
		PageUtils pageUtils = new PageUtils(companyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:company:add")
	String add(){
	    return "system/company/add";
	}

	@GetMapping("/edit/{departmentId}")
	@RequiresPermissions("system:company:edit")
	String edit(@PathVariable("departmentId") String departmentId, Model model){
		CompanyDO company = companyService.get(departmentId);
		model.addAttribute("company", company);
	    return "system/company/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:company:add")
	public R save( CompanyDO company){
		company.setDepartmentId(UuidUtils.getUUID());
		company.setBianma(RandomUtils.getRandomString(8));
		if(companyService.save(company)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:company:edit")
	public R update( CompanyDO company){
		companyService.update(company);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:company:remove")
	public R remove( String departmentId){
		if(companyService.remove(departmentId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:company:batchRemove")
	public R remove(@RequestParam("ids[]") String[] departmentIds){
		companyService.batchRemove(departmentIds);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/listAll")
	public List<CompanyDO> listAll() {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("bianma",getComPanyNo());
		List<CompanyDO> dictList = companyService.list(map);
		return dictList;
	}
	
}
