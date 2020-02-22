package com.ecotourism.supplier.sms.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
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

import com.ecotourism.supplier.sms.domain.SmsSupplierDO;
import com.ecotourism.supplier.sms.service.SmsSupplierService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 短信供应商
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
 
@Controller
@RequestMapping("/sms/supplier")
public class SmsSupplierController extends BaseController{
	@Autowired
	private SmsSupplierService supplierService;
	
	@GetMapping()
	@RequiresPermissions("sms:supplier:supplier")
	String Supplier(){
	    return "sms/supplier/supplier";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sms:supplier:supplier")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SmsSupplierDO> supplierList = supplierService.list(query);
		int total = supplierService.count(query);
		PageUtils pageUtils = new PageUtils(supplierList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sms:supplier:add")
	String add(){
	    return "sms/supplier/add";
	}

	@GetMapping("/edit/{supplierId}")
	@RequiresPermissions("sms:supplier:edit")
	String edit(@PathVariable("supplierId") Integer supplierId,Model model){
		SmsSupplierDO supplier = supplierService.get(supplierId);
		model.addAttribute("supplier", supplier);
	    return "sms/supplier/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sms:supplier:add")
	public R save( SmsSupplierDO supplier){
		supplier.setCreateUser(getUsername());
		supplier.setCreateTime(new Date());
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
	@RequiresPermissions("sms:supplier:edit")
	public R update( SmsSupplierDO supplier){
		supplier.setUpdateTime(new Date());
		supplier.setUpdateUser(getUsername());
		supplierService.update(supplier);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sms:supplier:remove")
	public R remove( Integer supplierId){
		if(supplierService.remove(supplierId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sms:supplier:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] supplierIds){
		supplierService.batchRemove(supplierIds);
		return R.ok();
	}
	
}
