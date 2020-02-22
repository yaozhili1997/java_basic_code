package com.ecotourism.manage.print.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.print.service.PrintItemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecotourism.manage.print.domain.PrintTemplateDO;
import com.ecotourism.manage.print.service.PrintTemplateService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-20 11:13:06
 */
 
@Controller
@RequestMapping("/print/printTemplate")
public class PrintTemplateController {
	@Autowired
	private PrintTemplateService printTemplateService;
	@Autowired
	private PrintItemService printItemService;
	@GetMapping()
	@RequiresPermissions("print:printTemplate:printTemplate")
	String PrintTemplate(){
	    return "print/printTemplate/printTemplate";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("print:printTemplate:printTemplate")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PrintTemplateDO> printTemplateList = printTemplateService.list(query);
		int total = printTemplateService.count(query);
		PageUtils pageUtils = new PageUtils(printTemplateList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("print:printTemplate:add")
	String add(String id, Model model){
		model.addAttribute("id", id);
		try {
			model.addAttribute("printItems", printItemService.list(new HashMap<>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "print/printTemplate/designer/designer";
	}
	@GetMapping("/edit/{id}")
	@RequiresPermissions("print:printTemplate:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PrintTemplateDO printTemplate = printTemplateService.get(id);
		model.addAttribute("id", id);
		model.addAttribute("printTemplate", printTemplate);
		model.addAttribute("printItems", printItemService.list(new HashMap<>()));
	    return "print/printTemplate/designer/designer";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("print:printTemplate:add")
	public R save( PrintTemplateDO printTemplate){
		if(printTemplate.getId() == null){
			printTemplate.setCreated(new Date());
			printTemplate.setModified(new Date());
			printTemplate.setOrderby(1);
			printTemplate.setStatus("1");
			if(printTemplateService.save(printTemplate)>0){
				return R.ok();
			}
		}else{
			printTemplateService.update(printTemplate);
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("print:printTemplate:edit")
	public R update( PrintTemplateDO printTemplate){
		printTemplateService.update(printTemplate);
		return R.ok();
	}

	@PostMapping(value = "/changeTemplateStatus")
	@ResponseBody
	public R changeTemplateStatus(int id,String cmd ) {
		String label = "禁用";
		if ("start".equals(cmd)) {
			label = "启用";
		} else {
			label = "禁用";
		}
		try {
			printTemplateService.changeStatus(id, cmd);
			return R.ok("模板" + label + "成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.ok("模板" + label + "失败");
	}
	
}
