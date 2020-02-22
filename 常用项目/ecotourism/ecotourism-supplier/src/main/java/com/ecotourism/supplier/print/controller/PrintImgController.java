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

import com.ecotourism.supplier.print.domain.PrintImgDO;
import com.ecotourism.supplier.print.service.PrintImgService;
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
@RequestMapping("/print/printImg")
public class PrintImgController {
	@Autowired
	private PrintImgService printImgService;
	
	@GetMapping()
	@RequiresPermissions("print:printImg:printImg")
	String PrintImg(){
	    return "print/printImg/printImg";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("print:printImg:printImg")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PrintImgDO> printImgList = printImgService.list(query);
		int total = printImgService.count(query);
		PageUtils pageUtils = new PageUtils(printImgList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("print:printImg:add")
	String add(){
	    return "print/printImg/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("print:printImg:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PrintImgDO printImg = printImgService.get(id);
		model.addAttribute("printImg", printImg);
	    return "print/printImg/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("print:printImg:add")
	public R save( PrintImgDO printImg){
		if(printImgService.save(printImg)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("print:printImg:edit")
	public R update( PrintImgDO printImg){
		printImgService.update(printImg);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("print:printImg:remove")
	public R remove( Long id){
		if(printImgService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("print:printImg:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		printImgService.batchRemove(ids);
		return R.ok();
	}
	
}
