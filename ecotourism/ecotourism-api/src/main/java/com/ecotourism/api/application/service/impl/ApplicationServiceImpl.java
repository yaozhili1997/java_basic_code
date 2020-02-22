package com.ecotourism.api.application.service.impl;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.util.ApiUtils;
import com.ecotourism.api.application.dao.ApplicationDao;
import com.ecotourism.api.application.domain.DistributionDO;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.application.service.ApplicationService;


@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationDao applicationDao;
	
	@Override
	public R getApplication(String applicationNo){
		ApplicationDO applicationDO = applicationDao.get(applicationNo);
		if(applicationDO==null) return R.error(ApiEnum.appNotExists.code,ApiEnum.appNotExists.msg);
		String distributionNo = applicationDO.getDistributionNo();
		if(StringUtils.isBlank(distributionNo))return R.error(ApiUtils.getError(ApiEnum.appNotDistributionNo.code,ApiEnum.appNotDistributionNo.msg));
		String baseUrlNo = applicationDO.getBaseUrlNo();
		if(StringUtils.isBlank(baseUrlNo))return R.error(ApiUtils.getError(ApiEnum.appNotOmsUrl.code,ApiEnum.appNotOmsUrl.msg));
		DistributionDO distribution = applicationDao.getDistribution(distributionNo);
		if(distribution==null){
			return R.error(ApiUtils.getError(ApiEnum.appNotDistributionNo.code,ApiEnum.appNotDistributionNo.msg));
		}
		distribution.setBaseUrl(baseUrlNo);
		applicationDO.setDistribution(distribution);
		return R.ok(applicationDO);
	}
	public ApplicationDO getOnlyApplication(String applicationNo){
		return applicationDao.get(applicationNo);
	}
}
