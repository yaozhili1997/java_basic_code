package com.ecotourism.supplier.ums.controller;

import com.ecotourism.supplier.common.controller.BaseController;
import com.ecotourism.supplier.common.utils.PageUtils;
import com.ecotourism.supplier.common.utils.Query;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.ums.domain.ShoppingCartDO;
import com.ecotourism.supplier.ums.service.ShoppingCartService;
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
@RequestMapping("/ums/shoppingCart")
public class ShoppingCartController extends BaseController{

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping()
    @RequiresPermissions("ums:shoppingCart:shoppingCart")
    String ShoppingCart(){
        return "ums/shoppingCart/shoppingCart";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("ums:shoppingCart:shoppingCart")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<ShoppingCartDO> shoppingCartList = shoppingCartService.list(query);
        int total = shoppingCartService.count(query);
        PageUtils pageUtils = new PageUtils(shoppingCartList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("ums:shoppingCart:add")
    String add(){
        return "/ums/shoppingCart/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("ums:shoppingCart:edit")
    String edit(@PathVariable("id") Integer id, Model model){
        ShoppingCartDO shoppingCart = shoppingCartService.get(id);
        model.addAttribute("shoppingCart", shoppingCart);
        return "ums/shoppingCart/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("ums:shoppingCart:add")
    public R save(ShoppingCartDO shoppingCart){
        if(shoppingCartService.save(shoppingCart)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("ums:shoppingCart:edit")
    public R update( ShoppingCartDO shoppingCart){
        shoppingCartService.update(shoppingCart);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    @RequiresPermissions("ums:shoppingCart:remove")
    public R remove( Integer id){
        if(shoppingCartService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    @RequiresPermissions("ums:shoppingCart:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids){
        shoppingCartService.batchRemove(ids);
        return R.ok();
    }
}
