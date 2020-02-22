package com.ecotourism.manage.inter.service.impl;

import com.ecotourism.manage.common.utils.StringUtils;
import com.ecotourism.manage.inter.domain.OmsApiDO;
import com.ecotourism.manage.inter.service.OmsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.ecotourism.manage.inter.dao.OmsApiDictionaryDao;
import com.ecotourism.manage.inter.domain.OmsApiDictionaryDO;
import com.ecotourism.manage.inter.service.OmsApiDictionaryService;



@Service
public class OmsApiDictionaryServiceImpl implements OmsApiDictionaryService {
	@Autowired
	private OmsApiDictionaryDao omsApiDictionaryDao;
	@Autowired
	private OmsApiService omsApiService;

	@Override
	public OmsApiDictionaryDO get(Integer id){
		return omsApiDictionaryDao.get(id);
	}

	@Override
	public List<OmsApiDictionaryDO> listByDisNo(Map<String, Object> map) {
		return omsApiDictionaryDao.listByDisNo(map);
	}

	@Override
	public List<OmsApiDictionaryDO> list(Map<String, Object> map){
		return omsApiDictionaryDao.list(map);
	}

	@Override
	public List<OmsApiDO> listCheck(List<OmsApiDictionaryDO> list) {
		Map<String, Object> map = new HashMap<>();
		List<OmsApiDO> omsApiDOList = omsApiService.list(map);
		for(OmsApiDO bean:omsApiDOList){
			bean.setIsCheck("false");
			for(OmsApiDictionaryDO omsApiDictionaryDO:list){
				if(Objects.equals(bean.getApino(), omsApiDictionaryDO.getApino())){
					bean.setIsCheck("true");
					break;
				}
			}
		}
		return omsApiDOList;
	}

	@Override
	public int count(Map<String, Object> map){
		return omsApiDictionaryDao.count(map);
	}
	
	@Override
	public int save(OmsApiDictionaryDO omsApiDictionary){
		List<String> apinos = omsApiDictionary.getApinos();
		String distributionNo = omsApiDictionary.getDistributionNo();
		if(StringUtils.isNotBlank(distributionNo)) {
			omsApiDictionaryDao.removeByDistributionNo(distributionNo);
		}
		for(String apino:apinos){
			OmsApiDictionaryDO bean = new OmsApiDictionaryDO();
			OmsApiDO omsApiDO = omsApiService.getByApino(apino);
			bean.setApino(apino);
			bean.setDistributionNo(omsApiDictionary.getDistributionNo());
			bean.setApiurl(omsApiDO.getApiurl());
			bean.setApiexplain(omsApiDO.getApiname());
			bean.setEnabled("1");
			bean.setVersion(omsApiDO.getVersion());
			omsApiDictionaryDao.save(bean);
		}
		return 1;
	}
	
	@Override
	public int update(OmsApiDictionaryDO omsApiDictionary){
		return save(omsApiDictionary);
	}
	
	@Override
	public int remove(Integer id){
		return omsApiDictionaryDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return omsApiDictionaryDao.batchRemove(ids);
	}
	
}
