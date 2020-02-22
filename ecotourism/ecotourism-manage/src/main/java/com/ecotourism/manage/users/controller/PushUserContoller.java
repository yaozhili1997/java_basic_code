package com.ecotourism.manage.users.controller;

import com.ecotourism.manage.common.controller.BaseController;
import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.PageUtils;
import com.ecotourism.manage.common.utils.Query;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.payment.domain.PaymentUserDO;
import com.ecotourism.manage.payment.service.PaymentUserService;
import com.ecotourism.manage.users.domain.PushUserDO;
import com.ecotourism.manage.users.service.PushUserService;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Controller
@RequestMapping("/users/pushUser")
public class PushUserContoller extends BaseController {

    @Autowired
    private PushUserService pushUserService;
    @Autowired
    private DictService dictService;
    @Autowired
    private PaymentUserService userService;
    @GetMapping
    @RequiresPermissions("users:pushUser:pushUser")
    String PushUser(){
        return "users/pushUser/pushUser";
    }

    //查询列表
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("users:pushUser:pushUser")
    public PageUtils list(@RequestParam Map<String,Object> params){
        Query query=new Query(params);
        List<PushUserDO> pushUserList=pushUserService.list(query);
        int total=pushUserService.count(query);
        PageUtils pageUtils=new PageUtils(pushUserList,total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("users:pushUser:add")
    String add(Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("companyNo",getComPanyNo());
        List<PaymentUserDO> userList = userService.list(map);
        //用户类型
        map.put("type", "user_type");
        List<DictDO> userTypeList = dictService.list(map);
        model.addAttribute("userTypeLists", userTypeList);
        model.addAttribute("userLists", userList);
        return "users/pushUser/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("users:pushUser:edit")
    String edit(@PathVariable ("id") Integer id, Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("companyNo",getComPanyNo());
        List<PaymentUserDO> userList = userService.list(map);
        //用户类型
        map.put("type", "user_type");
        List<DictDO> userTypeList = dictService.list(map);
        model.addAttribute("userTypeLists", userTypeList);
        model.addAttribute("userLists", userList);
        PushUserDO pushUser=pushUserService.get(id);
        model.addAttribute("pushUser",pushUser);
        return "users/pushUser/edit";
    }

    //保存
    @PostMapping("/save")
    @ResponseBody
    @RequiresPermissions("users:pushUser:add")
    public R save(PushUserDO pushUser){
        pushUser.setCreateUser(getUsername());
        pushUser.setCompanyNo(getComPanyNo());
        if(pushUserService.save(pushUser)>0){
            return R.ok();
        }
        return R.error();
    }

    //修改
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("users:pushUser:edit")
    public R update(PushUserDO pushUser){
        pushUser.setUpdateUser(getUsername());
        int flag = pushUserService.update(pushUser);
        if(flag>0){
            return R.ok();
        }
        return R.error();
    }

    //修改
    @ResponseBody
    @RequestMapping("/downLoadQr")
    //@RequiresPermissions("users:pushUser:downLoadQr")
    public ResponseEntity<byte[]> downLoadQr(Integer id) throws Exception{
        File file = pushUserService.downLoadQr(id);
        String filename = file.getName();
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }



    //删除
    @ResponseBody
    @PostMapping("/remove")
    @RequiresPermissions("users:pushUser:remove")
    public R remove(Integer id){
        if(pushUserService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    //批量删除
    @ResponseBody
    @PostMapping("/batchRemove")
    @RequiresPermissions("users:pushUser:batchRemove")
    public R batchRemove(@RequestParam("ids[]") Integer[] ids){
        if(pushUserService.batchRemove(ids)>0){
            return R.ok();
        }
        return R.error();
    }

}
