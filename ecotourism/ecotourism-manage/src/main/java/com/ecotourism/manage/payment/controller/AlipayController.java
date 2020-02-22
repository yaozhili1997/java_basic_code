package com.ecotourism.manage.payment.controller;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
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

import com.ecotourism.manage.payment.domain.AlipayDO;
import com.ecotourism.manage.payment.service.AlipayService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 
 * 支付宝支付参数管理
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
 
@Controller
@RequestMapping("/payment/alipay")
public class AlipayController extends BaseController {
	@Autowired
	private AlipayService alipayService;

	@GetMapping()
	@RequiresPermissions("payment:alipay:alipay")
	String Alipay(){
	    return "payment/alipay/alipay";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("payment:alipay:alipay")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<AlipayDO> alipayList = alipayService.list(query);
		int total = alipayService.count(query);
		PageUtils pageUtils = new PageUtils(alipayList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("payment:alipay:add")
	String add(){
	    return "payment/alipay/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("payment:alipay:edit")
	String edit(@PathVariable("id") Long id,Model model){
		AlipayDO alipay = alipayService.get(id);
		model.addAttribute("alipay", alipay);
	    return "payment/alipay/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("payment:alipay:add")
	public R save( AlipayDO alipay){
		alipay.setCompanyNo(getComPanyNo());
		if(alipayService.save(alipay)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("payment:alipay:edit")
	public R update( AlipayDO alipay){
		alipayService.update(alipay);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("payment:alipay:remove")
	public R remove( Long id){
		if(alipayService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("payment:alipay:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		alipayService.batchRemove(ids);
		return R.ok();
	}
	
}
