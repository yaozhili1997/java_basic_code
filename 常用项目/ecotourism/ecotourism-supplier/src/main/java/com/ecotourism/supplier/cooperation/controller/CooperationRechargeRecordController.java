package com.ecotourism.supplier.cooperation.controller;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.cooperation.domain.CooperationRechargeRecordDO;
import com.ecotourism.supplier.cooperation.service.CooperationRechargeRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 * 充值记录管理
 */
@Controller
@RequestMapping("/cooperation/rechargeRecord")
public class CooperationRechargeRecordController extends BaseController {

        @Autowired
        private CooperationRechargeRecordService cooperationRechargeRecordService;

        @GetMapping()
        @RequiresPermissions("cooperation:rechargeRecord:rechargeRecord")
        String CooperationRechargeRecord(){

                return "cooperation/rechargeRecord/rechargeRecord";
        }

        @ResponseBody
        @GetMapping("/list")
        @RequiresPermissions("cooperation:rechargeRecord:rechargeRecord")
        public PageUtils list(@RequestParam Map<String, Object> params){
                //查询列表数据
                //params.put("companyNo",getComPanyNo());
                Query query = new Query(params);
                List<CooperationRechargeRecordDO> cooperationRechargeRecordList = cooperationRechargeRecordService.list(query);
                int total = cooperationRechargeRecordService.count(query);
                PageUtils pageUtils = new PageUtils(cooperationRechargeRecordList, total);
                return pageUtils;
        }
}
