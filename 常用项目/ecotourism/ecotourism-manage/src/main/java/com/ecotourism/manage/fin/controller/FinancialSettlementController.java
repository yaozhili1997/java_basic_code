package com.ecotourism.manage.fin.controller;

import com.ecotourism.manage.base.domain.SpotManagementDO;
import com.ecotourism.manage.base.domain.TicketTypeDO;
import com.ecotourism.manage.base.service.SpotManagementService;
import com.ecotourism.manage.base.service.TicketTypeService;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.*;
import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.service.CooperationDistributionService;
import com.ecotourism.manage.fin.domain.FinancialSettlementDO;
import com.ecotourism.manage.fin.service.FinancialSettlementService;
import com.ecotourism.manage.product.domain.SpotTicketDO;
import com.ecotourism.manage.product.service.SpotTicketService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fin/settlement")
public class FinancialSettlementController extends BaseController{
    @Autowired
    private FinancialSettlementService financialSettlementService;
    @Autowired
    private DictService dictService;
    @Autowired
    private SpotTicketService spotTicketService;
    @Autowired
    private TicketTypeService ticketTypeService;
    @Autowired
    private SpotManagementService spotManagementService;
    @Autowired
    private CooperationDistributionService cooperationDistributionService;
    @GetMapping()
    @RequiresPermissions("fin:settlement:settlement")
    String FinancialSettlement(Model model){
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
        map.put("type", "ticket_group");
        List<DictDO> ticketGroupList = dictService.list(map);
        List<SpotTicketDO> spotTicketList = spotTicketService.list(map);
        //票种名称
        List<TicketTypeDO> ticketDefineList = ticketTypeService.list(map);
        List<SpotManagementDO> spotManagementList = spotManagementService.list(map);
        List<CooperationDistributionDO> cooperationDistributionList = cooperationDistributionService.list(map);
        model.addAttribute("refundTypeLists", refundTypeList);
        model.addAttribute("payStateTypeLists", payStateTypeList);
        model.addAttribute("orderStateTypeLists", orderStateTypeList);
        model.addAttribute("ticketTypeLists", ticketTypeList);
        model.addAttribute("spotTicketLists", spotTicketList);
        model.addAttribute("ticketDefineLists", ticketDefineList);
        model.addAttribute("ticketGroupLists", ticketGroupList);
        model.addAttribute("spotManagementLists", spotManagementList);
        model.addAttribute("cooperationDistributionLists", cooperationDistributionList);
        return "fin/settlement/settlement";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("fin:settlement:settlement")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
        List<FinancialSettlementDO> orderSpotList = financialSettlementService.list(query);
        int total = financialSettlementService.count(query);
        PageUtils pageUtils = new PageUtils(orderSpotList, total);
        return pageUtils;
    }

    @GetMapping("/edit/{orderId}")
    @RequiresPermissions("fin:settlement:edit")
    String edit(@PathVariable("orderId") Integer orderId, Model model){
        FinancialSettlementDO orderSpot = financialSettlementService.get(orderId);
        model.addAttribute("orderSpot", orderSpot);
        return "fin/settlement/edit";
    }

    /**导出到excel
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/excel")
    @RequiresPermissions("fin:settlement:excel")
    public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
        params.put("companyNo",getComPanyNo());
        ModelAndView mv = new ModelAndView();
        //查询列表数据
        Map<String, Object> map = new HashMap<>();
        map.put("companyNo",getComPanyNo());
        List<FinancialSettlementDO> orderSpotList = financialSettlementService.list(params);
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
//        for(FinancialSettlementDO bean:orderSpotList){
//            PageData vpd = new PageData();
//            i = i+1;
//            vpd.put("var1", i);
//            vpd.put("var2", bean.getOrderDistributor());
//            vpd.put("var3", bean.getProductName());
//            vpd.put("var4", bean.getCustomerName());
//            vpd.put("var5", bean.getCustomerPhone());
//            vpd.put("var6", bean.getCustomerUserId());
//            vpd.put("var7", bean.getOrderNo());
//            vpd.put("var8", bean.getElectronicTicket());
//            vpd.put("var9", bean.getProductNo());
//            vpd.put("var10", bean.getOrderQuantity());
//            vpd.put("var11", bean.getPayPrice());
//            vpd.put("var12", bean.getTotalAmount());
//            vpd.put("var13", bean.getPayType());
//            vpd.put("var14", bean.getPayStatus());
//            vpd.put("var15", bean.getOrderStatus());
//            vpd.put("var16", bean.getRefundStatus());
//            vpd.put("var17", bean.getCheckEquipmentNo());
//            vpd.put("var18", DateUtils.formatDateTime(bean.getCheckTime()));
//            vpd.put("var19", DateUtils.formatDateTime(bean.getPurchaseTime()));
//            vpd.put("var20", DateUtils.formatDateTime(bean.getConsumptionTime()));
//            vpd.put("var21", DateUtils.format(bean.getPlayTime()));
//            vpd.put("var22", DateUtils.formatDateTime(bean.getRefundTime()));
//            varList.add(vpd);
//        }
        dataMap.put("varList", varList);
        //ObjectExcelView erv = new ObjectExcelView();
//        mv = new ModelAndView(erv,dataMap);
        return mv;
    }
}
