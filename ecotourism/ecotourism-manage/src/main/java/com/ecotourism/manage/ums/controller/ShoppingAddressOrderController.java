package com.ecotourism.manage.ums.controller;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.ums.domain.ShoppingAddressOrderDO;
import com.ecotourism.manage.ums.service.ShoppingAddressOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Controller
@RequestMapping("/ums/shoppingAddressOrder")
public class ShoppingAddressOrderController extends BaseController{

    @Autowired
    private ShoppingAddressOrderService shoppingAddressOrderService;

    @GetMapping()
    @RequiresPermissions("ums:shoppingAddressOrder:shoppingAddressOrder")
    String ShoppingAddressOrder(){
        return "ums/shoppingAddressOrder/shoppingAddressOrder";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("ums:shoppingAddressOrder:shoppingAddressOrder")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ShoppingAddressOrderDO> shoppingAddressOrderList = shoppingAddressOrderService.list(query);
        int total = shoppingAddressOrderService.count(query);
        PageUtils pageUtils = new PageUtils(shoppingAddressOrderList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("ums:shoppingAddressOrder:add")
    String add(){
        return "ums/shoppingAddressOrder/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("ums:shoppingAddressOrder:edit")
    String edit(@PathVariable("id") Integer id, Model model){
        ShoppingAddressOrderDO shoppingAddressOrder = shoppingAddressOrderService.get(id);
        model.addAttribute("shoppingAddressOrder", shoppingAddressOrder);
        return "ums/shoppingAddressOrder/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("ums:shoppingAddressOrder:add")
    public R save( ShoppingAddressOrderDO shoppingAddressOrder){
        if(shoppingAddressOrderService.save(shoppingAddressOrder)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("ums:shoppingAddressOrder:edit")
    public R update( ShoppingAddressOrderDO shoppingAddressOrder){
        shoppingAddressOrderService.update(shoppingAddressOrder);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("ums:shoppingAddressOrder:remove")
    public R remove( Integer id){
        if(shoppingAddressOrderService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("ums:shoppingAddressOrder:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids){
        shoppingAddressOrderService.batchRemove(ids);
        return R.ok();
    }
}
