package com.ecotourism.mobile.mobile.controller;

import com.ecotourism.mobile.common.controller.BaseController;
import com.ecotourism.mobile.common.utils.R;
import com.ecotourism.mobile.mobile.domain.FeedbackDO;
import com.ecotourism.mobile.mobile.service.FeedbackService;
import com.ecotourism.mobile.mobile.service.ProductCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/my")
public class UserCenterController extends BaseController {

    @Autowired
    private ProductCollectionService productCollectionService;

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/center")
    public String my() {
        return "mobile/my/center";
    }

    @RequestMapping("/addressList")
    public String addressList() {
        return "mobile/my/address_list";
    }

    @RequestMapping("/addressEdit")
    public String addressEdit(String addressNo, Model model) {
        model.addAttribute("addressNo", addressNo);
        return "mobile/my/address_edit";
    }

    @RequestMapping("/collection")
    public String collection() {
        return "mobile/my/collection";
    }

    @RequestMapping("/getCollectionByPage")
    @ResponseBody
    public R getCollectionByPage(int pageNumber, int pageSize) {
        try {
            R r = new R();
            r.put("data", productCollectionService.getCollectionByPage(getLoginOpenid(), pageNumber, pageSize));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @RequestMapping("/feedback")
    public String feedback() {
        return "mobile/my/feedback";
    }


    @RequestMapping("/saveFeedback")
    @ResponseBody
    public R saveFeedback(FeedbackDO param) {
        try {
            param.setOpenId(getLoginOpenid());
            feedbackService.saveFeedback(param);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @RequestMapping("/userInfo")
    public String userInfo() {
        return "mobile/my/user_info";
    }
}


