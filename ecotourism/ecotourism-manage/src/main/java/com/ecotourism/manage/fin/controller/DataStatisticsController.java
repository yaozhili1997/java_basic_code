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
import com.ecotourism.manage.fin.domain.DataStatisticsDO;
import com.ecotourism.manage.fin.service.DataStatisticsService;
import com.ecotourism.manage.product.domain.SpotTicketDO;
import com.ecotourism.manage.product.service.SpotTicketService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fin/dataStatistics")
public class DataStatisticsController extends BaseController {

    @Autowired
    private DictService dictService;
    @Autowired
    private DataStatisticsService dataStatisticsService;
    @Autowired
    private SpotTicketService spotTicketService;
    @Autowired
    private TicketTypeService ticketTypeService;
    @Autowired
    private SpotManagementService spotManagementService;
    @Autowired
    private CooperationDistributionService cooperationDistributionService;
    @GetMapping()
    @RequiresPermissions("fin:dataStatistics:dataStatistics")
    String DataStatistics(Model model){
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
        //票种名称
        List<TicketTypeDO> ticketDefineList = ticketTypeService.list(map);
        map.put("type", "ticket_group");
        List<DictDO> ticketGroupList = dictService.list(map);

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
        return "fin/dataStatistics/dataStatistics";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("fin:dataStatistics:dataStatistics")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
        List<DataStatisticsDO> orderSpotList = dataStatisticsService.list(query);
        int total = dataStatisticsService.count(query);
        PageUtils pageUtils = new PageUtils(orderSpotList, total);
        return pageUtils;
    }

    /**导出到excel
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/excel")
    @RequiresPermissions("fin:dataStatistics:excel")
    public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
        params.put("companyNo",getComPanyNo());
        ModelAndView mv = new ModelAndView();
        //查询列表数据
        Map<String, Object> map = new HashMap<>();
        map.put("companyNo",getComPanyNo());
        List<DataStatisticsDO> orderSpotList = dataStatisticsService.list(params);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        List<String> titles = new ArrayList<String>();
        titles.add("序号");	//1
        titles.add("景区名称");	//2
        titles.add("分销商");	//3
        titles.add("分销数量");	//4
        titles.add("分销金额");	//5
        dataMap.put("titles", titles);
        List<PageData> varList = new ArrayList<PageData>();
        int i = 0;
        for(DataStatisticsDO bean:orderSpotList){
            PageData vpd = new PageData();
            i = i+1;
            vpd.put("var1", i);
            vpd.put("var2", bean.getSpotName());
            vpd.put("var3", bean.getName());
            vpd.put("var4", bean.getOrderQuantity());
            vpd.put("var5", bean.getTotalAmount());
            varList.add(vpd);
        }
        dataMap.put("varList", varList);
//        ObjectExcelView erv = new ObjectExcelView();
//        mv = new ModelAndView(erv,dataMap);
        return mv;
    }
}
