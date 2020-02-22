package com.ecotourism.manage.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.domain.SupplierDO;
import com.ecotourism.manage.base.domain.TermManagementDO;
import com.ecotourism.manage.base.domain.TicketTypeDO;
import com.ecotourism.manage.base.service.SupplierService;
import com.ecotourism.manage.base.service.TermManagementService;
import com.ecotourism.manage.base.service.TicketTypeService;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.RandomUtils;
import com.ecotourism.manage.product.config.Constant;
import com.ecotourism.manage.product.domain.ProductTypeDO;
import com.ecotourism.manage.product.service.ProductSecondTypeService;
import com.ecotourism.manage.sms.domain.TemplateDO;
import com.ecotourism.manage.sms.service.TemplateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecotourism.manage.product.domain.SpotTicketDO;
import com.ecotourism.manage.product.service.SpotTicketService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * 景区门票
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
 
@Controller
@RequestMapping("/product/spotTicket")
public class SpotTicketController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(CarAddTicketController.class);
	@Autowired
	private SpotTicketService spotTicketService;
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
	@RequiresPermissions("product:spotTicket:spotTicket")
	String SpotTicket(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		map.put("type", "ticket_group");
		List<DictDO> ticketGroupList = dictService.list(map);
		/*map.put("type", "product_type");
		List<DictDO> productTypeList = dictService.list(map);*/
		//票种名称
		map.put("productType", Constant.SPOT_TICKET);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(map);
		map.put("parentTypeNo", Constant.SPOT_TICKET);
		List<ProductTypeDO> productTypeList = productSecondTypeService.list(map);
		map.put("type", "whether_shelves");
		List<DictDO> whetherShelvesList = dictService.list(map);

		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("ticketGroupLists", ticketGroupList);
		model.addAttribute("productTypeLists", productTypeList);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("whetherShelvesLists", whetherShelvesList);
		return "product/spotTicket/spotTicket";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:spotTicket:spotTicket")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("productType",Constant.SPOT_TICKET);
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<SpotTicketDO> spotTicketList = spotTicketService.list(query);
		int total = spotTicketService.count(query);
		PageUtils pageUtils = new PageUtils(spotTicketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:spotTicket:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.SPOT_TICKET);
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
		return "product/spotTicket/add";
	}

	@GetMapping("/edit/{productId}")
	@RequiresPermissions("product:spotTicket:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		SpotTicketDO spotTicket = spotTicketService.get(productId);
		model.addAttribute("spotTicket", spotTicket);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.SPOT_TICKET);
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
		payTypeList = spotTicketService.list(payTypeList,spotTicket);
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
	    return "product/spotTicket/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:spotTicket:add")
	public R save(SpotTicketDO spotTicket,@RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		spotTicket.setProductNo(RandomUtils.getRandomString(8));
		spotTicket.setCompanyNo(getComPanyNo());
		spotTicket.setProductType(Constant.SPOT_TICKET);
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		spotTicket.setBaseUrl(basePath);
		return spotTicketService.save(spotTicket,imgFile,files);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:spotTicket:edit")
	public R update( SpotTicketDO spotTicket,@RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		spotTicket.setBaseUrl(basePath);
		return spotTicketService.update(spotTicket,imgFile,files);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:spotTicket:remove")
	public R remove( Integer productId){
		if(spotTicketService.remove(productId)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/changeSort")
	@ResponseBody
	public R changeSort( Integer productId,Integer sort){
		return spotTicketService.changeSort(productId,sort);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:spotTicket:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		spotTicketService.batchRemove(productIds);
		return R.ok();
	}
	
}
