package com.ecotourism.manage.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ecotourism.manage.common.utils.ShiroUtils;
import com.ecotourism.manage.system.domain.UserDO;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {
	@Autowired
	public HttpServletRequest request;
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
	public String getComPanyNo(){
		UserDO user = getUser();
		if(user!=null){
			return user.getCompanyNo();
		}
		return null;
	}
}