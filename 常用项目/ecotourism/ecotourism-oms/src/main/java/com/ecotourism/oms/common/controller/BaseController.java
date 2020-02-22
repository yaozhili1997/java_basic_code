package com.ecotourism.oms.common.controller;

import com.ecotourism.oms.oms.domain.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {
	@Autowired
	public HttpServletRequest request;
	public void setRequestParams(RequestVo requestVo){
		request.setAttribute("requestVo", requestVo);
	}
}