package com.ecotourism.supplier.report.controller;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.*;
import com.ecotourism.supplier.order.domain.OrderSpotDO;
import com.ecotourism.supplier.report.domain.PushUserReportDO;
import com.ecotourism.supplier.report.service.PushUserReportService;
import com.ecotourism.supplier.users.domain.PushUserDO;
import com.ecotourism.supplier.users.service.PushUserService;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/report/pushUser")
public class PushUserReportController extends BaseController {
    @Autowired
    private PushUserService pushUserService;
    @Autowired
    PushUserReportService pushUserReportService;
    @GetMapping()
    @RequiresPermissions("report:pushUser:pushUser")
    String PushUserReport(Model model){
        Map<String, Object> map = new HashMap<>();
        //map.put("companyNo",getComPanyNo());
        List<PushUserDO> pushUserList = pushUserService.list(map);
        model.addAttribute("pushUserLists", pushUserList);
        return "report/pushUser/pushUser";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("report:pushUser:pushUser")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        params.put("companyNo",getComPanyNo());
        if(params.get("endTime") ==null && params.get("startTime") == null ){
            params.put("nowDate", Tools.date2Str(new Date()));
        }
        Query query = new Query(params);
        List<PushUserReportDO> lineReportList = pushUserReportService.list(query);
        int total = pushUserReportService.count(query);
        PageTotal pageTotal = pushUserReportService.getPushUserReportSum(query);
        PageUtils pageUtils = new PageUtils(lineReportList, total);
        pageUtils.setPageTotal(pageTotal);
        return pageUtils;
    }

    /**导出到excel
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/excel")
    @RequiresPermissions("report:pushUser:excel")
    public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
        params.put("companyNo",getComPanyNo());
        if(params.get("endTime") ==null && params.get("startTime") == null ){
            params.put("nowDate", Tools.date2Str(new Date()));
        }
        ModelAndView mv = new ModelAndView();
        //查询列表数据
        List<PushUserReportDO> lineReportList = pushUserReportService.list(params);
        Map<String,Object> dataMap = new HashMap<String,Object>();
        List<String> titles = new ArrayList<String>();
        titles.add("序号");	//1
        titles.add("地推编号");	//2
        titles.add("地推姓名");	//3
        titles.add("销售人数");	//4
        titles.add("销售金额");	//5
        dataMap.put("titles", titles);
        List<PageData> varList = new ArrayList<PageData>();
        int i = 0;
        for(PushUserReportDO bean:lineReportList){
            PageData vpd = new PageData();
            i = i+1;
            vpd.put("var1", i);	//1
            vpd.put("var2", bean.getUserNo());	    //2
            vpd.put("var3", bean.getUserName());	    //3
            vpd.put("var4", bean.getTotalPerson());	    //4
            vpd.put("var5", bean.getTotalAmount());	//5
            varList.add(vpd);
        }
        dataMap.put("varList", varList);
        //ObjectExcelView erv = new ObjectExcelView();
//        mv = new ModelAndView(erv,dataMap);
        return mv;
    }
}
