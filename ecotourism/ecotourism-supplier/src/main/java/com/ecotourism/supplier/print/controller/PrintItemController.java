package com.ecotourism.supplier.print.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecotourism.supplier.print.domain.PrintItemDO;
import com.ecotourism.supplier.print.service.PrintItemService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
 
@Controller
@RequestMapping("/print/printItem")
public class PrintItemController {
	@Autowired
	private PrintItemService printItemService;
	
	@GetMapping()
	@RequiresPermissions("print:printItem:printItem")
	String PrintItem(){
	    return "print/printItem/printItem";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("print:printItem:printItem")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PrintItemDO> printItemList = printItemService.list(query);
		int total = printItemService.count(query);
		PageUtils pageUtils = new PageUtils(printItemList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("print:printItem:add")
	String add(){
	    return "print/printItem/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("print:printItem:edit")
	String edit(@PathVariable("id") String id,Model model){
		PrintItemDO printItem = printItemService.get(id);
		model.addAttribute("printItem", printItem);
	    return "print/printItem/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("print:printItem:add")
	public R save( PrintItemDO printItem){
		if(printItemService.save(printItem)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("print:printItem:edit")
	public R update( PrintItemDO printItem){
		printItemService.update(printItem);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("print:printItem:remove")
	public R remove( String id){
		if(printItemService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("print:printItem:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		printItemService.batchRemove(ids);
		return R.ok();
	}
	
}
