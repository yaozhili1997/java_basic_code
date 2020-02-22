package com.ecotourism.supplier.order.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecotourism.supplier.order.domain.OrderSupplierLogDO;
import com.ecotourism.supplier.order.service.OrderSupplierLogService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-11-22 10:19:11
 */
 
@Controller
@RequestMapping("/order/orderSupplierLog")
public class OrderSupplierLogController {
	@Autowired
	private OrderSupplierLogService orderSupplierLogService;
	
	@GetMapping()
	@RequiresPermissions("order:orderSupplierLog:orderSupplierLog")
	String OrderSupplierLog(){
	    return "order/orderSupplierLog/orderSupplierLog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("order:orderSupplierLog:orderSupplierLog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<OrderSupplierLogDO> orderSupplierLogList = orderSupplierLogService.list(query);
		int total = orderSupplierLogService.count(query);
		PageUtils pageUtils = new PageUtils(orderSupplierLogList, total);
		return pageUtils;
	}
}
