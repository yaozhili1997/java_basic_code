package com.ecotourism.manage.sms.controller;

import java.util.List;
import java.util.Map;

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

import com.ecotourism.manage.sms.domain.QrcodeFileDO;
import com.ecotourism.manage.sms.service.QrcodeFileService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 短信二维码图片保存路径
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
 
@Controller
@RequestMapping("/sms/qrcodeFile")
public class QrcodeFileController {
	@Autowired
	private QrcodeFileService qrcodeFileService;
	
	@GetMapping()
	@RequiresPermissions("sms:qrcodeFile:qrcodeFile")
	String QrcodeFile(){
	    return "sms/qrcodeFile/qrcodeFile";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sms:qrcodeFile:qrcodeFile")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<QrcodeFileDO> qrcodeFileList = qrcodeFileService.list(query);
		int total = qrcodeFileService.count(query);
		PageUtils pageUtils = new PageUtils(qrcodeFileList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sms:qrcodeFile:add")
	String add(){
	    return "sms/qrcodeFile/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sms:qrcodeFile:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		QrcodeFileDO qrcodeFile = qrcodeFileService.get(id);
		model.addAttribute("qrcodeFile", qrcodeFile);
	    return "sms/qrcodeFile/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sms:qrcodeFile:add")
	public R save( QrcodeFileDO qrcodeFile){
		if(qrcodeFileService.save(qrcodeFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sms:qrcodeFile:edit")
	public R update( QrcodeFileDO qrcodeFile){
		qrcodeFileService.update(qrcodeFile);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sms:qrcodeFile:remove")
	public R remove( Integer id){
		if(qrcodeFileService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sms:qrcodeFile:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		qrcodeFileService.batchRemove(ids);
		return R.ok();
	}
	
}
