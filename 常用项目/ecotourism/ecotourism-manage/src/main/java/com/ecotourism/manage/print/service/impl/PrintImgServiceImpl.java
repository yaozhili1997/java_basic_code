package com.ecotourism.manage.print.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.print.dao.PrintImgDao;
import com.ecotourism.manage.print.domain.PrintImgDO;
import com.ecotourism.manage.print.service.PrintImgService;



@Service
public class PrintImgServiceImpl implements PrintImgService {
	@Autowired
	private PrintImgDao printImgDao;
	
	@Override
	public PrintImgDO get(Long id){
		return printImgDao.get(id);
	}
	
	@Override
	public List<PrintImgDO> list(Map<String, Object> map){
		return printImgDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return printImgDao.count(map);
	}
	
	@Override
	public int save(PrintImgDO printImg){
		return printImgDao.save(printImg);
	}
	
	@Override
	public int update(PrintImgDO printImg){
		return printImgDao.update(printImg);
	}
	
	@Override
	public int remove(Long id){
		return printImgDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return printImgDao.batchRemove(ids);
	}
	
}
