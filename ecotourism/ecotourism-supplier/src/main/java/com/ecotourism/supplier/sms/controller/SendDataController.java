package com.ecotourism.supplier.sms.controller;

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

import com.ecotourism.supplier.sms.domain.SendDataDO;
import com.ecotourism.supplier.sms.service.SendDataService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 短信发送数据
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
 
@Controller
@RequestMapping("/sms/sendData")
public class SendDataController extends BaseController{
	@Autowired
	private SendDataService sendDataService;
	
	@GetMapping()
	@RequiresPermissions("sms:sendData:sendData")
	String SendData(){
	    return "sms/sendData/sendData";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sms:sendData:sendData")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		//params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<SendDataDO> sendDataList = sendDataService.list(query);
		int total = sendDataService.count(query);
		PageUtils pageUtils = new PageUtils(sendDataList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sms:sendData:add")
	String add(){
	    return "sms/sendData/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sms:sendData:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SendDataDO sendData = sendDataService.get(id);
		model.addAttribute("sendData", sendData);
	    return "sms/sendData/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sms:sendData:add")
	public R save( SendDataDO sendData){
		if(sendDataService.save(sendData)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sms:sendData:edit")
	public R update( SendDataDO sendData){
		sendDataService.update(sendData);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sms:sendData:remove")
	public R remove( Integer id){
		if(sendDataService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sms:sendData:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		sendDataService.batchRemove(ids);
		return R.ok();
	}
	
}
