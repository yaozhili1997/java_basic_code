package com.ecotourism.supplier.report.controller;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.*;
import com.ecotourism.supplier.line.domain.LineManagementDO;
import com.ecotourism.supplier.line.service.LineManagementService;
import com.ecotourism.supplier.report.domain.DeviceCheckInfoDO;
import com.ecotourism.supplier.report.domain.LineReportDO;
import com.ecotourism.supplier.report.service.ReportService;
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
@RequestMapping("/report/line")
public class LineReportController extends BaseController{
    @Autowired
    private LineManagementService managementService;
    @Autowired
    ReportService reportService;
    @GetMapping()
    @RequiresPermissions("report:line:line")
    String LineReport(Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("companyNo",getComPanyNo());
        List<LineManagementDO> managementList = managementService.list(map);
        model.addAttribute("managementLists", managementList);
        return "report/line/line";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("report:line:line")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
        List<LineReportDO> lineReportList = reportService.getLineReport(query);
        int total = reportService.getLineReportCount(query);
        PageTotal pageTotal = reportService.getLineReportSum(query);
        PageUtils pageUtils = new PageUtils(lineReportList, total);
        pageUtils.setPageTotal(pageTotal);
        return pageUtils;
    }

    /**导出到excel
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/excel")
    @RequiresPermissions("report:line:excel")
    public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
        params.put("companyNo",getComPanyNo());
        ModelAndView mv = new ModelAndView();
        //查询列表数据
        List<LineReportDO> lineReportList = reportService.getLineReport(params);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        List<String> titles = new ArrayList<String>();
        titles.add("序号");	//1
        titles.add("线路名称");	//2
        titles.add("乘车日期");	//3
        titles.add("乘车人数");	//4
        dataMap.put("titles", titles);
        List<PageData> varList = new ArrayList<PageData>();
        int i = 0;
        for(LineReportDO bean:lineReportList){
            PageData vpd = new PageData();
            i = i+1;
            vpd.put("var1", i);	//1
            vpd.put("var2", bean.getLineName());	    //2
            vpd.put("var3", DateUtils.format(bean.getCheckTime()));	    //3
            vpd.put("var4", bean.getRideNumber());	    //4
            varList.add(vpd);
        }
        dataMap.put("varList", varList);
        //ObjectExcelView erv = new ObjectExcelView();
//        mv = new ModelAndView(erv,dataMap);
        return mv;
    }
}
