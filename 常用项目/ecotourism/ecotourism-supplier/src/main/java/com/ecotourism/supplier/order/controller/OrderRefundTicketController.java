package com.ecotourism.supplier.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
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

import com.ecotourism.supplier.order.domain.OrderRefundTicketDO;
import com.ecotourism.supplier.order.service.OrderRefundTicketService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 退票管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
 
@Controller
@RequestMapping("/order/orderRefundTicket")
public class OrderRefundTicketController extends BaseController {
	@Autowired
	private OrderRefundTicketService orderRefundTicketService;
	@Autowired
	private DictService dictService;
	@GetMapping()
	@RequiresPermissions("order:orderRefundTicket:orderRefundTicket")
	String OrderRefundTicket(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "refund_type");
		List<DictDO> refundTypeList = dictService.list(map);
		map.put("type", "review_type");
		List<DictDO> reviewTypeList = dictService.list(map);
		model.addAttribute("refundTypeLists", refundTypeList);
		model.addAttribute("reviewTypeLists", reviewTypeList);
		return "order/orderRefundTicket/orderRefundTicket";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("order:orderRefundTicket:orderRefundTicket")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<OrderRefundTicketDO> orderRefundTicketList = orderRefundTicketService.list(query);
		int total = orderRefundTicketService.count(query);
		PageUtils pageUtils = new PageUtils(orderRefundTicketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("order:orderRefundTicket:add")
	String add(){
	    return "order/orderRefundTicket/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("order:orderRefundTicket:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OrderRefundTicketDO orderRefundTicket = orderRefundTicketService.get(id);
		model.addAttribute("orderRefundTicket", orderRefundTicket);
	    return "order/orderRefundTicket/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("order:orderRefundTicket:add")
	public R save( OrderRefundTicketDO orderRefundTicket){
		if(orderRefundTicketService.save(orderRefundTicket)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("order:orderRefundTicket:edit")
	public R update( OrderRefundTicketDO orderRefundTicket){
		orderRefundTicketService.update(orderRefundTicket);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("order:orderRefundTicket:remove")
	public R remove( Integer id){
		if(orderRefundTicketService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("order:orderRefundTicket:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		orderRefundTicketService.batchRemove(ids);
		return R.ok();
	}
	
}
