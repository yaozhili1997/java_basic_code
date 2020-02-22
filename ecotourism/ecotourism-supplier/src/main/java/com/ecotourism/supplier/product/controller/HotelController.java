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
import com.ecotourism.supplier.product.domain.CreativeProductDO;
import com.ecotourism.supplier.product.domain.HotelDO;
import com.ecotourism.supplier.product.domain.ProductTypeDO;
import com.ecotourism.supplier.product.service.CreativeProductService;
import com.ecotourism.supplier.product.service.HotelService;
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
@RequestMapping("/product/hotel")
public class HotelController extends BaseController{
	@Autowired
	private HotelService hotelService;
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
	@RequiresPermissions("product:hotel:hotel")
	String hotel(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		map.put("type", "ticket_group");
		List<DictDO> ticketGroupList = dictService.list(map);
		/*map.put("type", "product_type");
		List<DictDO> productTypeList = dictService.list(map);*/
		//票种名称
		map.put("productType", Constant.HOTEL_TICKET);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(map);
		map.put("parentTypeNo", Constant.HOTEL_TICKET);
		List<ProductTypeDO> productTypeList = productSecondTypeService.list(map);
		map.put("type", "whether_shelves");
		List<DictDO> whetherShelvesList = dictService.list(map);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("ticketGroupLists", ticketGroupList);
		model.addAttribute("productTypeLists", productTypeList);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("whetherShelvesLists", whetherShelvesList);
		return "product/hotel/hotel";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:hotel:hotel")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("productType",Constant.HOTEL_TICKET);
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<HotelDO> spotTicketList = hotelService.list(query);
		int total = hotelService.count(query);
		PageUtils pageUtils = new PageUtils(spotTicketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:hotel:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.HOTEL_TICKET);
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
		return "product/hotel/add";
	}

	@GetMapping("/edit/{productId}")
	@RequiresPermissions("product:hotel:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		HotelDO hotel = hotelService.get(productId);
		model.addAttribute("hotel", hotel);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.HOTEL_TICKET);
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
		payTypeList = hotelService.list(payTypeList,hotel);
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
	    return "product/hotel/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:hotel:add")
	public R save(HotelDO hotel, @RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		hotel.setProductNo(RandomUtils.getRandomString(8));
		hotel.setCompanyNo(getComPanyNo());
		hotel.setProductType(Constant.HOTEL_TICKET);
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		hotel.setBaseUrl(basePath);
		return hotelService.save(hotel,imgFile,files);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:hotel:edit")
	public R update( HotelDO hotel,@RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		hotel.setBaseUrl(basePath);
		return hotelService.update(hotel,imgFile,files);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:hotel:remove")
	public R remove( Integer productId){
		if(hotelService.remove(productId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:hotel:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		hotelService.batchRemove(productIds);
		return R.ok();
	}
	
}
