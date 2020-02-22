package com.ecotourism.manage.device.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.domain.SpotManagementDO;
import com.ecotourism.manage.base.service.SpotManagementService;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.line.domain.LineManagementDO;
import com.ecotourism.manage.line.service.LineManagementService;
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

import com.ecotourism.manage.device.domain.CarEquipmentDO;
import com.ecotourism.manage.device.service.CarEquipmentService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 设备表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-09 19:17:58
 */
 
@Controller
@RequestMapping("/device/carEquipment")
public class CarEquipmentController extends BaseController{
	@Autowired
	private CarEquipmentService carEquipmentService;
	@Autowired
	private SpotManagementService spotManagementService;
	@Autowired
	private LineManagementService managementService;
	@GetMapping()
	@RequiresPermissions("device:carEquipment:carEquipment")
	String CarEquipment(Model model){
		Map<String, Object> map = new HashMap<>();
		List<SpotManagementDO> spotList = spotManagementService.list(map);
		//查询列表数据
		map.put("companyNo",getComPanyNo());
		List<LineManagementDO> lineList = managementService.list(map);
		model.addAttribute("spotLists", spotList);
		model.addAttribute("lineLists", lineList);
		return "device/carEquipment/carEquipment";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("device:carEquipment:carEquipment")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
		params.put("deviceType","034003");
        Query query = new Query(params);
		List<CarEquipmentDO> carEquipmentList = carEquipmentService.list(query);
		int total = carEquipmentService.count(query);
		PageUtils pageUtils = new PageUtils(carEquipmentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("device:carEquipment:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		List<SpotManagementDO> spotList = spotManagementService.list(map);
		//查询列表数据
		map.put("companyNo",getComPanyNo());
		List<LineManagementDO> lineList = managementService.list(map);
		model.addAttribute("spotLists", spotList);
		model.addAttribute("lineLists", lineList);
		return "device/carEquipment/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("device:carEquipment:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CarEquipmentDO carEquipment = carEquipmentService.get(id);
		Map<String, Object> map = new HashMap<>();
		List<SpotManagementDO> spotList = spotManagementService.list(map);
		//查询列表数据
		map.put("companyNo",getComPanyNo());
		List<LineManagementDO> lineList = managementService.list(map);
		model.addAttribute("spotLists", spotList);
		model.addAttribute("lineLists", lineList);
		model.addAttribute("carEquipment", carEquipment);
	    return "device/carEquipment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("device:carEquipment:add")
	public R save( CarEquipmentDO carEquipment){
		carEquipment.setCompanyNo(getComPanyNo());
		carEquipment.setCreateTime(new Date());
		carEquipment.setCreateUser(getUsername());
		carEquipment.setDeviceType("034003");
		if(carEquipmentService.save(carEquipment)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("device:carEquipment:edit")
	public R update( CarEquipmentDO carEquipment){
		carEquipment.setUpdateTime(new Date());
		carEquipment.setUpdateUser(getUsername());
		carEquipmentService.update(carEquipment);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("device:carEquipment:remove")
	public R remove( Integer id){
		if(carEquipmentService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("device:carEquipment:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		carEquipmentService.batchRemove(ids);
		return R.ok();
	}
	
}
