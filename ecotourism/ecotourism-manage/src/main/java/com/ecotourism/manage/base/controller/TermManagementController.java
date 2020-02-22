package com.ecotourism.manage.base.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
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

import com.ecotourism.manage.base.domain.TermManagementDO;
import com.ecotourism.manage.base.service.TermManagementService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 期限管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
 
@Controller
@RequestMapping("/base/termManagement")
public class TermManagementController extends BaseController{
	@Autowired
	private TermManagementService termManagementService;
	@Autowired
	private DictService dictService;
	@GetMapping()
	@RequiresPermissions("base:termManagement:termManagement")
	String TermManagement(){
	    return "base/termManagement/termManagement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:termManagement:termManagement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<TermManagementDO> termManagementList = termManagementService.list(query);
		int total = termManagementService.count(query);
		PageUtils pageUtils = new PageUtils(termManagementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:termManagement:add")
	String add(){
	    return "base/termManagement/add";
	}

	@GetMapping("/edit/{termId}")
	@RequiresPermissions("base:termManagement:edit")
	String edit(@PathVariable("termId") Integer termId,Model model){
		TermManagementDO termManagement = termManagementService.get(termId);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "team_use_type");
		List<DictDO> teamUseTypeList = dictService.list(map);
		model.addAttribute("termManagement", termManagement);
		model.addAttribute("teamUseTypeLists", teamUseTypeList);
	    return "base/termManagement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:termManagement:add")
	public R save( TermManagementDO termManagement){
		termManagement.setTermNo(RandomUtils.getRandomString(8));
		termManagement.setCreateTime(new Date());
		termManagement.setCreateUser(getUsername());
		termManagement.setCompanyNo(getComPanyNo());
		if(termManagementService.save(termManagement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:termManagement:edit")
	public R update( TermManagementDO termManagement){
		termManagement.setUpdateTime(new Date());
		termManagement.setUpdateUser(getUsername());
		termManagementService.update(termManagement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:termManagement:remove")
	public R remove( Integer termId){
		if(termManagementService.remove(termId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:termManagement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] termIds){
		termManagementService.batchRemove(termIds);
		return R.ok();
	}
	
}
