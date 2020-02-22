package com.ecotourism.manage.ums.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.PageTotal;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.payment.domain.PaymentUserDO;
import com.ecotourism.manage.payment.service.PaymentUserService;
import com.ecotourism.manage.product.domain.SpotTicketDO;
import com.ecotourism.manage.product.service.SpotTicketService;
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
import com.ecotourism.manage.ums.domain.OrderDO;
import com.ecotourism.manage.ums.service.OrderService;

/**
 * 应用订单
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-10-19 09:30:15
 */
 
@Controller
@RequestMapping("/ums/order")
public class OrderController extends BaseController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private DictService dictService;
	@Autowired
	private PaymentUserService userService;
	@Autowired
	private SpotTicketService spotTicketService;
	@GetMapping()
	@RequiresPermissions("ums:order:order")
	String Order(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "refund_type");
		List<DictDO> refundTypeList = dictService.list(map);
		map.put("type", "pay_state_type");
		List<DictDO> payStateTypeList = dictService.list(map);
		map.put("type", "order_status");
		List<DictDO> orderStateTypeList = dictService.list(map);
		map.remove("type");
		List<PaymentUserDO> userList = userService.list(map);
		List<SpotTicketDO> spotTicketList = spotTicketService.list(map);
		model.addAttribute("appList", userList);
		model.addAttribute("spotTicketLists", spotTicketList);
		model.addAttribute("refundTypeLists", refundTypeList);
		model.addAttribute("payStateTypeLists", payStateTypeList);
		model.addAttribute("orderStateTypeLists", orderStateTypeList);
		return "ums/order/order";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ums:order:order")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderDO> orderList = orderService.list(query);
		int total = orderService.count(query);
		PageTotal pageTotal = orderService.selectTotalCount(query);
		PageUtils pageUtils = new PageUtils(orderList, total);
		pageUtils.setPageTotal(pageTotal);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ums:order:add")
	String add(){
	    return "ums/order/add";
	}

	@GetMapping("/edit/{orderId}")
	@RequiresPermissions("ums:order:edit")
	String edit(@PathVariable("orderId") Integer orderId,Model model){
		OrderDO order = orderService.get(orderId);
		model.addAttribute("order", order);
	    return "ums/order/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ums:order:add")
	public R save(OrderDO order){
		if(orderService.save(order)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ums:order:edit")
	public R update( OrderDO order){
		orderService.update(order);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ums:order:remove")
	public R remove( Integer orderId){
		if(orderService.remove(orderId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ums:order:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] orderIds){
		orderService.batchRemove(orderIds);
		return R.ok();
	}
	
}
