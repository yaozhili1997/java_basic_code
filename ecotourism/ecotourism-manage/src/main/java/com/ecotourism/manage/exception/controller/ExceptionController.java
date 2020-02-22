package com.ecotourism.manage.exception.controller;

import java.util.List;
import java.util.Map;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ecotourism.manage.exception.domain.ExceptionDO;
import com.ecotourism.manage.exception.service.ExceptionService;

/**
 * 异常信息记录
 * 
 * @author chqy
 * @date 2018-10-15 16:39:30
 */
 
@Controller
@RequestMapping("/exception/exceptionmsg")
public class ExceptionController {
	@Autowired
	private ExceptionService exceptionService;
	
	@GetMapping()
	@RequiresPermissions("exception:exceptionmsg:exception")
	String Exception(){
	    return "exception/exception";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("exception:exceptionmsg:exception")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ExceptionDO> exceptionList = exceptionService.list(query);
		int total = exceptionService.count(query);
		PageUtils pageUtils = new PageUtils(exceptionList, total);
		return pageUtils;
	}
	/*@GetMapping("/add")
	@RequiresPermissions("exception:exception:add")
	String add(){
	    return "exception/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("exception:exception:edit")
	String edit(@PathVariable("id") Long id,Model model){
		ExceptionDO exception = exceptionService.get(id);
		model.addAttribute("exception", exception);
	    return "eexception/edit";
	}*/
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("exception:exceptionmsg:add")
	public R save(ExceptionDO exception){
		if(exceptionService.save(exception)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("exception:exceptionmsg:edit")
	public R update( ExceptionDO exception){
		exceptionService.update(exception);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("exception:exceptionmsg:remove")
	public R remove( Long id){
		if(exceptionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("exception:exceptionmsg:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		exceptionService.batchRemove(ids);
		return R.ok();
	}
	
}
