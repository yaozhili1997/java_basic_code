package com.ecotourism.supplier.sms.service;

import com.ecotourism.supplier.sms.domain.QrcodeFileDO;

import java.util.List;
import java.util.Map;

/**
 * 短信二维码图片保存路径
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public interface QrcodeFileService {
	
	QrcodeFileDO get(Integer id);
	
	List<QrcodeFileDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(QrcodeFileDO qrcodeFile);
	
	int update(QrcodeFileDO qrcodeFile);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
