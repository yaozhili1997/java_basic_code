package com.ecotourism.api.api.service.impl;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.service.ClientUserService;
import com.ecotourism.api.application.service.ApplicationUserService;
import com.ecotourism.api.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明：用户相关接口
 * 创建人：陈启勇
 * 创建时间: 2018/9/17 11:27
 **/
@Service
public class ClientUserServiceImpl implements ClientUserService{
    @Autowired
    private ApplicationUserService applicationUserService;

    /**
     * @Description 获取用户信息
     * @Author scotte
     * @Date 2018/10/8 16:27
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    public R getUserInfo(RequestVo requestVo){
        OpenIdRequestParams param = (OpenIdRequestParams) requestVo.getParamsVo();
        return R.ok(applicationUserService.get(param.getOpenId()));
    }

}
