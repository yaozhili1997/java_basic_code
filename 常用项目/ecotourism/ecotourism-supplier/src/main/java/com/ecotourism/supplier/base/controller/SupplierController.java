package com.ecotourism.supplier.base.controller;

import java.util.List;
import java.util.Map;

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

import com.ecotourism.supplier.base.domain.SupplierDO;
import com.ecotourism.supplier.base.service.SupplierService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 供应商管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-04 21:48:30
 */
 
@Controller
@RequestMapping("/base/supplier")
public class SupplierController extends BaseController{
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping()
	@RequiresPermissions("base:supplier:supplier")
	String Supplier(){
	    return "base/supplier/supplier";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:supplier:supplier")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<SupplierDO> supplierList = supplierService.list(query);
		int total = supplierService.count(query);
		PageUtils pageUtils = new PageUtils(supplierList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("base:supplier:add")
	String add(){
	    return "base/supplier/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("base:supplier:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SupplierDO supplier = supplierService.get(id);
		model.addAttribute("supplier", supplier);
	    return "base/supplier/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:supplier:add")
	public R save( SupplierDO supplier){
		supplier.setSupplierNo(RandomUtils.getRandomString(8));
		supplier.setCompanyNo(getComPanyNo());
		if(supplierService.save(supplier)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:supplier:edit")
	public R update( SupplierDO supplier){
		supplierService.update(supplier);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:supplier:remove")
	public R remove( Integer id){
		if(supplierService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:supplier:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		supplierService.batchRemove(ids);
		return R.ok();
	}
	
}
