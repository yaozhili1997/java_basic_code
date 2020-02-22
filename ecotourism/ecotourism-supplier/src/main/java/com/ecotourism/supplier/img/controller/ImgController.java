package com.ecotourism.supplier.img.controller;

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

import com.ecotourism.supplier.img.domain.ImgDO;
import com.ecotourism.supplier.img.service.ImgService;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:40:19
 */
 
@Controller
@RequestMapping("/img/img")
public class ImgController {
	@Autowired
	private ImgService imgService;
	
	@GetMapping()
	@RequiresPermissions("img:img:img")
	String Img(){
	    return "img/img/img";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("img:img:img")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ImgDO> imgList = imgService.list(query);
		int total = imgService.count(query);
		PageUtils pageUtils = new PageUtils(imgList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("img:img:add")
	String add(){
	    return "img/img/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("img:img:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ImgDO img = imgService.get(id);
		model.addAttribute("img", img);
	    return "img/img/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("img:img:add")
	public R save( ImgDO img){
		if(imgService.save(img)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("img:img:edit")
	public R update( ImgDO img){
		imgService.update(img);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("img:img:remove")
	public R remove( Integer id){
		if(imgService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("img:img:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		imgService.batchRemove(ids);
		return R.ok();
	}
	
}
