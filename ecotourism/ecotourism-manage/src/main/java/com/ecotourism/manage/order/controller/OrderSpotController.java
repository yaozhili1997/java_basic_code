package com.ecotourism.manage.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.*;
import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.service.CooperationDistributionService;
import com.ecotourism.manage.order.domain.OrderAddressDO;
import com.ecotourism.manage.product.domain.SpotTicketDO;
import com.ecotourism.manage.product.service.SpotTicketService;
import org.apache.commons.lang.StringUtils;
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

import com.ecotourism.manage.order.domain.OrderSpotDO;
import com.ecotourism.manage.order.service.OrderSpotService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 门票订单
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
 
@Controller
@RequestMapping("/order/orderSpot")
public class OrderSpotController extends BaseController {
	@Autowired
	private OrderSpotService orderSpotService;
	@Autowired
	private DictService dictService;
	@Autowired
	private CooperationDistributionService cooperationDistributionService;
	@Autowired
	private SpotTicketService spotTicketService;
	@GetMapping()
	@RequiresPermissions("order:orderSpot:orderSpot")
	String OrderSpot(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "refund_type");
		List<DictDO> refundTypeList = dictService.list(map);
		map.put("type", "pay_state_type");
		List<DictDO> payStateTypeList = dictService.list(map);
		map.put("type", "order_state_type");
		List<DictDO> orderStateTypeList = dictService.list(map);
		map.put("type", "ticket_type");
		List<DictDO> ticketTypeList = dictService.list(map);
		List<SpotTicketDO> spotTicketList = spotTicketService.list(map);
		List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.list(map);
		model.addAttribute("refundTypeLists", refundTypeList);
		model.addAttribute("payStateTypeLists", payStateTypeList);
		model.addAttribute("orderStateTypeLists", orderStateTypeList);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
		model.addAttribute("spotTicketLists", spotTicketList);
		return "order/orderSpot/orderSpot";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("order:orderSpot:orderSpot")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
		String productNo = params.get("productNo").toString();
		if(StringUtils.isNotBlank(productNo) && !("null".equals(productNo))){
			String [] arr = productNo.split(",");
			for(int i=0;i<arr.length;i++){
			}
			params.put("productNoList",arr);
		}
        Query query = new Query(params);
		List<OrderSpotDO> orderSpotList = orderSpotService.list(query);
		int total = orderSpotService.count(query);
		PageUtils pageUtils = new PageUtils(orderSpotList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("order:orderSpot:add")
	String add(){
	    return "order/orderSpot/add";
	}

	@GetMapping("/edit/{orderId}")
	@RequiresPermissions("order:orderSpot:edit")
	String edit(@PathVariable("orderId") Integer orderId,Model model){
		OrderSpotDO orderSpot = orderSpotService.get(orderId);
		model.addAttribute("orderSpot", orderSpot);
	    return "order/orderSpot/edit";
	}

	@GetMapping("/sendGoods/{orderId}")
	@RequiresPermissions("order:orderSpot:edit")
	String sendGoods(@PathVariable("orderId") Integer orderId,Model model){
		OrderAddressDO orderAddress = orderSpotService.getAddress(orderId);
		model.addAttribute("orderAddress", orderAddress);
		return "order/orderSpot/editAddress";
	}


	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("order:orderSpot:add")
	public R save( OrderSpotDO orderSpot){
		if(orderSpotService.save(orderSpot)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("order:orderSpot:edit")
	public R update( OrderAddressDO orderAddress){
		orderSpotService.updateAddress(orderAddress);
		return R.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/updateOrderStatus")
	@RequiresPermissions("order:orderSpot:editStatus")
	public R updateOrderStatus( Integer orderId){
		orderSpotService.updateOrderStatus(orderId,getUsername());
		return R.ok();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/updateRefundStatus")
	@RequiresPermissions("order:orderSpot:refundStatus")
	public R updateRefundStatus( Integer orderId){
		orderSpotService.updateRefundStatus(orderId,getUsername());
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("order:orderSpot:remove")
	public R remove( Integer orderId){
		if(orderSpotService.remove(orderId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("order:orderSpot:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] orderIds){
		orderSpotService.batchRemove(orderIds);
		return R.ok();
	}

	/**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	@RequiresPermissions("order:orderSpot:excel")
	public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
		params.put("companyNo",getComPanyNo());
		String productNo = params.get("productNo").toString();
		if(StringUtils.isNotBlank(productNo) && !("null".equals(productNo))){
			String [] arr = productNo.split(",");
			for(int i=0;i<arr.length;i++){
			}
			params.put("productNoList",arr);
		}
		ModelAndView mv = new ModelAndView();
		//查询列表数据
		List<OrderSpotDO> orderSpotList = orderSpotService.list(params);
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("序号");	//1
		titles.add("客户名称");	//2
		titles.add("客户电话");	//3
		titles.add("客户身份证");	//4
		titles.add("订单编号");	//5
		titles.add("电子票");	//6
		titles.add("产品编号");	//7
		titles.add("产品名称");	//8
		titles.add("数量");	//9
		titles.add("售价");	//10
		titles.add("总金额");	//11
		titles.add("支付方式");	//12
		titles.add("支付状态");	//13
		titles.add("订单状态");	//14
		titles.add("退款状态");	//15
		titles.add("分销商");	//16
		titles.add("购买时间");	//17
		titles.add("消费时间");	//18
		titles.add("游玩时间");	//19
		dataMap.put("titles", titles);
		List<PageData> varList = new ArrayList<PageData>();
		int i = 0;
		for(OrderSpotDO bean:orderSpotList){
			PageData vpd = new PageData();
			i = i+1;
			vpd.put("var1", i);	//1
			vpd.put("var2", bean.getCustomerName());	    //2
			vpd.put("var3", bean.getCustomerPhone());	    //3
			vpd.put("var4", bean.getCustomerUserId());	    //4
			vpd.put("var5", bean.getOrderNo());	//5
			vpd.put("var6", bean.getElectronicTicket());	    //6
			vpd.put("var7", bean.getProductNo());	    //7
			vpd.put("var8", bean.getProductName());	    //8
			vpd.put("var9", bean.getOrderQuantity());	//9
			vpd.put("var10",bean.getPayPrice());	    //10
			vpd.put("var11",bean.getTotalAmount());	    //11
			vpd.put("var12",bean.getPayType());	    //12
			vpd.put("var13",bean.getPayStatus());	    //13
			vpd.put("var14",bean.getOrderStatus());	    //14
			vpd.put("var15",bean.getRefundStatus());	    //15
			vpd.put("var16",bean.getOrderDistributor());	    //16
			vpd.put("var17",DateUtils.formatDateTime(bean.getPurchaseTime()));	    //17
			vpd.put("var18",DateUtils.formatDateTime(bean.getConsumptionTime()));	    //18
			vpd.put("var19",DateUtils.format(bean.getPlayTime()));	    //19
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
//		ObjectExcelView erv = new ObjectExcelView();
//		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
}
