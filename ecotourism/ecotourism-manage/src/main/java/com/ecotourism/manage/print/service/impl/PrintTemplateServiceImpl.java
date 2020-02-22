package com.ecotourism.manage.print.service.impl;

import com.ecotourism.manage.common.config.Constant;
import com.ecotourism.manage.common.domain.ScheduleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.print.dao.PrintTemplateDao;
import com.ecotourism.manage.print.domain.PrintTemplateDO;
import com.ecotourism.manage.print.service.PrintTemplateService;



@Service
public class PrintTemplateServiceImpl implements PrintTemplateService {
	@Autowired
	private PrintTemplateDao printTemplateDao;
	
	@Override
	public PrintTemplateDO get(Integer id){
		return printTemplateDao.get(id);
	}
	
	@Override
	public List<PrintTemplateDO> list(Map<String, Object> map){
		return printTemplateDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return printTemplateDao.count(map);
	}
	
	@Override
	public int save(PrintTemplateDO printTemplate){
		return printTemplateDao.save(printTemplate);
	}
	
	@Override
	public int update(PrintTemplateDO printTemplate){
		return printTemplateDao.update(printTemplate);
	}

	@Override
	public void changeStatus(int id, String cmd) {
		PrintTemplateDO printTemplateDO = get(id);
		if (printTemplateDO == null) {
			return;
		}
		if (Constant.STATUS_RUNNING_STOP.equals(cmd)) {
			printTemplateDO.setStatus(ScheduleJob.STATUS_NOT_RUNNING);
		} else {
			if (!Constant.STATUS_RUNNING_START.equals(cmd)) {
			} else {
				printTemplateDO.setStatus(ScheduleJob.STATUS_RUNNING);
			}
		}
		update(printTemplateDO);
	}
	
}
