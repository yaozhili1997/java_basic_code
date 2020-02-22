package com.ecotourism.supplier.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.sms.dao.TemplateDao;
import com.ecotourism.supplier.sms.domain.TemplateDO;
import com.ecotourism.supplier.sms.service.TemplateService;



@Service
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	private TemplateDao templateDao;
	
	@Override
	public TemplateDO get(Integer templateId){
		return templateDao.get(templateId);
	}
	
	@Override
	public List<TemplateDO> list(Map<String, Object> map){
		return templateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return templateDao.count(map);
	}
	
	@Override
	public int save(TemplateDO template){
		return templateDao.save(template);
	}
	
	@Override
	public int update(TemplateDO template){
		return templateDao.update(template);
	}
	
	@Override
	public int remove(Integer templateId){
		return templateDao.remove(templateId);
	}
	
	@Override
	public int batchRemove(Integer[] templateIds){
		return templateDao.batchRemove(templateIds);
	}
	
}
