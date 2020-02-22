package com.ecotourism.manage.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
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

import com.ecotourism.manage.order.domain.OrderLogDO;
import com.ecotourism.manage.order.service.OrderLogService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 订单日志
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
 
@Controller
@RequestMapping("/order/orderLog")
public class OrderLogController extends BaseController {
	@Autowired
	private OrderLogService orderLogService;
	@Autowired
	private DictService dictService;
	@GetMapping()
	@RequiresPermissions("order:orderLog:orderLog")
	String OrderLog(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "log_type");
		List<DictDO> loyTypeList = dictService.list(map);
		model.addAttribute("loyTypeLists", loyTypeList);
		return "order/orderLog/orderLog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("order:orderLog:orderLog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<OrderLogDO> orderLogList = orderLogService.list(query);
		int total = orderLogService.count(query);
		PageUtils pageUtils = new PageUtils(orderLogList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("order:orderLog:add")
	String add(){
	    return "order/orderLog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("order:orderLog:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OrderLogDO orderLog = orderLogService.get(id);
		model.addAttribute("orderLog", orderLog);
	    return "order/orderLog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("order:orderLog:add")
	public R save( OrderLogDO orderLog){
		if(orderLogService.save(orderLog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("order:orderLog:edit")
	public R update( OrderLogDO orderLog){
		orderLogService.update(orderLog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("order:orderLog:remove")
	public R remove( Integer id){
		if(orderLogService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("order:orderLog:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		orderLogService.batchRemove(ids);
		return R.ok();
	}
	
}
