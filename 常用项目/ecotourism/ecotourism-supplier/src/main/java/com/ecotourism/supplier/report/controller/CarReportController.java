package com.ecotourism.supplier.report.controller;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.*;
import com.ecotourism.supplier.device.domain.CarEquipmentDO;
import com.ecotourism.supplier.device.service.CarEquipmentService;
import com.ecotourism.supplier.report.domain.LineReportDO;
import com.ecotourism.supplier.report.domain.PushUserReportDO;
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

import java.util.*;

@Controller
@RequestMapping("/report/car")
public class CarReportController extends BaseController{

    @Autowired
    private CarEquipmentService carEquipmentService;
    @Autowired
    ReportService reportService;
    @GetMapping()
    @RequiresPermissions("report:car:car")
    String LineReport(Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("companyNo",getComPanyNo());
        map.put("deviceType","034003");
        List<CarEquipmentDO> carEquipmentList = carEquipmentService.list(map);
        model.addAttribute("carEquipmentLists", carEquipmentList);
        return "report/car/car";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("report:car:car")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
        List<LineReportDO> lineReportList = reportService.getCarReport(query);
        int total = reportService.getCarReportCount(query);
        PageTotal pageTotal = reportService.getCarReportSum(query);
        PageUtils pageUtils = new PageUtils(lineReportList, total);
        pageUtils.setPageTotal(pageTotal);
        return pageUtils;
    }

    /**导出到excel
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/excel")
    @RequiresPermissions("report:car:excel")
    public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
        params.put("companyNo",getComPanyNo());
        ModelAndView mv = new ModelAndView();
        //查询列表数据
        List<LineReportDO> lineReportList = reportService.getCarReport(params);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        List<String> titles = new ArrayList<String>();
        titles.add("序号");	//1
        titles.add("设备名称");	//2
        titles.add("设备编号");	//3
        titles.add("车牌号");	//4
        titles.add("车辆编号");	//5
        titles.add("乘车日期");	//6
        titles.add("乘车人数");	//7
        dataMap.put("titles", titles);
        List<PageData> varList = new ArrayList<PageData>();
        int i = 0;
        for(LineReportDO bean:lineReportList){
            PageData vpd = new PageData();
            i = i+1;
            vpd.put("var1", i);	//1
            vpd.put("var2", bean.getDeviceName());	    //2
            vpd.put("var3", bean.getCheckEquipmentNo());	    //3
            vpd.put("var4", bean.getCarNo());	    //4
            vpd.put("var5", bean.getVehicleNumber());	//5
            vpd.put("var6", DateUtils.format(bean.getCheckTime()));	//6
            vpd.put("var7", bean.getRideNumber());	//7
            varList.add(vpd);
        }
        dataMap.put("varList", varList);
        //ObjectExcelView erv = new ObjectExcelView();
//        mv = new ModelAndView(erv,dataMap);
        return mv;
    }
}
