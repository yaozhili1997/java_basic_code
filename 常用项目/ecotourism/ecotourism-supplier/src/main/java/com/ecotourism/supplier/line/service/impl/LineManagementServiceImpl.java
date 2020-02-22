package com.ecotourism.supplier.line.service.impl;

import com.ecotourism.supplier.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.line.dao.LineManagementDao;
import com.ecotourism.supplier.line.domain.LineManagementDO;
import com.ecotourism.supplier.line.service.LineManagementService;



@Service
public class LineManagementServiceImpl implements LineManagementService {
	@Autowired
	private LineManagementDao managementDao;
	
	@Override
	public LineManagementDO get(Integer id){
		return managementDao.get(id);
	}
	
	@Override
	public List<LineManagementDO> list(Map<String, Object> map){
		return managementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return managementDao.count(map);
	}
	
	@Override
	public int save(LineManagementDO management){
		return managementDao.save(management);
	}
	
	@Override
	public int update(LineManagementDO management){
		return managementDao.update(management);
	}
	
	@Override
	public int remove(Integer id){
		return managementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return managementDao.batchRemove(ids);
	}

	@Override
	public List<LineManagementDO> listLineManagement(Map<String, Object> map, String subordinateLine) {
		String[] array = null;
		if(StringUtils.isBlank(subordinateLine)){
			array =new String[0];
		}else{
			array = subordinateLine.split(",");
		}
		List<LineManagementDO> list = managementDao.list(map);
		for(LineManagementDO bean:list){
			bean.setIsCheck("false");
			for(int i=0;i<array.length;i++){
				if(bean.getLineNo().equals(array[i])){
					bean.setIsCheck("true");
				}
			}
		}
		return list;
	}

}
