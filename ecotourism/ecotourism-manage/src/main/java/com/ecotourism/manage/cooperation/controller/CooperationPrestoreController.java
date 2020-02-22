package com.ecotourism.manage.cooperation.controller;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.manage.cooperation.domain.CooperationPrestoreDo;
import com.ecotourism.manage.cooperation.service.CooperationPrestoreService;
import com.ecotourism.manage.cooperation.service.CooperationRechargeRecordService;
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
 * 分销商预存款
 */
@Controller
@RequestMapping("/cooperation/prestore")
public class CooperationPrestoreController extends BaseController {

    @Autowired
    private CooperationPrestoreService cooperationPrestoreService;
    @Autowired
    private DictService dictService;
    @Autowired
    private CooperationRechargeRecordService cooperationRechargeRecordService;
    @GetMapping()
    @RequiresPermissions("cooperation:prestore:prestore")
    String CooperationPrestore(){
        return "cooperation/prestore/prestore";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("cooperation:prestore:prestore")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        //params.put("companyNo",getComPanyNo());
        Query query = new Query(params);
        List<CooperationPrestoreDo> cooperationDistributionList = cooperationPrestoreService.list(query);
        int total = cooperationPrestoreService.count(query);
        PageUtils pageUtils = new PageUtils(cooperationDistributionList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("cooperation:prestore:add")
    String add(Model model){
        List<CooperationDistributionDO> listCoo = cooperationPrestoreService.findListCoo();
        model.addAttribute("listCoo", listCoo);
        return "cooperation/prestore/add";
    }
    @GetMapping("/recharge/{id}")
    @RequiresPermissions("cooperation:prestore:recharge")
    String recharge(@PathVariable("id") Integer id, Model model){
        CooperationPrestoreDo cooperationPrestore = cooperationPrestoreService.get(id);
        model.addAttribute("cooperationPrestore", cooperationPrestore);
        return "cooperation/prestore/recharge";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("cooperation:prestore:add")
    public R save(CooperationPrestoreDo cooperationPrestore){
        cooperationPrestore.setCreateUser(getUsername());
        cooperationPrestore.setCompanyNo(getComPanyNo());
        if(cooperationPrestoreService.save(cooperationPrestore)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 预存款充值
     */
    @ResponseBody
    @RequestMapping("/recharge")
    @RequiresPermissions("cooperation:prestore:recharge")
    public R rechargeMoney( CooperationPrestoreDo cooperationPrestore){
        //获取充值金额
        Double mon=cooperationPrestore.getUpRechargeAmount();
        //获取剩余金额
        int id=cooperationPrestore.getPrestoreId();
        CooperationPrestoreDo cooperationPrestore2 = cooperationPrestoreService.get(id);
        Double money=cooperationPrestore2.getPrestoreAmount();
        //设置新的可用金额
        cooperationPrestore.setPrestoreAmount(money+mon);
        //设置新的累计充值金额
        Double ddd=cooperationPrestore2.getTotalRechargeAmount();
        Double d=ddd+mon;
        cooperationPrestore.setTotalRechargeAmount(d);
        //设置修改人
        cooperationPrestore.setUpdateUser(getUsername());
        //设置修改时间
        cooperationPrestore.setUpdateTime(new Date());
        cooperationPrestore.setCompanyNo(getComPanyNo());
        cooperationPrestoreService.update(cooperationPrestore);
        cooperationRechargeRecordService.save(cooperationPrestore);
        return R.ok();
    }

}
