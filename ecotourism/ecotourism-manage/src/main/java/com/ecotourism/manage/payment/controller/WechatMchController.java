package com.ecotourism.manage.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.payment.service.WechatProviderService;
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

import com.ecotourism.manage.payment.domain.WechatMchDO;
import com.ecotourism.manage.payment.service.WechatMchService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * 微信商户号管理配置
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
 
@Controller
@RequestMapping("/payment/wechatMch")
public class WechatMchController extends BaseController{
	@Autowired
	private WechatMchService wechatMchService;
	@Autowired
	private WechatProviderService wechatProviderService;
	@GetMapping()
	@RequiresPermissions("payment:wechatMch:wechatMch")
	String WechatMch(){
	    return "payment/wechatMch/wechatMch";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("payment:wechatMch:wechatMch")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<WechatMchDO> wechatMchList = wechatMchService.list(query);
		int total = wechatMchService.count(query);
		PageUtils pageUtils = new PageUtils(wechatMchList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("payment:wechatMch:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("available","1");
		model.addAttribute("wechatProviders",wechatProviderService.list(map));
		return "payment/wechatMch/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("payment:wechatMch:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WechatMchDO wechatMch = wechatMchService.get(id);
		model.addAttribute("wechatMch", wechatMch);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("available","1");
		model.addAttribute("wechatProviders",wechatProviderService.list(map));
	    return "payment/wechatMch/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("payment:wechatMch:add")
	public R save(@RequestParam("file") MultipartFile file,WechatMchDO wechatMch){
		wechatMch.setCompanyNo(getComPanyNo());
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
        wechatMch.setBaseUrl(basePath);
		return wechatMchService.save(wechatMch,file);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("payment:wechatMch:edit")
	public R update(@RequestParam("file") MultipartFile file,WechatMchDO wechatMch){
        String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
        wechatMch.setBaseUrl(basePath);
		return wechatMchService.update(wechatMch,file);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("payment:wechatMch:remove")
	public R remove( Integer id){
		if(wechatMchService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("payment:wechatMch:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wechatMchService.batchRemove(ids);
		return R.ok();
	}
	
}
