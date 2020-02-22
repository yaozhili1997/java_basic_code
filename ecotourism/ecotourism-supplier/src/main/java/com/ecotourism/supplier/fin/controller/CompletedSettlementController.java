package com.ecotourism.supplier.fin.controller;

import com.ecotourism.supplier.base.domain.SpotManagementDO;
import com.ecotourism.supplier.base.service.SpotManagementService;
import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.*;
import com.ecotourism.supplier.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.supplier.cooperation.service.CooperationDistributionService;
import com.ecotourism.supplier.fin.domain.CompletedSettlementDO;
import com.ecotourism.supplier.fin.domain.SettlementDetailsDO;
import com.ecotourism.supplier.fin.service.CompletedSettlementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * 财务结算
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-10 20:14:13
 */
 
@Controller
@RequestMapping("/fin/completedSettlement")
public class CompletedSettlementController extends BaseController{
	@Autowired
	private CompletedSettlementService completedSettlementService;
	@Autowired
	private CooperationDistributionService cooperationDistributionService;
	@Autowired
	private SpotManagementService spotManagementService;
	@GetMapping()
	@RequiresPermissions("fin:completedSettlement:completedSettlement")
	String CompletedSettlement(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<SpotManagementDO> spotManagementList = spotManagementService.list(map);
		List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.list(map);
		model.addAttribute("spotManagementLists", spotManagementList);
		model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
		return "fin/completedSettlement/completedSettlement";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("fin:completedSettlement:completedSettlement")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
		params.put("settlementStatus","031002");
        Query query = new Query(params);
		List<CompletedSettlementDO> ticketSettlementList = completedSettlementService.list(query);
		int total = completedSettlementService.count(query);
		PageUtils pageUtils = new PageUtils(ticketSettlementList, total);
		return pageUtils;
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("fin:completedSettlement:edit")
	String edit(@PathVariable("id") String id,Model model){
		CompletedSettlementDO completedSettlement = completedSettlementService.get(id);
		model.addAttribute("completedSettlement", completedSettlement);
	    return "fin/completedSettlement/edit";
	}

	@RequestMapping(value="/printPage")
	@RequiresPermissions("fin:completedSettlement:print")
	String print(@RequestParam Map<String, Object> params,Model model) throws Exception{
		params.put("companyNo",getComPanyNo());
		CompletedSettlementDO completedSettlement = completedSettlementService.getCompletedSettlement(params);
		completedSettlement.setBigPrice(PriceUtil.getRMB(new BigDecimal(completedSettlement.getReviewAmount().toString()).multiply(new BigDecimal(100)).setScale(0).longValue()));
		List<SettlementDetailsDO> orderList = completedSettlementService.getSettlementDetail(params);
		model.addAttribute("completedSettlement", completedSettlement);
		model.addAttribute("orderList", orderList);
		return "fin/completedSettlement/printPage";
	}
}
