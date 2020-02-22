package com.ecotourism.supplier.information.service.impl;

import com.ecotourism.supplier.img.domain.ImgDO;
import com.ecotourism.supplier.img.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.information.dao.IndexContentDao;
import com.ecotourism.supplier.information.domain.IndexContentDO;
import com.ecotourism.supplier.information.service.IndexContentService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class IndexContentServiceImpl implements IndexContentService {
	@Autowired
	private IndexContentDao indexContentDao;
	@Autowired
	private ImgService imgService;
	
	@Override
	public IndexContentDO get(Long cid){
		return indexContentDao.get(cid);
	}
	
	@Override
	public List<IndexContentDO> list(Map<String, Object> map){
		return indexContentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return indexContentDao.count(map);
	}
	
	@Override
	public int save(IndexContentDO indexContent,MultipartFile imgFile){
		ImgDO imgDO = imgService.uplodeImg(imgFile,false);
		if(imgDO!=null){
			indexContent.setImgUrl(imgDO.getImgUrl());
		}
		return indexContentDao.save(indexContent);
	}
	
	@Override
	public int update(IndexContentDO indexContent,MultipartFile imgFile){
		ImgDO imgDO = imgService.uplodeImg(imgFile,false);
		if(imgDO!=null){
			indexContent.setImgUrl(imgDO.getImgUrl());
		}return indexContentDao.update(indexContent);
	}
	
	@Override
	public int remove(Long cid){
		return indexContentDao.remove(cid);
	}
	
	@Override
	public int batchRemove(Long[] cids){
		return indexContentDao.batchRemove(cids);
	}
	
}
