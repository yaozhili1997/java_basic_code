package com.ecotourism.supplier.sms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.RandomUtils;
import com.ecotourism.supplier.sms.domain.LabelDO;
import com.ecotourism.supplier.sms.domain.SmsSupplierDO;
import com.ecotourism.supplier.sms.service.LabelService;
import com.ecotourism.supplier.sms.service.SmsSupplierService;
import com.ecotourism.supplier.system.domain.CompanyDO;
import com.ecotourism.supplier.system.service.CompanyService;
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

import com.ecotourism.supplier.sms.domain.TemplateDO;
import com.ecotourism.supplier.sms.service.TemplateService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 短信模板
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
 
@Controller
@RequestMapping("/sms/template")
public class TemplateController extends BaseController {
	@Autowired
	private TemplateService templateService;
	@Autowired
	private SmsSupplierService supplierService;
	@Autowired
	private LabelService labelService;
	@Autowired
	private CompanyService companyService;
	@GetMapping()
	@RequiresPermissions("sms:template:template")
	String Template(){
	    return "sms/template/template";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sms:template:template")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<TemplateDO> templateList = templateService.list(query);
		int total = templateService.count(query);
		PageUtils pageUtils = new PageUtils(templateList, total);

		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sms:template:add")
	String add(Model model){
		List<SmsSupplierDO> smsSupplierList = supplierService.list(new HashMap<>());
		model.addAttribute("smsSupplierLists", smsSupplierList);
		List<LabelDO> labelList = labelService.list(new HashMap<>());
		model.addAttribute("labelLists", labelList);
		Map<String, Object> map = new HashMap<>(16);
		//map.put("companyNo",getComPanyNo());
		List<CompanyDO> companyList = companyService.list(map);
		model.addAttribute("companyLists", companyList);
		return "sms/template/add";
	}

	@GetMapping("/edit/{templateId}")
	@RequiresPermissions("sms:template:edit")
	String edit(@PathVariable("templateId") Integer templateId,Model model){
		TemplateDO template = templateService.get(templateId);
		model.addAttribute("template", template);
		List<SmsSupplierDO> smsSupplierList = supplierService.list(new HashMap<>());
		model.addAttribute("smsSupplierLists", smsSupplierList);
		List<LabelDO> labelList = labelService.list(new HashMap<>());
		model.addAttribute("labelLists", labelList);
		Map<String, Object> map = new HashMap<>(16);
		//map.put("companyNo",getComPanyNo());
		List<CompanyDO> companyList = companyService.list(map);
		model.addAttribute("companyLists", companyList);
	    return "sms/template/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sms:template:add")
	public R save( TemplateDO template){
		template.setCompanyNo(getComPanyNo());
		template.setCreateUser(getUsername());
		template.setCreateTime(new Date());
		template.setTemplateNo(String.valueOf(RandomUtils.getRandomNum()));
		if(templateService.save(template)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sms:template:edit")
	public R update( TemplateDO template){
		template.setUpdateUser(getUsername());
		template.setUpdateTime(new Date());
		templateService.update(template);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sms:template:remove")
	public R remove( Integer templateId){
		if(templateService.remove(templateId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sms:template:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] templateIds){
		templateService.batchRemove(templateIds);
		return R.ok();
	}
	
}
