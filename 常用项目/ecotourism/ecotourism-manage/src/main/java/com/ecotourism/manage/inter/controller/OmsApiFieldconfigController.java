package com.ecotourism.manage.inter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.inter.domain.OmsApiDO;
import com.ecotourism.manage.inter.service.OmsApiService;
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

import com.ecotourism.manage.inter.domain.OmsApiFieldconfigDO;
import com.ecotourism.manage.inter.service.OmsApiFieldconfigService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 接口字段配置信息，将数据库字段转换为标准输出
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
 
@Controller
@RequestMapping("/inter/omsApiFieldconfig")
public class OmsApiFieldconfigController extends BaseController{
	@Autowired
	private OmsApiFieldconfigService omsApiFieldconfigService;
	@Autowired
	private OmsApiService omsApiService;
	@Autowired
	private DictService dictService;

	@GetMapping()
	@RequiresPermissions("inter:omsApiFieldconfig:omsApiFieldconfig")
	String OmsApiFieldconfig(){
	    return "inter/omsApiFieldconfig/omsApiFieldconfig";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("inter:omsApiFieldconfig:omsApiFieldconfig")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OmsApiFieldconfigDO> omsApiFieldconfigList = omsApiFieldconfigService.list(query);
		int total = omsApiFieldconfigService.count(query);
		PageUtils pageUtils = new PageUtils(omsApiFieldconfigList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("inter:omsApiFieldconfig:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>(16);
		map.put("companyNo",getComPanyNo());
		List<OmsApiDO> omsApiList = omsApiService.list(map);
		model.addAttribute("omsApiLists", omsApiList);
		return "inter/omsApiFieldconfig/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("inter:omsApiFieldconfig:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OmsApiFieldconfigDO omsApiFieldconfig = omsApiFieldconfigService.get(id);
		Map<String, Object> map = new HashMap<>(16);
		map.put("companyNo",getComPanyNo());
		List<OmsApiDO> omsApiList = omsApiService.list(map);
		model.addAttribute("omsApiLists", omsApiList);
		map.put("type", "version_type");
		List<DictDO> dictDOS = dictService.list(map);
		model.addAttribute("versionTypes", dictDOS);
		model.addAttribute("omsApiFieldconfig", omsApiFieldconfig);
	    return "inter/omsApiFieldconfig/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("inter:omsApiFieldconfig:add")
	public R save( OmsApiFieldconfigDO omsApiFieldconfig){
		if(omsApiFieldconfigService.save(omsApiFieldconfig)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("inter:omsApiFieldconfig:edit")
	public R update( OmsApiFieldconfigDO omsApiFieldconfig){
		omsApiFieldconfigService.update(omsApiFieldconfig);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("inter:omsApiFieldconfig:remove")
	public R remove( Integer id){
		if(omsApiFieldconfigService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("inter:omsApiFieldconfig:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		omsApiFieldconfigService.batchRemove(ids);
		return R.ok();
	}
	
}
