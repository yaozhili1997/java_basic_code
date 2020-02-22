package com.ecotourism.supplier.payment.service.impl;

import com.ecotourism.supplier.common.config.BootdoConfig;
import com.ecotourism.supplier.common.config.Constant;
import com.ecotourism.supplier.common.utils.FileUtil;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.common.utils.ShiroUtils;
import com.ecotourism.supplier.common.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.payment.dao.WechatMchDao;
import com.ecotourism.supplier.payment.domain.WechatMchDO;
import com.ecotourism.supplier.payment.service.WechatMchService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class WechatMchServiceImpl implements WechatMchService {
	@Autowired
	private WechatMchDao wechatMchDao;
	@Autowired
	private BootdoConfig bootdoConfig;

	@Override
	public WechatMchDO get(Integer id){
		return wechatMchDao.get(id);
	}
	
	@Override
	public List<WechatMchDO> list(Map<String, Object> map){
		return wechatMchDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wechatMchDao.count(map);
	}
	
	@Override
	public R save(WechatMchDO wechatMch, MultipartFile file){
		if(file==null || file.isEmpty()) return R.error("请上传证书文件!");
		String mchNo = getNo();
		String filePath = "cert/data/wechatmch"+mchNo+"/";
		String fileName = file.getOriginalFilename();
		try {
			FileUtil.uploadFile(file.getBytes(),bootdoConfig.getUploadPath()+filePath, fileName);
		} catch (Exception e) {
			return R.error("证书上传失败!");
		}
		wechatMch.setMchNo(mchNo);
		wechatMch.setCertLocalPath(Constant.FILE_PATH+filePath+fileName);
		wechatMch.setCreateTime(new Date());
		wechatMch.setCreateUser(ShiroUtils.getUser().getUsername());
		if(wechatMchDao.save(wechatMch)>0){
			return R.ok();
		}
		return R.error();
	}
	
	@Override
	public R update(WechatMchDO wechatMch, MultipartFile file){
		WechatMchDO wechatMchDO = get(wechatMch.getId());
		if(file !=null && !file.isEmpty()){
			String filePath = "cert/data/wechatmch"+wechatMchDO.getMchNo()+"/";
			String fileName = file.getOriginalFilename();
			try {
				FileUtil.uploadFile(file.getBytes(),bootdoConfig.getUploadPath()+filePath, fileName);
				wechatMch.setCertLocalPath(Constant.FILE_PATH+filePath+fileName);
			} catch (Exception e) {
				return R.error("证书上传失败!");
			}
		}
		wechatMch.setUpdateTime(new Date());
		wechatMch.setUpdateUser(ShiroUtils.getUser().getUsername());
		if(wechatMchDao.update(wechatMch)>0){
			return R.ok();
		}
		return R.error();
	}
	private String getNo(){
		String mchNo = Tools.getRandomString(6);
		int countNo = wechatMchDao.findCountNo(mchNo);
		if(countNo>0){
			return getNo();
		}
		return mchNo;
	}
	@Override
	public int remove(Integer id){
		return wechatMchDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wechatMchDao.batchRemove(ids);
	}
	
}
