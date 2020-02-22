package com.ecotourism.manage.payment.service.impl;

import com.ecotourism.manage.common.config.BootdoConfig;
import com.ecotourism.manage.common.config.Constant;
import com.ecotourism.manage.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.manage.payment.dao.WechatProviderDao;
import com.ecotourism.manage.payment.domain.WechatProviderDO;
import com.ecotourism.manage.payment.service.WechatProviderService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class WechatProviderServiceImpl implements WechatProviderService {
	@Autowired
	private WechatProviderDao wechatProviderDao;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Override
	public WechatProviderDO get(Integer id){
		return wechatProviderDao.get(id);
	}
	
	@Override
	public List<WechatProviderDO> list(Map<String, Object> map){
		return wechatProviderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wechatProviderDao.count(map);
	}
	
	@Override
	public R save(WechatProviderDO wechatProvider, MultipartFile file){
		if(file==null || file.isEmpty()) return R.error("请上传证书文件!");
		String providerNo = getNo();
		String filePath = "cert/data/provider"+providerNo+"/";
		String fileName = file.getOriginalFilename();
		try {
			FileUtil.uploadFile(file.getBytes(),bootdoConfig.getUploadPath()+filePath, fileName);
		} catch (Exception e) {
			return R.error("证书上传失败!");
		}
		wechatProvider.setProviderNo(providerNo);
		wechatProvider.setCertLocalPath(Constant.FILE_PATH+filePath+fileName);
		wechatProvider.setCreateTime(new Date());
		wechatProvider.setCreateUser(ShiroUtils.getUser().getUsername());
		if(wechatProviderDao.save(wechatProvider)>0){
			return R.ok();
		}
		return R.error();
	}
	private String getNo(){
		String providerNo = Tools.getRandomString(6);
		int countNo = wechatProviderDao.findCountNo(providerNo);
		if(countNo>0){
			return getNo();
		}
		return providerNo;
	}
	@Override
	public R update(WechatProviderDO wechatProvider,MultipartFile file){
		WechatProviderDO wechatProviderDO = wechatProviderDao.get(wechatProvider.getId());
		if(file !=null && !file.isEmpty()){
			String filePath = "cert/data/provider"+wechatProviderDO.getProviderNo()+"/";
			String fileName = file.getOriginalFilename();
			try {
				FileUtil.uploadFile(file.getBytes(),bootdoConfig.getUploadPath()+filePath, fileName);
				wechatProvider.setCertLocalPath(Constant.FILE_PATH+filePath+fileName);
			} catch (Exception e) {
				return R.error("证书上传失败!");
			}
		}
		wechatProvider.setUpdateTime(new Date());
		wechatProvider.setUpdateUser(ShiroUtils.getUser().getUsername());
		if(wechatProviderDao.update(wechatProvider)>0){
			return R.ok();
		}
		return R.error();
	}
	
	@Override
	public int remove(Integer id){
		return wechatProviderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wechatProviderDao.batchRemove(ids);
	}
	
}
