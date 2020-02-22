package com.ecotourism.api.api.service;

import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.common.utils.R;

/**
 * 说明：用户相关接口
 * 创建人：陈启勇
 * 创建时间: 2018/9/17 11:27
 **/
public interface ClientUserService {
    /**
     * @Description 获取用户信息
     * @Author scotte
     * @Date 2018/10/8 16:27
     * @Param [requestVo]
     * @return com.ecotourism.api.common.utils.R
     */
    R getUserInfo(RequestVo requestVo);
}
