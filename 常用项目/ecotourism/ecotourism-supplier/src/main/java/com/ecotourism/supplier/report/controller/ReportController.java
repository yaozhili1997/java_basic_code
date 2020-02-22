package com.ecotourism.supplier.report.controller;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {

    @Autowired
    ReportService reportService;

    /**
     *实时统计售票数据
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/todayTotal",produces="application/json; charset=utf-8")
    @ResponseBody
    public String saleTodayTotal(){
        JSONObject returnObject = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> map = new HashMap<>();
        map.put("companyNo",getComPanyNo());
        String ticketNum = reportService.getTodaySaleTotal(map);
        String lineNum = reportService.getTodayLineTotal(map);
        String carNum = reportService.getTodayDeviceTotal(map);
        jsonObject.put("ticketNumList",ticketNum);
        jsonObject.put("todayLineList",lineNum);
        jsonObject.put("todayDeviceList",carNum);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = formatter.format(new Date());
        jsonObject.put("nowDate",nowDate);
        returnObject.put("result",jsonObject.toJSONString());
        System.out.println("ticketNumList================="+returnObject.toJSONString());
        return returnObject.toJSONString();
    }
}
