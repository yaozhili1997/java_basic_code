package com.ecotourism.manage.product.controller;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.product.domain.ProductTypeDO;
import com.ecotourism.manage.product.service.impl.ProductSecondTypeServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品子类型管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-15 09:47:13
 */
 
@Controller
@RequestMapping("/product/productSecondType")
public class ProductSecondTypeController extends BaseController{
	@Autowired
	private ProductSecondTypeServiceImpl productTypeService;
	
	@GetMapping()
	@RequiresPermissions("product:productSecondType:productSecondType")
	String ProductType(){
	    return "product/productSecondType/productType";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:productSecondType:productSecondType")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("children","0");
        Query query = new Query(params);
		List<ProductTypeDO> productTypeList = productTypeService.list(query);
		int total = productTypeService.count(query);
		PageUtils pageUtils = new PageUtils(productTypeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:productSecondType:add")
	String add(Model model){
		Map<String, Object> map = new HashMap<>();
		map.put("parentTypeNo","0");
		model.addAttribute("parentTypeNos", productTypeService.list(map));
	    return "product/productSecondType/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:productSecondType:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ProductTypeDO productType = productTypeService.get(id);
		Map<String, Object> map = new HashMap<>();
		map.put("parentTypeNo","0");
		model.addAttribute("parentTypeNos", productTypeService.list(map));
		model.addAttribute("productSecondType", productType);
	    return "product/productSecondType/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:productSecondType:add")
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
	@RequiresPermissions("product:productSecondType:edit")
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
	@RequiresPermissions("product:productSecondType:remove")
	public R remove( Integer id){
		return productTypeService.remove(id);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:productSecondType:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		return productTypeService.batchRemove(ids);
	}


    @GetMapping("/tree")
    @ResponseBody
    public Tree<ProductTypeDO> tree() {
        Map<String, Object> query = new HashMap<>(16);
		query.put("parentTypeNo","0");
        Tree<ProductTypeDO> tree = new Tree<ProductTypeDO>();
        tree = productTypeService.getTree(query);
        return tree;
    }
}
