package com.ecotourism.api.application.service;

import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.common.utils.R;

/**
 * 调用支付接口应用信息
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-20 17:08:55
 */
public interface ApplicationService {
	
	R getApplication(String applicationNo);
	ApplicationDO getOnlyApplication(String applicationNo);
}
