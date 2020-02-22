package com.ecotourism.manage.ums.controller;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.ums.domain.ShoppingAddressDO;
import com.ecotourism.manage.ums.service.ShoppingAddressService;
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
@RequestMapping("/ums/shoppingAddress")
public class ShoppingAddressController extends BaseController {

    @Autowired
    private ShoppingAddressService shoppingAddressService;

    @GetMapping()
    @RequiresPermissions("ums:shoppingAddress:shoppingAddress")
    String ShoppingAddress(){
        return "ums/shoppingAddress/shoppingAddress";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("ums:shoppingAddress:shoppingAddress")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ShoppingAddressDO> shoppingAddressList = shoppingAddressService.list(query);
        int total = shoppingAddressService.count(query);
        PageUtils pageUtils = new PageUtils(shoppingAddressList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("ums:shoppingAddress:add")
    String add(){
        return "ums/shoppingAddress/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("ums:shoppingAddress:edit")
    String edit(@PathVariable("id") Integer id, Model model){
        ShoppingAddressDO shoppingAddress = shoppingAddressService.get(id);
        model.addAttribute("shoppingAddress", shoppingAddress);
        return "ums/shoppingAddress/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("ums:shoppingAddress:add")
    public R save(ShoppingAddressDO shoppingAddress){
        if(shoppingAddressService.save(shoppingAddress)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("ums:shoppingAddress:edit")
    public R update( ShoppingAddressDO shoppingAddress){
        shoppingAddressService.update(shoppingAddress);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("ums:shoppingAddress:remove")
    public R remove( Integer id){
        if(shoppingAddressService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("ums:shoppingAddress:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids){
        shoppingAddressService.batchRemove(ids);
        return R.ok();
    }
}
