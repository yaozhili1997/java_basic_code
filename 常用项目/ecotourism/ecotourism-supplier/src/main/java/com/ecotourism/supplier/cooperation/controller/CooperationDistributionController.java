package com.ecotourism.supplier.cooperation.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecotourism.supplier.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.supplier.cooperation.service.CooperationDistributionService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:09:13
 * 分销商管理
 */
 
@Controller
@RequestMapping("/cooperation/distribution")
public class CooperationDistributionController extends BaseController{
	@Autowired
	private CooperationDistributionService cooperationDistributionService;
	@Autowired
	private DictService dictService;

	@GetMapping()
	@RequiresPermissions("cooperation:distribution:distribution")
	String CooperationDistribution(Model model){
		Map<String, Object> map=new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		// 合作商类型
		map.put("type", "distribution_type");
		List<DictDO> distributionTypeList = dictService.list(map);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("distributionTypeList", distributionTypeList);
	    return "cooperation/distribution/distribution";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("cooperation:distribution:distribution")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.list(query);
		int total = cooperationDistributionService.count(query);
		PageUtils pageUtils = new PageUtils(cooperationDistributionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("cooperation:distribution:add")
	String add(Model model){
		Map<String, Object> map=new HashMap<>();
		map.put("companyNo",getComPanyNo());
		// 分销渠道
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		// 支付方式
		//map.put("type", "pay_type");
		//List<DictDO> payTypeList = dictService.list(map);
		// 合作商类型
		map.put("type", "distribution_type");
		List<DictDO> distributionTypeList = dictService.list(map);

		model.addAttribute("distributionChannelLists", distributionChannelList);
		//model.addAttribute("payTypeLists", payTypeList);
		model.addAttribute("distributionTypeList", distributionTypeList);
	    return "cooperation/distribution/add";

	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("cooperation:distribution:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CooperationDistributionDO cooperationDistribution = cooperationDistributionService.get(id);
		Map<String, Object> map=new HashMap<>();
		map.put("companyNo",getComPanyNo());
		// 分销渠道
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		// 支付方式
		//map.put("type", "pay_type");
		//List<DictDO> payTypeList = dictService.list(map);
		// 合作商类型
		map.put("type", "distribution_type");
		List<DictDO> distributionTypeList = dictService.list(map);

		//payTypeList = cooperationDistributionService.list(payTypeList,cooperationDistribution);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		//model.addAttribute("payTypeLists", payTypeList);
		model.addAttribute("distributionTypeList", distributionTypeList);
		model.addAttribute("distribution", cooperationDistribution);
	    return "cooperation/distribution/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("cooperation:distribution:add")
	public R save( CooperationDistributionDO cooperationDistribution){
		cooperationDistribution.setCreateUser(getUsername());
		cooperationDistribution.setCompanyNo(getComPanyNo());
		return cooperationDistributionService.save(cooperationDistribution);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("cooperation:distribution:edit")
	public R update( CooperationDistributionDO cooperationDistribution){
		cooperationDistribution.setUpdateUser(getUsername());
		cooperationDistributionService.update(cooperationDistribution);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("cooperation:distribution:remove")
	public R remove( Integer id){
		if(cooperationDistributionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("cooperation:distribution:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		cooperationDistributionService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@GetMapping("/listAll")
	public List<CooperationDistributionDO> listAll() {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("companyNo",getComPanyNo());
		List<CooperationDistributionDO> dictList = cooperationDistributionService.list(map);
		return dictList;
	}
	
}
