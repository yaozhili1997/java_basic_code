package com.ecotourism.manage.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.annotation.Log;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.payment.service.WechatMchService;
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
import com.ecotourism.manage.payment.domain.WechatDO;
import com.ecotourism.manage.payment.service.WechatService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 微信公众号或小程序信息管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
 
@Controller
@RequestMapping("/payment/wechat")
public class WechatController extends BaseController{
	@Autowired
	private WechatService wechatService;
	@Autowired
	private WechatMchService wechatMchService;
	@GetMapping()
	@RequiresPermissions("payment:wechat:wechat")
	String Wechat(){
	    return "payment/wechat/wechat";
	}

	@Log("微信公众号:查询")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("payment:wechat:wechat")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<WechatDO> wechatList = wechatService.list(query);
		int total = wechatService.count(query);
		PageUtils pageUtils = new PageUtils(wechatList, total);
		return pageUtils;
	}

	@Log("微信公众号:跳转增加")
	@GetMapping("/add")
	@RequiresPermissions("payment:wechat:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("available","1");
		model.addAttribute("wechatMchs",wechatMchService.list(map));
	    return "payment/wechat/add";
	}
	@Log("微信公众号:跳转修改")
	@GetMapping("/edit/{id}")
	@RequiresPermissions("payment:wechat:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WechatDO wechat = wechatService.get(id);
		model.addAttribute("wechat", wechat);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("available","1");
		model.addAttribute("wechatMchs",wechatMchService.list(map));
	    return "payment/wechat/edit";
	}
	
	/**
	 * 保存
	 */
	@Log("微信公众号:增加")
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("payment:wechat:add")
	public R save( WechatDO wechat){
		wechat.setCompanyNo(getComPanyNo());
		if(wechatService.save(wechat)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@Log("微信公众号:修改")
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("payment:wechat:edit")
	public R update( WechatDO wechat){
		wechatService.update(wechat);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@Log("微信公众号:删除")
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("payment:wechat:remove")
	public R remove( Integer id){
		if(wechatService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@Log("微信公众号:批量删除")
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("payment:wechat:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wechatService.batchRemove(ids);
		return R.ok();
	}
	
}
