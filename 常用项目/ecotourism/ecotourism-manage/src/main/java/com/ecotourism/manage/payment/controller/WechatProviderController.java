package com.ecotourism.manage.payment.controller;

import java.util.List;
import java.util.Map;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.*;
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

import com.ecotourism.manage.payment.domain.WechatProviderDO;
import com.ecotourism.manage.payment.service.WechatProviderService;
import org.springframework.web.multipart.MultipartFile;
/**
 * 微信服务商管理配置
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
 
@Controller
@RequestMapping("/payment/wechatProvider")
public class WechatProviderController extends BaseController{
	@Autowired
	private WechatProviderService wechatProviderService;
	@GetMapping()
	@RequiresPermissions("payment:wechatProvider:wechatProvider")
	String WechatProvider(){
	    return "payment/wechatProvider/wechatProvider";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("payment:wechatProvider:wechatProvider")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<WechatProviderDO> wechatProviderList = wechatProviderService.list(query);
		int total = wechatProviderService.count(query);
		PageUtils pageUtils = new PageUtils(wechatProviderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("payment:wechatProvider:add")
	String add(){
	    return "payment/wechatProvider/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("payment:wechatProvider:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WechatProviderDO wechatProvider = wechatProviderService.get(id);
		model.addAttribute("wechatProvider", wechatProvider);
	    return "payment/wechatProvider/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("payment:wechatProvider:add")
	public R save(@RequestParam("file") MultipartFile file,WechatProviderDO wechatProvider){
		wechatProvider.setCompanyNo(getComPanyNo());
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		wechatProvider.setBaseUrl(basePath);
		return wechatProviderService.save(wechatProvider,file);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("payment:wechatProvider:edit")
	public R update(@RequestParam("file") MultipartFile file,WechatProviderDO wechatProvider){
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		wechatProvider.setBaseUrl(basePath);
		return wechatProviderService.update(wechatProvider, file);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("payment:wechatProvider:remove")
	public R remove( Integer id){
		if(wechatProviderService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("payment:wechatProvider:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wechatProviderService.batchRemove(ids);
		return R.ok();
	}
}
