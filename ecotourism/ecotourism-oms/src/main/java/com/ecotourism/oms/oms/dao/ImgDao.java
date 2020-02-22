package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.ImgDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 产品图片
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-10-12 14:43:19
 */
@Mapper
public interface ImgDao {
	List<ImgDO> list(Map<String, Object> map);
}
