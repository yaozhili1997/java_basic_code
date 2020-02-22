package com.ecotourism.supplier.product.controller;

import com.ecotourism.supplier.base.domain.SupplierDO;
import com.ecotourism.supplier.base.domain.TermManagementDO;
import com.ecotourism.supplier.base.domain.TicketTypeDO;
import com.ecotourism.supplier.base.service.SupplierService;
import com.ecotourism.supplier.base.service.TermManagementService;
import com.ecotourism.supplier.base.service.TicketTypeService;
import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.common.utils.RandomUtils;
import com.ecotourism.supplier.product.config.Constant;
import com.ecotourism.supplier.product.domain.ProductTypeDO;
import com.ecotourism.supplier.product.domain.TeamTicketDO;
import com.ecotourism.supplier.product.service.ProductSecondTypeService;
import com.ecotourism.supplier.product.service.TeamTicketService;
import com.ecotourism.supplier.sms.domain.TemplateDO;
import com.ecotourism.supplier.sms.service.TemplateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文创产品
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
 
@Controller
@RequestMapping("/product/teamTicket")
public class TeamTicketController extends BaseController{
	@Autowired
	private TeamTicketService teamTicketService;
	@Autowired
	private TicketTypeService ticketTypeService;
	@Autowired
	private DictService dictService;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private TermManagementService termManagementService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private ProductSecondTypeService productSecondTypeService;
	@GetMapping()
	@RequiresPermissions("product:teamTicket:teamTicket")
	String TeamTicket(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		map.put("type", "ticket_group");
		List<DictDO> ticketGroupList = dictService.list(map);
		/*map.put("type", "product_type");
		List<DictDO> productTypeList = dictService.list(map);*/
		//票种名称
		map.put("productType", Constant.TEAM_TICKET);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(map);
		map.put("parentTypeNo", Constant.TEAM_TICKET);
		List<ProductTypeDO> productTypeList = productSecondTypeService.list(map);
		map.put("type", "whether_shelves");
		List<DictDO> whetherShelvesList = dictService.list(map);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("ticketGroupLists", ticketGroupList);
		model.addAttribute("productTypeLists", productTypeList);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("whetherShelvesLists", whetherShelvesList);
		return "product/teamTicket/teamTicket";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:teamTicket:teamTicket")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("productType",Constant.TEAM_TICKET);
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<TeamTicketDO> spotTicketList = teamTicketService.list(query);
		int total = teamTicketService.count(query);
		PageUtils pageUtils = new PageUtils(spotTicketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:teamTicket:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.TEAM_TICKET);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(map);
		//分销渠道
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		//票种分组
		map.put("type", "ticket_group");
		List<DictDO> ticketGroupList = dictService.list(map);
		/*//产品类型
		map.put("type", "product_type");
		List<DictDO> productTypeList = dictService.list(map);*/
		//支付方式
		map.put("type", "pay_type");
		List<DictDO> payTypeList = dictService.list(map);
		//短信模板
		List<TemplateDO> templateList = templateService.list(map);
		List<TemplateDO> smsTemplateList = new ArrayList<>();
		List<TemplateDO> mmsTemplateList = new ArrayList<>();
		for(TemplateDO bean:templateList){
			if(Constant.SMS.equals(bean.getSendWay())){
				smsTemplateList.add(bean);
			}else if(Constant.MMS.equals(bean.getSendWay())){
				mmsTemplateList.add(bean);
			}
		}
		//入园方式
		map.put("type", "enter_garden_way");
		List<DictDO> parkWayList = dictService.list(map);
		//使用期限
		List<TermManagementDO> termManagementList = termManagementService.list(map);
		//供应商管理
		List<SupplierDO> supplierList = supplierService.list(map);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("ticketGroupLists", ticketGroupList);
		//model.addAttribute("productTypeLists", productTypeList);
		model.addAttribute("payTypeLists", payTypeList);
		model.addAttribute("smsTemplateLists", smsTemplateList);
		model.addAttribute("mmsTemplateLists", mmsTemplateList);
		model.addAttribute("parkWayLists", parkWayList);
		model.addAttribute("termManagementLists", termManagementList);
		model.addAttribute("supplierLists", supplierList);
		return "product/teamTicket/add";
	}

	@GetMapping("/edit/{productId}")
	@RequiresPermissions("product:teamTicket:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		TeamTicketDO teamTicket = teamTicketService.get(productId);
		model.addAttribute("teamTicket", teamTicket);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.TEAM_TICKET);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(map);
		//分销渠道
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		//票种分组
		map.put("type", "ticket_group");
		List<DictDO> ticketGroupList = dictService.list(map);
		/*//产品类型
		map.put("type", "product_type");
		List<DictDO> productTypeList = dictService.list(map);*/
		//支付方式
		map.put("type", "pay_type");
		List<DictDO> payTypeList = dictService.list(map);
		payTypeList = teamTicketService.list(payTypeList,teamTicket);
		//短信模板
		List<TemplateDO> templateList = templateService.list(map);
		List<TemplateDO> smsTemplateList = new ArrayList<>();
		List<TemplateDO> mmsTemplateList = new ArrayList<>();
		for(TemplateDO bean:templateList){
			if(Constant.SMS.equals(bean.getSendWay())){
				smsTemplateList.add(bean);
			}else if(Constant.MMS.equals(bean.getSendWay())){
				mmsTemplateList.add(bean);
			}
		}
		//入园方式
		map.put("type", "enter_garden_way");
		List<DictDO> parkWayList = dictService.list(map);
		//使用期限
		List<TermManagementDO> termManagementList = termManagementService.list(map);
		//供应商管理
		List<SupplierDO> supplierList = supplierService.list(map);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("ticketGroupLists", ticketGroupList);
		//model.addAttribute("productTypeLists", productTypeList);
		model.addAttribute("payTypeLists", payTypeList);
		model.addAttribute("smsTemplateLists", smsTemplateList);
		model.addAttribute("mmsTemplateLists", mmsTemplateList);
		model.addAttribute("parkWayLists", parkWayList);
		model.addAttribute("termManagementLists", termManagementList);
		model.addAttribute("supplierLists", supplierList);
	    return "product/teamTicket/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:teamTicket:add")
	public R save(TeamTicketDO teamTicket, @RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		teamTicket.setProductNo(RandomUtils.getRandomString(8));
		teamTicket.setCompanyNo(getComPanyNo());
		teamTicket.setProductType(Constant.TEAM_TICKET);
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		teamTicket.setBaseUrl(basePath);
		return teamTicketService.save(teamTicket,imgFile,files);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:teamTicket:edit")
	public R update( TeamTicketDO teamTicket,@RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		teamTicket.setBaseUrl(basePath);
		return teamTicketService.update(teamTicket,imgFile,files);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:teamTicket:remove")
	public R remove( Integer productId){
		if(teamTicketService.remove(productId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:teamTicket:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		teamTicketService.batchRemove(productIds);
		return R.ok();
	}
	
}
