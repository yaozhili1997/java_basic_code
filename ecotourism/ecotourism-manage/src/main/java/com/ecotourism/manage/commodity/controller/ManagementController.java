package com.ecotourism.manage.commodity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
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

import com.ecotourism.manage.commodity.domain.ManagementDO;
import com.ecotourism.manage.commodity.service.ManagementService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 属性管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-02 11:12:41
 */
 
@Controller
@RequestMapping("/commodity/management")
public class ManagementController extends BaseController{
	@Autowired
	private ManagementService managementService;
	@Autowired
	private DictService dictService;
	@GetMapping()
	@RequiresPermissions("commodity:management:management")
	String Management(){
	    return "commodity/management/management";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("commodity:management:management")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<ManagementDO> managementList = managementService.list(query);
		int total = managementService.count(query);
		PageUtils pageUtils = new PageUtils(managementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("commodity:management:add")
	String add(){
	    return "commodity/management/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("commodity:management:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ManagementDO management = managementService.get(id);
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", "attribute_type");
		map.put("companyNo",getComPanyNo());
		List<DictDO> dictDOS = dictService.list(map);
		model.addAttribute("management", management);
		model.addAttribute("dictDOS", dictDOS);
	    return "commodity/management/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("commodity:management:add")
	public R save( ManagementDO management){
		management.setCompanyNo(getComPanyNo());
		if(managementService.save(management)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("commodity:management:edit")
	public R update( ManagementDO management){
		managementService.update(management);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("commodity:management:remove")
	public R remove( Integer id){
		if(managementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("commodity:management:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		managementService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/list/{type}")
	public List<ManagementDO> listByType(@PathVariable("type") String type) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("attributeType", type);
		map.put("companyNo",getComPanyNo());
		List<ManagementDO> dictList = managementService.list(map);
		return dictList;
	}
	
}
