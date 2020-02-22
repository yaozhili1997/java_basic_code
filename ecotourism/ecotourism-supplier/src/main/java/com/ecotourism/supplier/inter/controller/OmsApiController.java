package com.ecotourism.supplier.inter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
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

import com.ecotourism.supplier.inter.domain.OmsApiDO;
import com.ecotourism.supplier.inter.service.OmsApiService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * oms接口注册表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
 
@Controller
@RequestMapping("/inter/omsApi")
public class OmsApiController extends BaseController{
	@Autowired
	private OmsApiService omsApiService;
	@Autowired
	private DictService dictService;

	@GetMapping()
	@RequiresPermissions("inter:omsApi:omsApi")
	String OmsApi(){
	    return "inter/omsApi/omsApi";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("inter:omsApi:omsApi")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OmsApiDO> omsApiList = omsApiService.list(query);
		int total = omsApiService.count(query);
		PageUtils pageUtils = new PageUtils(omsApiList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("inter:omsApi:add")
	String add(){
	    return "inter/omsApi/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("inter:omsApi:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OmsApiDO omsApi = omsApiService.get(id);
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", "version_type");
		map.put("companyNo",getComPanyNo());
		List<DictDO> dictDOS = dictService.list(map);
		model.addAttribute("omsApi", omsApi);
		model.addAttribute("versionTypes", dictDOS);
	    return "inter/omsApi/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("inter:omsApi:add")
	public R save( OmsApiDO omsApi){
		if(omsApiService.save(omsApi)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("inter:omsApi:edit")
	public R update( OmsApiDO omsApi){
		omsApiService.update(omsApi);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("inter:omsApi:remove")
	public R remove( Integer id){
		if(omsApiService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("inter:omsApi:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		omsApiService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/listAll")
	public List<OmsApiDO> list(){
		//查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("companyNo",getComPanyNo());
		List<OmsApiDO> omsApiList = omsApiService.list(map);
		return omsApiList;
	}
	
}
