package com.ecotourism.manage.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.domain.SpotManagementDO;
import com.ecotourism.manage.base.domain.SupplierDO;
import com.ecotourism.manage.base.service.SpotManagementService;
import com.ecotourism.manage.base.service.SupplierService;
import com.ecotourism.manage.common.annotation.Log;
import com.ecotourism.manage.common.config.Constant;
import com.ecotourism.manage.common.config.DictTypeConfig;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.product.domain.ProductTypeDO;
import com.ecotourism.manage.product.service.ProductTypeService;
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

import com.ecotourism.manage.base.domain.TicketTypeDO;
import com.ecotourism.manage.base.service.TicketTypeService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;

/**
 * 门票种类
 * 
 * @author chqy
 * @date 2018-05-31 14:38:39
 */
 
@Controller
@RequestMapping("/base/ticketType")
public class TicketTypeController extends BaseController{
	@Autowired
	private TicketTypeService ticketTypeService;
	@Autowired
	private DictService dictService;
	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private SpotManagementService spotManagementService;
	@GetMapping()
	@RequiresPermissions("base:ticketType:ticketType")
	String TicketType(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("available","1");
		List<SpotManagementDO> spotlist = spotManagementService.list(map);
		model.addAttribute("spotlist", spotlist);
		map.put("type", DictTypeConfig.TYPE_TICKET_TYPE);
		List<DictDO> ticket_type = dictService.list(map);
		model.addAttribute("ticket_types",ticket_type);
		Map<String, Object> params = new HashMap<>();
		params.put("parentTypeNo","0");
		List<ProductTypeDO> productTypeList = productTypeService.list(params);
		model.addAttribute("product_types",productTypeList);
		map.put("whetherOpen","1");
		List<SupplierDO> supplierList = supplierService.list(map);
		model.addAttribute("supplierLists", supplierList);
		return "base/ticketType/ticketType";
	}

	@Log("票种定义:查询")
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("base:ticketType:ticketType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		params.put("companyNo",getComPanyNo());
		//查询列表数据
        Query query = new Query(params);
		List<TicketTypeDO> ticketTypeList = ticketTypeService.list(query);
		int total = ticketTypeService.count(query);
		PageUtils pageUtils = new PageUtils(ticketTypeList, total);
		return pageUtils;
	}

	@Log("票种定义:跳转增加")
	@GetMapping("/add")
	@RequiresPermissions("base:ticketType:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("companyNo",getComPanyNo());
		map.put("available","1");
		List<SpotManagementDO> spotlist = spotManagementService.list(map);
		map.put("type", DictTypeConfig.TYPE_TICKET_TYPE);
		List<DictDO> ticket_type = dictService.list(map);
		model.addAttribute("ticket_types",ticket_type);
		//查询列表数据
		Map<String, Object> params = new HashMap<>();
		params.put("parentTypeNo","0");
		List<ProductTypeDO> productTypeList = productTypeService.list(params);
		model.addAttribute("product_types",productTypeList);
		map.put("whetherOpen","1");
		List<SupplierDO> supplierList = supplierService.list(map);
		model.addAttribute("supplierLists", supplierList);
		model.addAttribute("spotlist", spotlist);
		return "base/ticketType/add";
	}

	@Log("票种定义:跳转修改")
	@GetMapping("/edit/{ticketId}")
	@RequiresPermissions("base:ticketType:edit")
	String edit(@PathVariable("ticketId") Integer ticketId,Model model){
		TicketTypeDO ticketType = ticketTypeService.get(ticketId);
		model.addAttribute("ticketType", ticketType);
		Map<String, Object> map = new HashMap<>();
		String comPanyNo = getComPanyNo();
		if(getUsername().equals(Constant.ADMIN_ACCOUNT)){
			comPanyNo = ticketType.getCompanyNo();
		}
		map.put("companyNo",comPanyNo);
		map.put("available","1");
		List<SpotManagementDO> spotlist = spotManagementService.list(map);
		map.put("type", DictTypeConfig.TYPE_TICKET_TYPE);
		List<DictDO> ticket_type = dictService.list(map);
		model.addAttribute("ticket_types",ticket_type);
		//查询列表数据
		Map<String, Object> params = new HashMap<>();
		params.put("parentTypeNo","0");
		List<ProductTypeDO> productTypeList = productTypeService.list(params);
		model.addAttribute("product_types",productTypeList);
		map.put("whetherOpen","1");
		List<SupplierDO> supplierList = supplierService.list(map);
		model.addAttribute("supplierLists", supplierList);
		model.addAttribute("spotlist", spotlist);
	    return "base/ticketType/edit";
	}
	
	/**
	 * 保存
	 */
	@Log("票种定义:新增")
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("base:ticketType:add")
	public R save( TicketTypeDO ticketType){
		ticketType.setCompanyNo(getComPanyNo());
		return ticketTypeService.save(ticketType);
	}
	/**
	 * 修改
	 */
	@Log("票种定义:修改")
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("base:ticketType:edit")
	public R update( TicketTypeDO ticketType){
		return ticketTypeService.update(ticketType);
	}
	
	/**
	 * 删除
	 */
	@Log("票种定义:删除")
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("base:ticketType:remove")
	public R remove( Integer ticketId){
		if(ticketTypeService.remove(ticketId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@Log("票种定义:批量删除")
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("base:ticketType:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ticketIds){
		ticketTypeService.batchRemove(ticketIds);
		return R.ok();
	}
	
}
