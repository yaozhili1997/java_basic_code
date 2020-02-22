package com.ecotourism.manage.inter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.service.CooperationDistributionService;
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

import com.ecotourism.manage.inter.domain.OmsApiDictionaryDO;
import com.ecotourism.manage.inter.service.OmsApiDictionaryService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
 
@Controller
@RequestMapping("/inter/omsApiDictionary")
public class OmsApiDictionaryController extends BaseController{
	@Autowired
	private OmsApiDictionaryService omsApiDictionaryService;
	@Autowired
	private OmsApiService omsApiService;
	@Autowired
	private CooperationDistributionService cooperationDistributionService;
	@Autowired
	private DictService dictService;
	@GetMapping()
	@RequiresPermissions("inter:omsApiDictionary:omsApiDictionary")
	String OmsApiDictionary(Model model){
		Map<String, Object> map = new HashMap<>();
		List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.listAll(map);
		map.put("type", "version_type");
		map.put("companyNo",getComPanyNo());
		List<DictDO> versionTypeList = dictService.list(map);
		model.addAttribute("versionTypeLists", versionTypeList);
		model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
		return "inter/omsApiDictionary/omsApiDictionary";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("inter:omsApiDictionary:omsApiDictionary")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OmsApiDictionaryDO> omsApiDictionaryList = omsApiDictionaryService.list(query);
		int total = omsApiDictionaryService.count(query);
		PageUtils pageUtils = new PageUtils(omsApiDictionaryList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("inter:omsApiDictionary:add")
	String add(Model model){
		List<OmsApiDO> omsApiList = omsApiService.list(new HashMap<>());
		Map<String, Object> map = new HashMap<>();
		List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.listAll(map);
		model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
		model.addAttribute("omsApiLists", omsApiList);
	    return "inter/omsApiDictionary/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("inter:omsApiDictionary:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		Map<String, Object> map = new HashMap<>(16);
		map.put("distributionNo", id);
		List<OmsApiDictionaryDO> list = omsApiDictionaryService.listByDisNo(map);
		List<OmsApiDO> omsApiList = omsApiDictionaryService.listCheck(list);
		List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.listAll(map);
		model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
		model.addAttribute("omsApiLists", omsApiList);
		model.addAttribute("omsApiDictionary", list.get(0));
	    return "inter/omsApiDictionary/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("inter:omsApiDictionary:add")
	public R save( OmsApiDictionaryDO omsApiDictionary){
		if(omsApiDictionaryService.save(omsApiDictionary)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("inter:omsApiDictionary:edit")
	public R update( OmsApiDictionaryDO omsApiDictionary){
		omsApiDictionaryService.update(omsApiDictionary);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("inter:omsApiDictionary:remove")
	public R remove( Integer id){
		if(omsApiDictionaryService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("inter:omsApiDictionary:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		omsApiDictionaryService.batchRemove(ids);
		return R.ok();
	}
	
}
