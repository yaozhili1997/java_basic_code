package com.ecotourism.supplier.system.controller;

import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.system.domain.DictTypeDO;
import com.ecotourism.supplier.system.service.DictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 字典类型表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-30 15:33:01
 */
 
@Controller
@RequestMapping("/system/dictType")
public class DictTypeController {
	@Autowired
	private DictTypeService dictTypeService;
	
	@GetMapping()
	@RequiresPermissions("system:dictType:dictType")
	String DictType(){
	    return "system/dictType/dictType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:dictType:dictType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DictTypeDO> dictTypeList = dictTypeService.list(query);
		int total = dictTypeService.count(query);
		PageUtils pageUtils = new PageUtils(dictTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:dictType:add")
	String add(){
	    return "system/dictType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:dictType:edit")
	String edit(@PathVariable("id") Long id, Model model){
		DictTypeDO dictType = dictTypeService.get(id);
		model.addAttribute("dictType", dictType);
	    return "system/dictType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:dictType:add")
	public R save( DictTypeDO dictType){
		if(dictTypeService.save(dictType)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:dictType:edit")
	public R update( DictTypeDO dictType){
		dictTypeService.update(dictType);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:dictType:remove")
	public R remove( Long id){
		return dictTypeService.remove(id);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:dictType:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){

		return dictTypeService.batchRemove(ids);
	}
	
}
