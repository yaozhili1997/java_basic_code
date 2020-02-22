package com.ecotourism.manage.base.service.impl;

import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ecotourism.manage.base.dao.TicketTypeDao;
import com.ecotourism.manage.base.domain.TicketTypeDO;
import com.ecotourism.manage.base.service.TicketTypeService;



@Service
public class TicketTypeServiceImpl implements TicketTypeService {
	@Autowired
	private TicketTypeDao ticketTypeDao;
	@Autowired
	private DictService dictService;

	@Override
	public TicketTypeDO get(Integer ticketId){
		return ticketTypeDao.get(ticketId);
	}
	
	@Override
	public List<TicketTypeDO> list(Map<String, Object> map){
		List<TicketTypeDO> list = ticketTypeDao.list(map);
		dictService.buildDictName(list);//字典转换
		return list;
	}

	@Override
	public int count(Map<String, Object> map){
		return ticketTypeDao.count(map);
	}
	
	@Override
	public R save(TicketTypeDO ticketType){
		ticketType.setCreateUser(ShiroUtils.getUser().getUsername());
		ticketType.setCreateTime(new Date());
		Map<String, Object> map = new HashMap<>();
		map.put("ticketNo",ticketType.getTicketNo());
		map.put("companyNo",ticketType.getCompanyNo());
		List<TicketTypeDO> list = ticketTypeDao.list(map);
		if(list !=null && list.size()>0){
			return  R.error("票种编号已存在!");
		}
		if(ticketTypeDao.save(ticketType)>0){
			return R.ok();
		}else {
			return R.error();
		}
	}
	
	@Override
	public R update(TicketTypeDO ticketType){
		TicketTypeDO ticketTypeDO = get(ticketType.getTicketId());
		Map<String, Object> map = new HashMap<>();
		map.put("ticketNo",ticketType.getTicketNo());
		map.put("companyNo",ticketTypeDO.getCompanyNo());
		List<TicketTypeDO> list = ticketTypeDao.list(map);
		if(list !=null && list.size()>0){
			for (TicketTypeDO typeDO : list) {
				if(!typeDO.getTicketId().equals(ticketTypeDO.getTicketId())){
					return  R.error("票种编号已存在!");
				}
			}
		}
		ticketType.setUpdateUser(ShiroUtils.getUser().getUsername());
		ticketType.setUpdateTime(new Date());
		if(ticketTypeDao.update(ticketType)>0){
			return R.ok();
		}
		return R.error();
	}
	
	@Override
	public int remove(Integer ticketId){
		return ticketTypeDao.remove(ticketId);
	}
	
	@Override
	public int batchRemove(Integer[] ticketIds){
		return ticketTypeDao.batchRemove(ticketIds);
	}
	
}
