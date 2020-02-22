package com.ecotourism.supplier.cooperation.service.impl;

import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.common.utils.StringUtils;
import com.ecotourism.supplier.common.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.cooperation.dao.CooperationDistributionDao;
import com.ecotourism.supplier.cooperation.domain.CooperationDistributionDO;
import com.ecotourism.supplier.cooperation.service.CooperationDistributionService;


@Service
public class CooperationDistributionServiceImpl implements CooperationDistributionService {
	@Autowired
	private CooperationDistributionDao cooperationDistributionDao;
	
	@Override
	public CooperationDistributionDO get(Integer id){
		return cooperationDistributionDao.get(id);
	}
	
	@Override
	public List<CooperationDistributionDO> list(Map<String, Object> map){
		return cooperationDistributionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return cooperationDistributionDao.count(map);
	}

	private String getNo(){
		String no = Tools.getRandomString(8);
		int no1 = cooperationDistributionDao.findNo(no);
		if(no1>0){
			no = getNo();
		}
		return no;
	}

	@Override
	public R save(CooperationDistributionDO cooperationDistribution){
		cooperationDistribution.setDistributionNo(getNo());
		cooperationDistribution.setCreateTime(new Date());
		if(cooperationDistributionDao.save(cooperationDistribution)>0){
			return R.ok();
		}
		return R.error();
	}
	
	@Override
	public int update(CooperationDistributionDO cooperationDistribution){
		cooperationDistribution.setUpdateTime(new Date());
		return cooperationDistributionDao.update(cooperationDistribution);
	}
	
	@Override
	public int remove(Integer id){
		return cooperationDistributionDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return cooperationDistributionDao.batchRemove(ids);
	}

	@Override
	public List<CooperationDistributionDO> listAll(Map<String, Object> map) {
		return cooperationDistributionDao.listAll(map);
	}

	/**
	* 查询启用，开通接口，在签约时间内的分销商
	* @author: chqy
	* @create: 2018/7/3 15:41
	**/
	@Override
	public List<CooperationDistributionDO> listEnableCoo() {
		return cooperationDistributionDao.listEnableCoo();
	}

	@Override
	public List<DictDO> list(List<DictDO> list, CooperationDistributionDO cooperationDistribution) {
		String payType = cooperationDistribution.getPayType();
		String[] array = null;
		if(StringUtils.isBlank(payType)){
			array =new String[0];
		}else{
			array = payType.split(",");
		}
		for(DictDO bean:list){
			bean.setIsCheck("false");
			for(int i=0;i<array.length;i++){
				if(bean.getValue().equals(array[i])){
					bean.setIsCheck("true");
				}
			}
		}
		return list;
	}

}
