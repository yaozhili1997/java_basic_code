package com.ecotourism.supplier.cooperation.service;

import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.cooperation.domain.CooperationDistributionDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:09:13
 */
public interface CooperationDistributionService {
	
	CooperationDistributionDO get(Integer id);
	
	List<CooperationDistributionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	R save(CooperationDistributionDO cooperationDistribution);
	
	int update(CooperationDistributionDO cooperationDistribution);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<CooperationDistributionDO> listAll(Map<String, Object> map);
	/**
	 * 查询启用，开通接口，在签约时间内的分销商
	 * @author: chqy
	 * @create: 2018/7/3 15:41
	 **/
	List<CooperationDistributionDO> listEnableCoo();

	List<DictDO> list(List<DictDO> list, CooperationDistributionDO cooperationDistribution);

	// CooperationDistributionDO findDistributionNo(String distributionNo);
}
