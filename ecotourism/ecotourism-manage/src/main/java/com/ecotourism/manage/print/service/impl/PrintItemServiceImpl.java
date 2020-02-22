package com.ecotourism.manage.print.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.print.dao.PrintItemDao;
import com.ecotourism.manage.print.domain.PrintItemDO;
import com.ecotourism.manage.print.service.PrintItemService;



@Service
public class PrintItemServiceImpl implements PrintItemService {
	@Autowired
	private PrintItemDao printItemDao;
	
	@Override
	public PrintItemDO get(String id){
		return printItemDao.get(id);
	}
	
	@Override
	public List<PrintItemDO> list(Map<String, Object> map){
		return printItemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return printItemDao.count(map);
	}
	
	@Override
	public int save(PrintItemDO printItem){
		printItem.setCreated(new Date());
		printItem.setModified(new Date());
		printItem.setType("1");
		printItem.setClassification(1);
		return printItemDao.save(printItem);
	}
	
	@Override
	public int update(PrintItemDO printItem){
		printItem.setModified(new Date());
		return printItemDao.update(printItem);
	}
	
	@Override
	public int remove(String id){
		return printItemDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return printItemDao.batchRemove(ids);
	}
	
}
