package com.ecotourism.supplier.information.service;

import com.ecotourism.supplier.information.domain.IndexContentDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-10-24 11:55:37
 */
public interface IndexContentService {
	
	IndexContentDO get(Long cid);
	
	List<IndexContentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IndexContentDO indexContent,MultipartFile imgFile);
	
	int update(IndexContentDO indexContent,MultipartFile imgFile);
	
	int remove(Long cid);
	
	int batchRemove(Long[] cids);
}
