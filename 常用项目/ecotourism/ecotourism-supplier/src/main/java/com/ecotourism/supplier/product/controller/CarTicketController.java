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
import com.ecotourism.supplier.line.domain.LineManagementDO;
import com.ecotourism.supplier.line.service.LineManagementService;
import com.ecotourism.supplier.product.config.Constant;
import com.ecotourism.supplier.product.domain.CarTicketDO;
import com.ecotourism.supplier.product.domain.ProductTypeDO;
import com.ecotourism.supplier.product.service.CarTicketService;
import com.ecotourism.supplier.product.service.ProductSecondTypeService;
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
@RequestMapping("/product/carTicket")
public class CarTicketController extends BaseController{
	@Autowired
	private CarTicketService carTicketService;
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
	@Autowired
	private LineManagementService managementService;
	@GetMapping()
	@RequiresPermissions("product:carTicket:carTicket")
	String CarTicket(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		map.put("type", "ticket_group");
		List<DictDO> ticketGroupList = dictService.list(map);
		//票种名称
		map.put("productType", Constant.CAR_TICKET);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(map);
		map.put("parentTypeNo", Constant.CAR_TICKET);
		List<ProductTypeDO> productTypeList = productSecondTypeService.list(map);
		map.put("type", "whether_shelves");
		List<DictDO> whetherShelvesList = dictService.list(map);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("ticketGroupLists", ticketGroupList);
		model.addAttribute("productTypeLists", productTypeList);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("whetherShelvesLists", whetherShelvesList);
		return "product/carTicket/carTicket";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:carTicket:carTicket")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("productType",Constant.CAR_TICKET);
		params.put("companyNo",getComPanyNo());
		Query query = new Query(params);
		List<CarTicketDO> spotTicketList = carTicketService.list(query);
		int total = carTicketService.count(query);
		PageUtils pageUtils = new PageUtils(spotTicketList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("product:carTicket:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<LineManagementDO> managementList = managementService.list(map);
		//票种名称
		map.put("productType", Constant.CAR_TICKET);
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
		model.addAttribute("managementLists", managementList);
		return "product/carTicket/add";
	}

	@GetMapping("/edit/{productId}")
	@RequiresPermissions("product:carTicket:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		CarTicketDO carTicket = carTicketService.get(productId);
		model.addAttribute("carTicket", carTicket);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		List<LineManagementDO> managementList = managementService.listLineManagement(map,carTicket.getSubordinateLine());
		//票种名称
		map.put("productType", Constant.CAR_TICKET);
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
		payTypeList = carTicketService.list(payTypeList,carTicket);
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
		model.addAttribute("managementLists", managementList);
		return "product/carTicket/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:carTicket:add")
	public R save( CarTicketDO carTicket,@RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		carTicket.setProductNo(RandomUtils.getRandomString(8));
		carTicket.setCompanyNo(getComPanyNo());
		carTicket.setProductType(Constant.CAR_TICKET);
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		carTicket.setBaseUrl(basePath);
		return carTicketService.save(carTicket,imgFile,files);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:carTicket:edit")
	public R update(CarTicketDO carTicket, @RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		carTicket.setBaseUrl(basePath);
		return carTicketService.update(carTicket,imgFile,files);
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:carTicket:remove")
	public R remove( Integer productId){
		if(carTicketService.remove(productId)>0){
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:carTicket:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		carTicketService.batchRemove(productIds);
		return R.ok();
	}

}
