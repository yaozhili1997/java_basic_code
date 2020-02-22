package com.ecotourism.manage.system.controller;

import com.ecotourism.manage.base.domain.SupplierDO;
import com.ecotourism.manage.base.service.SupplierService;
import com.ecotourism.manage.common.annotation.Log;
import com.ecotourism.manage.common.config.Constant;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.*;
import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.service.CooperationDistributionService;
import com.ecotourism.manage.system.domain.CompanyDO;
import com.ecotourism.manage.system.domain.DeptDO;
import com.ecotourism.manage.system.domain.RoleDO;
import com.ecotourism.manage.system.domain.UserDO;
import com.ecotourism.manage.system.service.CompanyService;
import com.ecotourism.manage.system.service.DeptService;
import com.ecotourism.manage.system.service.RoleService;
import com.ecotourism.manage.system.service.UserService;
import com.ecotourism.manage.system.vo.UserVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/user")
@Controller
public class UserController extends BaseController {
	private String prefix="system/user"  ;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	DictService dictService;
	@Autowired
	private DeptService sysDeptService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CooperationDistributionService cooperationDistributionService;
	@Autowired
	SupplierService supplierService;
	@RequiresPermissions("sys:user:user")
	@GetMapping("")
	String user(Model model) {
		return prefix + "/user";
	}

	@GetMapping("/list")
	@ResponseBody
	PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		params.put("companyNo",getComPanyNo());
		Query query = new Query(params);
		List<UserDO> sysUserList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@RequiresPermissions("sys:user:add")
	@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		Map<String, Object> query = new HashMap<>(16);
		List<CompanyDO> companyList = companyService.list(new HashMap<>());
		query.put("companyNo",getComPanyNo());
		//分销渠道
		query.put("type", "system_no");
		List<DictDO> systemNoList = dictService.list(query);
		List<RoleDO> roles = roleService.list(query);
		model.addAttribute("systemNoLists", systemNoList);
		model.addAttribute("companyLists", companyList);
		model.addAttribute("roles", roles);
		return prefix + "/add";
	}

	@RequiresPermissions("sys:user:edit")
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		List<CompanyDO> companyList = companyService.list(new HashMap<>());
		UserDO userDO = userService.get(id);
		model.addAttribute("user", userDO);
		Map<String, Object> query = new HashMap<>(16);
		query.put("companyNo",getComPanyNo());
		//分销渠道
		query.put("type", "system_no");
		List<DictDO> systemNoList = dictService.list(query);
		List<RoleDO> roles = roleService.list(id,query);
		model.addAttribute("systemNoLists", systemNoList);
		model.addAttribute("companyLists", companyList);
		model.addAttribute("roles", roles);
		return prefix+"/edit";
	}

	@RequiresPermissions("sys:user:add")
	@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
	R save(UserDO user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		user.setUserIdCreate(getUserId());
		if(!Constant.ADMIN_ACCOUNT.equals(getUsername())){
			user.setCompanyNo(getComPanyNo());
		}
		if (userService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("sys:user:edit")
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	R update(UserDO user) {
		user.setCompanyNo(getComPanyNo());
		if (userService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("sys:user:edit")
	@Log("更新用户")
	@PostMapping("/updatePeronal")
	@ResponseBody
	R updatePeronal(UserDO user) {
		user.setCompanyNo(getComPanyNo());
		if (userService.updatePersonal(user) > 0) {
			return R.ok();
		}
		return R.error();
	}


	@RequiresPermissions("sys:user:remove")
	@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if (userService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("sys:user:batchRemove")
	@Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] userIds) {
		int r = userService.batchremove(userIds);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !userService.exit(params);
	}

	@RequiresPermissions("sys:user:resetPwd")
	@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {

		UserDO userDO = new UserDO();
		userDO.setUserId(userId);
		model.addAttribute("user", userDO);
		return prefix + "/reset_pwd";
	}

	@RequiresPermissions("sys:user:distribution")
	@Log("请求更改用户分销商")
	@GetMapping("/distribution/{id}")
	String distribution(@PathVariable("id") Long userId, Model model) {
		UserDO userDO = userService.get(userId);
		Map<String, Object> query = new HashMap<>(16);
		query.put("companyNo",getComPanyNo());
		List<CooperationDistributionDO> cdList = cooperationDistributionService.list(query);
		model.addAttribute("user", userDO);
		model.addAttribute("cdLists", cdList);
		return prefix + "/reset_distribution";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetDistribution")
	@ResponseBody
	R resetDistribution(UserVO userVO) {
		try{
			userService.resetDistribution(userVO.getUserDO());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}

	@RequiresPermissions("sys:user:supplier")
	@Log("请求更改用户分销商")
	@GetMapping("/supplier/{id}")
	String supplier(@PathVariable("id") Long userId, Model model) {
		UserDO userDO = userService.get(userId);
		Map<String, Object> query = new HashMap<>(16);
		query.put("companyNo",getComPanyNo());
		List<SupplierDO> supplierList = supplierService.list(query);
		model.addAttribute("user", userDO);
		model.addAttribute("supplierLists", supplierList);
		return prefix + "/reset_supplier";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetSupplier")
	@ResponseBody
	R resetSupplier(UserVO userVO) {
		try{
			userService.resetDistribution(userVO.getUserDO());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	R resetPwd(UserVO userVO) {
		try{
			userService.resetPwd(userVO,getUser());
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@RequiresPermissions("sys:user:resetPwd")
	@Log("admin提交更改用户密码")
	@PostMapping("/adminResetPwd")
	@ResponseBody
	R adminResetPwd(UserVO userVO) {
		try{
			userService.adminResetPwd(userVO);
			return R.ok();
		}catch (Exception e){
			return R.error(1,e.getMessage());
		}

	}
	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptDO> tree() {
		Tree<DeptDO> tree = new Tree<DeptDO>();
		tree = userService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/userTree";
	}

	@GetMapping("/personal")
	String personal(Model model) {
		UserDO userDO  = userService.get(getUserId());
		model.addAttribute("user",userDO);
		model.addAttribute("hobbyList",dictService.getHobbyList(userDO));
		model.addAttribute("sexList",dictService.getSexList());
		return prefix + "/personal";
	}
	@ResponseBody
	@PostMapping("/uploadImg")
	R uploadImg(@RequestParam("avatar_file") MultipartFile file, String avatar_data, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		try {
			result = userService.updatePersonalImg(file, avatar_data, getUserId());
		} catch (Exception e) {
			return R.error("更新图像失败！");
		}
		if(result!=null && result.size()>0){
			return R.ok(result);
		}else {
			return R.error("更新图像失败！");
		}
	}
}
