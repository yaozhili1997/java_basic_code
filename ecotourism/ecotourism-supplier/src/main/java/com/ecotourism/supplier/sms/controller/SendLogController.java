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

import com.ecotourism.supplier.sms.domain.SendLogDO;
import com.ecotourism.supplier.sms.service.SendLogService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 短信发送日志
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
 
@Controller
@RequestMapping("/sms/sendLog")
public class SendLogController extends BaseController{
	@Autowired
	private SendLogService sendLogService;
	
	@GetMapping()
	@RequiresPermissions("sms:sendLog:sendLog")
	String SendLog(){
	    return "sms/sendLog/sendLog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sms:sendLog:sendLog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		//params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<SendLogDO> sendLogList = sendLogService.list(query);
		int total = sendLogService.count(query);
		PageUtils pageUtils = new PageUtils(sendLogList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sms:sendLog:add")
	String add(){
	    return "sms/sendLog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sms:sendLog:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SendLogDO sendLog = sendLogService.get(id);
		model.addAttribute("sendLog", sendLog);
	    return "sms/sendLog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sms:sendLog:add")
	public R save( SendLogDO sendLog){
		if(sendLogService.save(sendLog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sms:sendLog:edit")
	public R update( SendLogDO sendLog){
		sendLogService.update(sendLog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sms:sendLog:remove")
	public R remove( Integer id){
		if(sendLogService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sms:sendLog:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		sendLogService.batchRemove(ids);
		return R.ok();
	}
	
}
