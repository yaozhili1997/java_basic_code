package com.ecotourism.manage.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.sms.dao.QrcodeFileDao;
import com.ecotourism.manage.sms.domain.QrcodeFileDO;
import com.ecotourism.manage.sms.service.QrcodeFileService;



@Service
public class QrcodeFileServiceImpl implements QrcodeFileService {
	@Autowired
	private QrcodeFileDao qrcodeFileDao;
	
	@Override
	public QrcodeFileDO get(Integer id){
		return qrcodeFileDao.get(id);
	}
	
	@Override
	public List<QrcodeFileDO> list(Map<String, Object> map){
		return qrcodeFileDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return qrcodeFileDao.count(map);
	}
	
	@Override
	public int save(QrcodeFileDO qrcodeFile){
		return qrcodeFileDao.save(qrcodeFile);
	}
	
	@Override
	public int update(QrcodeFileDO qrcodeFile){
		return qrcodeFileDao.update(qrcodeFile);
	}
	
	@Override
	public int remove(Integer id){
		return qrcodeFileDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return qrcodeFileDao.batchRemove(ids);
	}
	
}
