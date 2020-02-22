package com.ecotourism.manage.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.*;
import com.ecotourism.manage.line.domain.LineManagementDO;
import com.ecotourism.manage.line.service.LineManagementService;
import com.ecotourism.manage.report.domain.LineReportDO;
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

import com.ecotourism.manage.report.domain.DeviceCheckInfoDO;
import com.ecotourism.manage.report.service.DeviceCheckInfoService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-14 10:02:02
 */
 
@Controller
@RequestMapping("/report/deviceCheckInfo")
public class DeviceCheckInfoController extends BaseController{
	@Autowired
	private DeviceCheckInfoService deviceCheckInfoService;
	@Autowired
	private LineManagementService managementService;
	@GetMapping()
	@RequiresPermissions("report:deviceCheckInfo:deviceCheckInfo")
	String DeviceCheckInfo(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<LineManagementDO> managementList = managementService.list(map);
		model.addAttribute("managementLists", managementList);
		return "report/deviceCheckInfo/deviceCheckInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("report:deviceCheckInfo:deviceCheckInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<DeviceCheckInfoDO> deviceCheckInfoList = deviceCheckInfoService.list(query);
		int total = deviceCheckInfoService.count(query);
		PageUtils pageUtils = new PageUtils(deviceCheckInfoList, total);
		return pageUtils;
	}

	/**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	@RequiresPermissions("report:deviceCheckInfo:excel")
	public ModelAndView exportExcel(@RequestParam Map<String, Object> params) throws Exception{
		params.put("companyNo",getComPanyNo());
		ModelAndView mv = new ModelAndView();
		//查询列表数据
		List<DeviceCheckInfoDO> deviceCheckInfoList = deviceCheckInfoService.list(params);
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("序号");	//1
		titles.add("产品名称");	//2
		titles.add("车牌号");	//3
		titles.add("设备编号");	//4
		titles.add("车辆编号");	//5
		titles.add("电子票号");	//6
		titles.add("检票时间");	//7
		titles.add("所属线路");	//8
		titles.add("乘车人数");	//9
		dataMap.put("titles", titles);
		List<PageData> varList = new ArrayList<PageData>();
		int i = 0;
		for(DeviceCheckInfoDO bean:deviceCheckInfoList){
			PageData vpd = new PageData();
			i = i+1;
			vpd.put("var1", i);	//1
			vpd.put("var2", bean.getProductName());	    //2
			vpd.put("var3", bean.getCarNo());	    //3
			vpd.put("var4", bean.getCheckEquipmentNo());	    //4
			vpd.put("var5", bean.getVehicleNumber());	//5
			vpd.put("var6", bean.getElectronicTicket());	//6
			vpd.put("var7", DateUtils.formatDateTime(bean.getCheckTime()));	//7
			vpd.put("var8", bean.getLineName());	//8
			vpd.put("var9", bean.getRideNumber());	//9
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		//ObjectExcelView erv = new ObjectExcelView();
//        mv = new ModelAndView(erv,dataMap);
		return mv;
	}
}
