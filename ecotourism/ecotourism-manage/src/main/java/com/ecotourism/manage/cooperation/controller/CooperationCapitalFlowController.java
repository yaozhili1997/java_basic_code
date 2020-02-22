package com.ecotourism.manage.cooperation.controller;
import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.cooperation.domain.CooperationCapitalFlowDo;
import com.ecotourism.manage.cooperation.service.CooperationCapitalFlowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 * 资金流水管理
 */
@Controller
@RequestMapping("/cooperation/capitalFlow")
public class CooperationCapitalFlowController extends BaseController {

    @Autowired
    private CooperationCapitalFlowService cooperationCapitalFlowService;

    @GetMapping()
    @RequiresPermissions("cooperation:capitalFlow:capitalFlow")
    String CooperationCapitalFlow(){
        return "cooperation/capitalFlow/capitalFlow";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("cooperation:capitalFlow:capitalFlow")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        //params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
        List<CooperationCapitalFlowDo> cooperationCapitalFlowList = cooperationCapitalFlowService.list(query);
        int total = cooperationCapitalFlowService.count(query);
        PageUtils pageUtils = new PageUtils(cooperationCapitalFlowList, total);
        return pageUtils;
    }

    @GetMapping("add")
    @RequiresPermissions("cooperation:capitalFlow:add")
    String add(Model model){
        return "cooperation/capitalFlow/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("cooperation:capitalFlow:edit")
    String edit(@PathVariable("id") Integer id,Model model){
        CooperationCapitalFlowDo cooperationCapitalFlow=cooperationCapitalFlowService.get(id);
        model.addAttribute("cooperationCapitalFlow",cooperationCapitalFlow);
        return "cooperation/capitalFlow/edit";
    }

    //保存
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("cooperation:capitalFlow:add")
    public R save(CooperationCapitalFlowDo cooperationCapitalFlow){
        cooperationCapitalFlow.setCompanyNo(getComPanyNo());
        cooperationCapitalFlow.setCreateTime(new Date());
        cooperationCapitalFlow.setCreateUser(getUsername());
        if(cooperationCapitalFlowService.save(cooperationCapitalFlow)>0){
            return R.ok();
        }
        return R.error();
    }

    //修改
    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("cooperation:capitalFlow:edit")
    public R update(CooperationCapitalFlowDo cooperationCapitalFlow){

        cooperationCapitalFlow.setCreateUser(getUsername());
        cooperationCapitalFlow.setCreateTime(new Date());
        cooperationCapitalFlow.setCompanyNo(getComPanyNo());
        if(cooperationCapitalFlowService.update(cooperationCapitalFlow)>0){
            return R.ok();
        }
        return R.error();
    }
}
