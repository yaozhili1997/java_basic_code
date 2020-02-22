package com.ecotourism.manage.fin.controller;

import java.util.*;

import com.ecotourism.manage.base.domain.SpotManagementDO;
import com.ecotourism.manage.base.service.SpotManagementService;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.*;
import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.service.CooperationDistributionService;
import com.ecotourism.manage.fin.domain.FinancialManagementDO;
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

import com.ecotourism.manage.fin.domain.TicketSettlementDO;
import com.ecotourism.manage.fin.service.TicketSettlementService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 财务结算
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-10 20:14:13
 */
 
@Controller
@RequestMapping("/fin/ticketSettlement")
public class TicketSettlementController extends BaseController{
	@Autowired
	private TicketSettlementService ticketSettlementService;
	@Autowired
	private CooperationDistributionService cooperationDistributionService;
	@Autowired
	private SpotManagementService spotManagementService;
	@GetMapping()
	@RequiresPermissions("fin:ticketSettlement:ticketSettlement")
	String TicketSettlement(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<SpotManagementDO> spotManagementList = spotManagementService.list(map);
		List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.list(map);
		model.addAttribute("spotManagementLists", spotManagementList);
		model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
		return "fin/ticketSettlement/ticketSettlement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("fin:ticketSettlement:ticketSettlement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
		params.put("settlementStatus","031001");
        Query query = new Query(params);
		List<TicketSettlementDO> ticketSettlementList = ticketSettlementService.list(query);
		int total = ticketSettlementService.count(query);
		PageUtils pageUtils = new PageUtils(ticketSettlementList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("fin:ticketSettlement:add")
	String add(){
	    return "fin/ticketSettlement/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("fin:ticketSettlement:edit")
	String edit(@PathVariable("id") String id,Model model){
		TicketSettlementDO ticketSettlement = ticketSettlementService.get(id);
		model.addAttribute("ticketSettlement", ticketSettlement);
	    return "fin/ticketSettlement/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("fin:ticketSettlement:add")
	public R save( TicketSettlementDO ticketSettlement){
		if(ticketSettlementService.save(ticketSettlement)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("fin:ticketSettlement:edit")
	public R update( TicketSettlementDO ticketSettlement){
		ticketSettlement.setCompanyNo(getComPanyNo());
		ticketSettlement.setSettlementStatus("031002");
		ticketSettlement.setSettlementReviewPerson(getUsername());
		ticketSettlement.setSettlementReviewTime(new Date());
		ticketSettlement.setOrderStatus("004005");
		ticketSettlementService.update(ticketSettlement);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("fin:ticketSettlement:remove")
	public R remove( Integer id){
		if(ticketSettlementService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("fin:ticketSettlement:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		ticketSettlementService.batchRemove(ids);
		return R.ok();
	}

	/**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	@RequiresPermissions("fin:ticketSettlement:excel")
	public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
		params.put("companyNo",getComPanyNo());
		ModelAndView mv = new ModelAndView();
		//查询列表数据
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<FinancialManagementDO> orderSpotList = ticketSettlementService.listExcel(params);
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("序号");	//1
		titles.add("分销商");	//16
		titles.add("产品名称");	//8
		titles.add("客户名称");	//2
		titles.add("客户电话");	//3
		titles.add("客户身份证");	//4
		titles.add("订单编号");	//5
		titles.add("电子票");	//6
		titles.add("产品编号");	//7
		titles.add("数量");	//9
		titles.add("售价");	//10
		titles.add("总金额");	//11
		titles.add("支付方式");	//12
		titles.add("支付状态");	//13
		titles.add("订单状态");	//14
		titles.add("退款状态");	//15
		titles.add("检票设备编码");	//17
		titles.add("检票时间");	//17
		titles.add("购买时间");	//17
		titles.add("消费时间");	//18
		titles.add("游玩时间");	//19
		titles.add("退票时间");	//19
		dataMap.put("titles", titles);
		List<PageData> varList = new ArrayList<PageData>();
		int i = 0;
		for(FinancialManagementDO bean:orderSpotList){
			PageData vpd = new PageData();
			i = i+1;
			vpd.put("var1", i);
			vpd.put("var2", bean.getOrderDistributor());
			vpd.put("var3", bean.getProductName());
			vpd.put("var4", bean.getCustomerName());
			vpd.put("var5", bean.getCustomerPhone());
			vpd.put("var6", bean.getCustomerUserId());
			vpd.put("var7", bean.getOrderNo());
			vpd.put("var8", bean.getElectronicTicket());
			vpd.put("var9", bean.getProductNo());
			vpd.put("var10", bean.getOrderQuantity());
			vpd.put("var11", bean.getPayPrice());
			vpd.put("var12", bean.getTotalAmount());
			vpd.put("var13", bean.getPayType());
			vpd.put("var14", bean.getPayStatus());
			vpd.put("var15", bean.getOrderStatus());
			vpd.put("var16", bean.getRefundStatus());
			vpd.put("var17", bean.getCheckEquipmentNo());
			vpd.put("var18", DateUtils.formatDateTime(bean.getCheckTime()));
			vpd.put("var19", DateUtils.formatDateTime(bean.getPurchaseTime()));
			vpd.put("var20", DateUtils.formatDateTime(bean.getConsumptionTime()));
			vpd.put("var21", DateUtils.format(bean.getPlayTime()));
			vpd.put("var22", DateUtils.formatDateTime(bean.getRefundTime()));
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		//ObjectExcelView erv = new ObjectExcelView();
//        mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
}
