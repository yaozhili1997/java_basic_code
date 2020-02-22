package com.ecotourism.supplier.product.controller;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.domain.Tree;
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

import com.ecotourism.supplier.product.domain.ProductTypeDO;
import com.ecotourism.supplier.product.service.ProductTypeService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * 产品类型管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-15 09:47:13
 */
 
@Controller
@RequestMapping("/product/productType")
public class ProductTypeController extends BaseController{
	@Autowired
	private ProductTypeService productTypeService;
	
	@GetMapping()
	@RequiresPermissions("product:productType:productType")
	String ProductType(){
	    return "product/productType/productType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:productType:productType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("parentTypeNo","0");
        Query query = new Query(params);
		List<ProductTypeDO> productTypeList = productTypeService.list(query);
		int total = productTypeService.count(query);
		PageUtils pageUtils = new PageUtils(productTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:productType:add")
	String add(){
	    return "product/productType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:productType:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProductTypeDO productType = productTypeService.get(id);
		model.addAttribute("productType", productType);
	    return "product/productType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:productType:add")
	public R save(@RequestParam("file") MultipartFile[] files,@RequestParam("iconFile") MultipartFile iconFile, ProductTypeDO productType){
		productType.setCompanyNo(getComPanyNo());
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		productType.setBaseUrl(basePath);
		return productTypeService.save(productType,iconFile,files);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:productType:edit")
	public R update( @RequestParam("file") MultipartFile[] files,@RequestParam("iconFile") MultipartFile iconFile,ProductTypeDO productType){
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath();
		productType.setBaseUrl(basePath);
		productTypeService.update(productType,iconFile,files);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:productType:remove")
	public R remove( Integer id){
		return productTypeService.remove(id);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:productType:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		return productTypeService.batchRemove(ids);
	}

	@GetMapping("/treeView")
	String treeView(@RequestParam Map<String, Object> params,Model model) {
		model.addAttribute("productType", params.get("productType"));
		return  "product/productType/productTypeTree";
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<ProductTypeDO> tree(@RequestParam Map<String, Object> params) {
		params.put("companyNo",getComPanyNo());
		Tree<ProductTypeDO> tree = new Tree<ProductTypeDO>();
		tree = productTypeService.getTree(params);
		return tree;
	}
	
}
