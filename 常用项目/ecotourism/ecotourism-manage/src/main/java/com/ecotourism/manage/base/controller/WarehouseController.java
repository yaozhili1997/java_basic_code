package com.ecotourism.manage.base.controller;

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

import com.ecotourism.manage.base.domain.WarehouseDO;
import com.ecotourism.manage.base.service.WarehouseService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 仓库管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-04 21:07:44
 */
 
@Controller
@RequestMapping("/base/warehouse")
public class WarehouseController extends BaseController{
	@Autowired
	private WarehouseService warehouseService;
	
	@GetMapping()
	@RequiresPermissions("base:warehouse:warehouse")
	String Warehouse(){
	    return "base/warehouse/warehouse";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:warehouse:warehouse")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<WarehouseDO> warehouseList = warehouseService.list(query);
		int total = warehouseService.count(query);
		PageUtils pageUtils = new PageUtils(warehouseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:warehouse:add")
	String add(){
	    return "base/warehouse/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:warehouse:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WarehouseDO warehouse = warehouseService.get(id);
		model.addAttribute("warehouse", warehouse);
	    return "base/warehouse/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:warehouse:add")
	public R save( WarehouseDO warehouse){
		warehouse.setCompanyNo(getComPanyNo());
		warehouse.setWarehouseNo(RandomUtils.getRandomString(8));
		if(warehouseService.save(warehouse)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:warehouse:edit")
	public R update( WarehouseDO warehouse){
		warehouseService.update(warehouse);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:warehouse:remove")
	public R remove( Integer id){
		if(warehouseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:warehouse:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		warehouseService.batchRemove(ids);
		return R.ok();
	}
	
}
