package com.ecotourism.oms.oms.service;

import com.ecotourism.oms.oms.domain.RequestVo;

import javax.servlet.http.HttpServletRequest;

public interface ValidateAuthorizationService {

    String validateAuthorization(RequestVo requestVo, HttpServletRequest request);
}
