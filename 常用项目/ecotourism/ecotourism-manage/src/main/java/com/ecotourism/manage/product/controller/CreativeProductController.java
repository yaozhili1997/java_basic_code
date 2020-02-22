package com.ecotourism.manage.product.controller;

import com.ecotourism.manage.base.domain.SupplierDO;
import com.ecotourism.manage.base.domain.TermManagementDO;
import com.ecotourism.manage.base.domain.TicketTypeDO;
import com.ecotourism.manage.base.service.SupplierService;
import com.ecotourism.manage.base.service.TermManagementService;
import com.ecotourism.manage.base.service.TicketTypeService;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.common.utils.RandomUtils;
import com.ecotourism.manage.product.config.Constant;
import com.ecotourism.manage.product.domain.CreativeProductDO;
import com.ecotourism.manage.product.domain.ProductTypeDO;
import com.ecotourism.manage.product.service.CreativeProductService;
import com.ecotourism.manage.product.service.ProductSecondTypeService;
import com.ecotourism.manage.sms.domain.TemplateDO;
import com.ecotourism.manage.sms.service.TemplateService;
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
@RequestMapping("/product/creativeProduct")
public class CreativeProductController extends BaseController{
	@Autowired
	private CreativeProductService creativeProductService;
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
	@RequiresPermissions("product:creativeProduct:creativeProduct")
	String CreativeProduct(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("type", "distribution_channel");
		List<DictDO> distributionChannelList = dictService.list(map);
		map.put("type", "ticket_group");
		List<DictDO> ticketGroupList = dictService.list(map);
		/*map.put("type", "product_type");
		List<DictDO> productTypeList = dictService.list(map);*/
		//票种名称
		map.put("productType", Constant.CREATIVE_TICKET);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(map);
		map.put("parentTypeNo", Constant.CREATIVE_TICKET);
		List<ProductTypeDO> productTypeList = productSecondTypeService.list(map);
		map.put("type", "whether_shelves");
		List<DictDO> whetherShelvesList = dictService.list(map);
		model.addAttribute("distributionChannelLists", distributionChannelList);
		model.addAttribute("ticketGroupLists", ticketGroupList);
		model.addAttribute("productTypeLists", productTypeList);
		model.addAttribute("ticketTypeLists", ticketTypeList);
		model.addAttribute("whetherShelvesLists", whetherShelvesList);
		return "product/creativeProduct/creativeProduct";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:creativeProduct:creativeProduct")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("productType",Constant.CREATIVE_TICKET);
		params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
		List<CreativeProductDO> spotTicketList = creativeProductService.list(query);
		int total = creativeProductService.count(query);
		PageUtils pageUtils = new PageUtils(spotTicketList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:creativeProduct:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.CREATIVE_TICKET);
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
		return "product/creativeProduct/add";
	}

	@GetMapping("/edit/{productId}")
	@RequiresPermissions("product:creativeProduct:edit")
	String edit(@PathVariable("productId") Integer productId,Model model){
		CreativeProductDO creativeProduct = creativeProductService.get(productId);
		model.addAttribute("creativeProduct", creativeProduct);
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		//票种名称
		map.put("productType", Constant.CREATIVE_TICKET);
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
		payTypeList = creativeProductService.list(payTypeList,creativeProduct);
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
	    return "product/creativeProduct/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:creativeProduct:add")
	public R save(CreativeProductDO creativeProduct, @RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		creativeProduct.setProductNo(RandomUtils.getRandomString(8));
		creativeProduct.setCompanyNo(getComPanyNo());
		creativeProduct.setProductType(Constant.CREATIVE_TICKET);
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		creativeProduct.setBaseUrl(basePath);
		return creativeProductService.save(creativeProduct,imgFile,files);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:creativeProduct:edit")
	public R update( CreativeProductDO creativeProduct,@RequestParam("file") MultipartFile[] files, @RequestParam("imgFile") MultipartFile imgFile){
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		creativeProduct.setBaseUrl(basePath);
		return creativeProductService.update(creativeProduct,imgFile,files);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:creativeProduct:remove")
	public R remove( Integer productId){
		if(creativeProductService.remove(productId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:creativeProduct:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] productIds){
		creativeProductService.batchRemove(productIds);
		return R.ok();
	}
	
}
