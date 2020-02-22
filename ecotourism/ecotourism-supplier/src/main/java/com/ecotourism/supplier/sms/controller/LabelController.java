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

import com.ecotourism.supplier.sms.domain.LabelDO;
import com.ecotourism.supplier.sms.service.LabelService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 短信替换标签
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
 
@Controller
@RequestMapping("/sms/label")
public class LabelController extends BaseController{
	@Autowired
	private LabelService labelService;
	
	@GetMapping()
	@RequiresPermissions("sms:label:label")
	String Label(){
	    return "sms/label/label";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sms:label:label")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<LabelDO> labelList = labelService.list(query);
		int total = labelService.count(query);
		PageUtils pageUtils = new PageUtils(labelList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sms:label:add")
	String add(){
	    return "sms/label/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sms:label:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LabelDO label = labelService.get(id);
		model.addAttribute("label", label);
	    return "sms/label/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sms:label:add")
	public R save( LabelDO label){
		label.setCompanyNo(getComPanyNo());
		label.setCreateUser(getUsername());
		label.setCreateTime(new Date());
		if(labelService.save(label)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sms:label:edit")
	public R update( LabelDO label){
		label.setUpdateTime(new Date());
		label.setUpdateUser(getUsername());
		labelService.update(label);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sms:label:remove")
	public R remove( Integer id){
		if(labelService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sms:label:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		labelService.batchRemove(ids);
		return R.ok();
	}
	
}
