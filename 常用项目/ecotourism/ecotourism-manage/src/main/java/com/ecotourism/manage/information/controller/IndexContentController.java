package com.ecotourism.manage.information.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.payment.domain.PaymentUserDO;
import com.ecotourism.manage.payment.service.PaymentUserService;
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

import com.ecotourism.manage.information.domain.IndexContentDO;
import com.ecotourism.manage.information.service.IndexContentService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文章内容
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-10-24 11:55:37
 */
 
@Controller
@RequestMapping("/information/indexContent")
public class IndexContentController extends BaseController{
	@Autowired
	private IndexContentService indexContentService;
	@Autowired
	private PaymentUserService paymentUserService;
	@GetMapping()
	@RequiresPermissions("information:indexContent:indexContent")
	String IndexContent(){
		return "information/indexContent/indexContent";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:indexContent:indexContent")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<IndexContentDO> indexContentList = indexContentService.list(query);
		int total = indexContentService.count(query);
		PageUtils pageUtils = new PageUtils(indexContentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:indexContent:add")
	String add(Model model){
		//查询列表数据
		Map<String, Object> params = new HashMap<>();
		params.put("companyNo",getComPanyNo());
		List<PaymentUserDO> paymentUserList = paymentUserService.list(params);
		model.addAttribute("paymentUserLists", paymentUserList);
	    return "information/indexContent/add";
	}

	@GetMapping("/edit/{cid}")
	@RequiresPermissions("information:indexContent:edit")
	String edit(@PathVariable("cid") Long cid,Model model){
		IndexContentDO indexContent = indexContentService.get(cid);
		Map<String, Object> params = new HashMap<>();
		params.put("companyNo",getComPanyNo());
		List<PaymentUserDO> paymentUserList = paymentUserService.list(params);
		model.addAttribute("paymentUserLists", paymentUserList);
		model.addAttribute("indexContent", indexContent);
	    return "information/indexContent/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:indexContent:add")
	public R save( IndexContentDO indexContent,@RequestParam("imgFile") MultipartFile imgFile){
		String s = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		indexContent.setBaseUrl(s);
		if(indexContentService.save(indexContent,imgFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:indexContent:edit")
	public R update( IndexContentDO indexContent,@RequestParam("imgFile") MultipartFile imgFile){
		String s = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
		indexContent.setBaseUrl(s);
		indexContentService.update(indexContent,imgFile);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:indexContent:remove")
	public R remove( Long cid){
		if(indexContentService.remove(cid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:indexContent:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] cids){
		indexContentService.batchRemove(cids);
		return R.ok();
	}
	
}
