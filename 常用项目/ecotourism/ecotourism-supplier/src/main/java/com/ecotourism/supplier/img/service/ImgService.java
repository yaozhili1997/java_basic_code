package com.ecotourism.supplier.img.service;

import com.ecotourism.supplier.img.domain.ImgDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:40:19
 */
public interface ImgService {
	
	ImgDO get(Integer id);
	
	List<ImgDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ImgDO img);
	
	int update(ImgDO img);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	/**
	 * 上传图片
	 * @author: chqy
	 * @create: 2018/6/30 10:53
	 **/
    ImgDO uplodeImg(MultipartFile file,boolean flag);
	/**
	 * 上传多图片
	 * @author: chqy
	 * @create: 2018/6/30 11:38
	 **/
    ImgDO uplodeImg(MultipartFile[] files,String imgNo);
	/**
	 * 删除图片文件及数据库记录
	 * @author: chqy
	 * @create: 2018/6/30 15:38
	 **/
    void deleteImgs(String imgNo);
	/**
	 *删除图片文件及数据库记录,根据图片路径
	 * @author: chqy
	 * @create: 2018/6/30 15:48
	 **/
    void deleteImg(String imgUrl);
}
