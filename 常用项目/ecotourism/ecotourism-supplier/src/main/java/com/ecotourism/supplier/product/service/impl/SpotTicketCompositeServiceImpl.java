package com.ecotourism.supplier.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.product.dao.SpotTicketCompositeDao;
import com.ecotourism.supplier.product.domain.SpotTicketCompositeDO;
import com.ecotourism.supplier.product.service.SpotTicketCompositeService;



@Service
public class SpotTicketCompositeServiceImpl implements SpotTicketCompositeService {
	@Autowired
	private SpotTicketCompositeDao spotTicketCompositeDao;
	
	@Override
	public SpotTicketCompositeDO get(Integer id){
		return spotTicketCompositeDao.get(id);
	}
	
	@Override
	public List<SpotTicketCompositeDO> list(Map<String, Object> map){
		return spotTicketCompositeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return spotTicketCompositeDao.count(map);
	}
	
	@Override
	public int save(SpotTicketCompositeDO spotTicketComposite){
		return spotTicketCompositeDao.save(spotTicketComposite);
	}
	
	@Override
	public int update(SpotTicketCompositeDO spotTicketComposite){
		return spotTicketCompositeDao.update(spotTicketComposite);
	}
	
	@Override
	public int remove(Integer id){
		return spotTicketCompositeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return spotTicketCompositeDao.batchRemove(ids);
	}
	
}
