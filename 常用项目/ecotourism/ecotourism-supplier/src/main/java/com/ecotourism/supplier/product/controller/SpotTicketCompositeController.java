package com.ecotourism.supplier.product.controller;

import java.util.List;
import java.util.Map;

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

import com.ecotourism.supplier.product.domain.SpotTicketCompositeDO;
import com.ecotourism.supplier.product.service.SpotTicketCompositeService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
 
@Controller
@RequestMapping("/product/spotTicketComposite")
public class SpotTicketCompositeController {
	@Autowired
	private SpotTicketCompositeService spotTicketCompositeService;
	
	@GetMapping()
	@RequiresPermissions("product:spotTicketComposite:spotTicketComposite")
	String SpotTicketComposite(){
	    return "product/spotTicketComposite/spotTicketComposite";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("product:spotTicketComposite:spotTicketComposite")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SpotTicketCompositeDO> spotTicketCompositeList = spotTicketCompositeService.list(query);
		int total = spotTicketCompositeService.count(query);
		PageUtils pageUtils = new PageUtils(spotTicketCompositeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("product:spotTicketComposite:add")
	String add(){
	    return "product/spotTicketComposite/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("product:spotTicketComposite:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SpotTicketCompositeDO spotTicketComposite = spotTicketCompositeService.get(id);
		model.addAttribute("spotTicketComposite", spotTicketComposite);
	    return "product/spotTicketComposite/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("product:spotTicketComposite:add")
	public R save( SpotTicketCompositeDO spotTicketComposite){
		if(spotTicketCompositeService.save(spotTicketComposite)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("product:spotTicketComposite:edit")
	public R update( SpotTicketCompositeDO spotTicketComposite){
		spotTicketCompositeService.update(spotTicketComposite);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("product:spotTicketComposite:remove")
	public R remove( Integer id){
		if(spotTicketCompositeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("product:spotTicketComposite:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		spotTicketCompositeService.batchRemove(ids);
		return R.ok();
	}
	
}
