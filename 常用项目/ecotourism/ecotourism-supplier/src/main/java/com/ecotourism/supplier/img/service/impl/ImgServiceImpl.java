package com.ecotourism.supplier.img.service.impl;

import com.ecotourism.supplier.common.config.BootdoConfig;
import com.ecotourism.supplier.common.config.Constant;
import com.ecotourism.supplier.common.utils.FileUtil;
import com.ecotourism.supplier.common.utils.ShiroUtils;
import com.ecotourism.supplier.common.utils.StringUtils;
import com.ecotourism.supplier.system.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

import com.ecotourism.supplier.img.dao.ImgDao;
import com.ecotourism.supplier.img.domain.ImgDO;
import com.ecotourism.supplier.img.service.ImgService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImgServiceImpl implements ImgService {
	@Autowired
	private ImgDao imgDao;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Override
	public ImgDO get(Integer id){
		return imgDao.get(id);
	}
	
	@Override
	public List<ImgDO> list(Map<String, Object> map){
		return imgDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return imgDao.count(map);
	}
	
	@Override
	public int save(ImgDO img){
		return imgDao.save(img);
	}
	
	@Override
	public int update(ImgDO img){
		return imgDao.update(img);
	}
	
	@Override
	public int remove(Integer id){
		return imgDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return imgDao.batchRemove(ids);
	}

	/**
	* 上传图片 flag:是否存入img表
	* @author: chqy
	* @create: 2018/6/30 10:53
	**/
	public ImgDO uplodeImg(MultipartFile file,boolean flag){
		ImgDO img  = null;
		if(file !=null && !file.isEmpty()){
			img  = new ImgDO();
			String fileName = file.getOriginalFilename();
			String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
			String imgNo = UUID.randomUUID().toString().replaceAll("-", "");
			fileName = imgNo+"."+prefix;
			img.setImgNo(imgNo);
			img.setFileName(fileName);
			try {
				FileUtil.uploadFile(file.getBytes(),bootdoConfig.getUploadPath()+ Constant.UPDATE_LODE_PATH, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			img.setImgUrl(Constant.FILE_PATH+Constant.UPDATE_LODE_PATH+fileName);
			img.setCreateTime(new Date());
			UserDO user = ShiroUtils.getUser();
			img.setCreateUser(user.getUsername());
			img.setCompanyNo(user.getCompanyNo());
			save(img);
		}
		return img;
	}
	/**
	* 上传多图片
	* @author: chqy
	* @create: 2018/6/30 11:38
	**/
	public ImgDO uplodeImg(MultipartFile[] files,String imgNo){
		ImgDO img  = null;
		if(files!=null && files[0] !=null && !files[0].isEmpty()){
			if(StringUtils.isBlank(imgNo)){
				imgNo = UUID.randomUUID().toString().replaceAll("-", "");
			}
			UserDO user = ShiroUtils.getUser();
			for (MultipartFile file : files) {
				img  = new ImgDO();
				String fileName = file.getOriginalFilename();
				String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
				fileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+prefix;
				img.setImgNo(imgNo);
				img.setFileName(fileName);
				try {
					FileUtil.uploadFile(file.getBytes(),bootdoConfig.getUploadPath()+ Constant.UPDATE_LODE_PATH, fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				img.setImgUrl(Constant.FILE_PATH+Constant.UPDATE_LODE_PATH+fileName);
				img.setCreateTime(new Date());
				img.setCreateUser(user.getUsername());
				img.setCompanyNo(user.getCompanyNo());
				save(img);
			}
		}
		return img;
	}
    /**
    * 删除图片文件及数据库记录,根据图片编号
    * @author: chqy
    * @create: 2018/6/30 15:38
    **/
	public void deleteImgs(String imgNo){
	    if(StringUtils.isNotBlank(imgNo)){
            Map<String, Object> map = new HashMap<>();
            map.put("imgNo",imgNo);
            List<ImgDO> list = list(map);
            if(list!=null && list.size()>0){
                for (ImgDO imgDO : list) {
                    String imgUrl = imgDO.getImgUrl();
                    if(StringUtils.isNotBlank(imgUrl) && imgUrl.contains(Constant.FILE_PATH)){
                            String filePath = imgUrl.replace(Constant.FILE_PATH,bootdoConfig.getUploadPath());
                            File file = new File(filePath);
                            if(file.exists() && file.isFile()){
                                file.delete();
                            }
						remove(imgDO.getId());
					}
                }
            }
        }
    }
    /**
    *删除图片文件及数据库记录,根据图片路径
    * @author: chqy
    * @create: 2018/6/30 15:48
    **/
	public void deleteImg(String imgUrl){
	    if(StringUtils.isNotBlank(imgUrl)){
            Map<String, Object> map = new HashMap<>();
            map.put("imgUrl",imgUrl);
            List<ImgDO> list = list(map);
            if(list!=null && list.size()>0){
                for (ImgDO imgDO : list) {
                    if(StringUtils.isNotBlank(imgUrl) && imgUrl.contains(Constant.FILE_PATH)){
                            String filePath = imgUrl.replace(Constant.FILE_PATH,bootdoConfig.getUploadPath());
                            File file = new File(filePath);
                            if(file.exists() && file.isFile()){
                                file.delete();
                                remove(imgDO.getId());
                            }
                    }
                }
            }
        }
    }
}
