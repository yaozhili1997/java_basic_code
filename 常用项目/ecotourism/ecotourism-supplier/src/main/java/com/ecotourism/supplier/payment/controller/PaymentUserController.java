package com.ecotourism.supplier.payment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.cooperation.service.CooperationDistributionService;
import com.ecotourism.supplier.payment.domain.PaymentUserDO;
import com.ecotourism.supplier.payment.service.AlipayService;
import com.ecotourism.supplier.payment.service.PaymentUserService;
import com.ecotourism.supplier.payment.service.WechatService;
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
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 调用支付接口用户信息
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
 
@Controller
@RequestMapping("/payment/user")
public class PaymentUserController extends BaseController{
	@Autowired
	private PaymentUserService userService;
	@Autowired
	private WechatService wechatService;
	@Autowired
	private AlipayService alipayService;
	@Autowired
	private CooperationDistributionService cooperationDistributionService;

	@GetMapping()
	@RequiresPermissions("payment:user:user")
	String User(){
	    return "payment/user/user";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("payment:user:user")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<PaymentUserDO> userList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("payment:user:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("available","1");
		model.addAttribute("wechats",wechatService.list(map));
		model.addAttribute("alipays",alipayService.list(map));
		model.addAttribute("coos",cooperationDistributionService.listEnableCoo());
		return "payment/user/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("payment:user:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PaymentUserDO user = userService.get(id);
		model.addAttribute("user", user);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		model.addAttribute("wechats",wechatService.list(map));
		model.addAttribute("alipays",alipayService.list(map));
		model.addAttribute("coos",cooperationDistributionService.listAll(null));
	    return "payment/user/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("payment:user:add")
	public R save( PaymentUserDO user){
		user.setCompanyNo(getComPanyNo());
		if(userService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("payment:user:edit")
	public R update( PaymentUserDO user){
		userService.update(user);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("payment:user:remove")
	public R remove( Integer id){
		if(userService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("payment:user:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		userService.batchRemove(ids);
		return R.ok();
	}
	
}
