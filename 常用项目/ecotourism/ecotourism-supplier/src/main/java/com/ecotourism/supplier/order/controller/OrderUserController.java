package com.ecotourism.supplier.order.controller;

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

import com.ecotourism.supplier.order.domain.OrderUserDO;
import com.ecotourism.supplier.order.service.OrderUserService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 订单用户
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
 
@Controller
@RequestMapping("/order/orderUser")
public class OrderUserController extends BaseController {
	@Autowired
	private OrderUserService orderUserService;
	
	@GetMapping()
	@RequiresPermissions("order:orderUser:orderUser")
	String OrderUser(){
	    return "order/orderUser/orderUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("order:orderUser:orderUser")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderUserDO> orderUserList = orderUserService.list(query);
		int total = orderUserService.count(query);
		PageUtils pageUtils = new PageUtils(orderUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("order:orderUser:add")
	String add(){
	    return "order/orderUser/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("order:orderUser:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OrderUserDO orderUser = orderUserService.get(id);
		model.addAttribute("orderUser", orderUser);
	    return "order/orderUser/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("order:orderUser:add")
	public R save( OrderUserDO orderUser){
		if(orderUserService.save(orderUser)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("order:orderUser:edit")
	public R update( OrderUserDO orderUser){
		orderUserService.update(orderUser);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("order:orderUser:remove")
	public R remove( Integer id){
		if(orderUserService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("order:orderUser:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		orderUserService.batchRemove(ids);
		return R.ok();
	}
	
}
