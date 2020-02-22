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

import com.ecotourism.supplier.order.domain.OrderSpotSecondDO;
import com.ecotourism.supplier.order.service.OrderSpotSecondService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 子订单表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
 
@Controller
@RequestMapping("/order/orderSpotSecond")
public class OrderSpotSecondController extends BaseController {
	@Autowired
	private OrderSpotSecondService orderSpotSecondService;
	
	@GetMapping()
	@RequiresPermissions("order:orderSpotSecond:orderSpotSecond")
	String OrderSpotSecond(){
	    return "order/orderSpotSecond/orderSpotSecond";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("order:orderSpotSecond:orderSpotSecond")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<OrderSpotSecondDO> orderSpotSecondList = orderSpotSecondService.list(query);
		int total = orderSpotSecondService.count(query);
		PageUtils pageUtils = new PageUtils(orderSpotSecondList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("order:orderSpotSecond:add")
	String add(){
	    return "order/orderSpotSecond/add";
	}

	@GetMapping("/edit/{orderId}")
	@RequiresPermissions("order:orderSpotSecond:edit")
	String edit(@PathVariable("orderId") Integer orderId,Model model){
		OrderSpotSecondDO orderSpotSecond = orderSpotSecondService.get(orderId);
		model.addAttribute("orderSpotSecond", orderSpotSecond);
	    return "order/orderSpotSecond/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("order:orderSpotSecond:add")
	public R save( OrderSpotSecondDO orderSpotSecond){
		if(orderSpotSecondService.save(orderSpotSecond)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("order:orderSpotSecond:edit")
	public R update( OrderSpotSecondDO orderSpotSecond){
		orderSpotSecondService.update(orderSpotSecond);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("order:orderSpotSecond:remove")
	public R remove( Integer orderId){
		if(orderSpotSecondService.remove(orderId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("order:orderSpotSecond:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] orderIds){
		orderSpotSecondService.batchRemove(orderIds);
		return R.ok();
	}
	
}
