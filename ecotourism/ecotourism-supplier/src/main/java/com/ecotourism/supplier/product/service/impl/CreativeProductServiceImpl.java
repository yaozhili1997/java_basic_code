package com.ecotourism.supplier.product.service.impl;

import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.common.utils.StringUtils;
import com.ecotourism.supplier.img.domain.ImgDO;
import com.ecotourism.supplier.img.service.ImgService;
import com.ecotourism.supplier.product.dao.CreativeProductDao;
import com.ecotourism.supplier.product.domain.CreativeProductDO;
import com.ecotourism.supplier.product.service.CreativeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Service
public class CreativeProductServiceImpl implements CreativeProductService {
	@Autowired
	private CreativeProductDao creativeProductDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private ImgService imgService;
	@Override
	public CreativeProductDO get(Integer productId){
		return creativeProductDao.get(productId);
	}

	@Override
	public List<CreativeProductDO> list(Map<String, Object> map){
		List<CreativeProductDO> list = creativeProductDao.list(map);
		dictService.buildDictName(list);
		return list;
	}

	@Override
	public int count(Map<String, Object> map){
		return creativeProductDao.count(map);
	}

	@Override
	public R save(CreativeProductDO creativeProduct, MultipartFile img, MultipartFile[] files){
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			creativeProduct.setImgUrl(imgDO.getImgUrl());
		}
		imgDO = imgService.uplodeImg(files,creativeProduct.getProductNo());
		if(creativeProductDao.save(creativeProduct)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public R update(CreativeProductDO creativeProduct, MultipartFile img, MultipartFile[] files){
		CreativeProductDO creativeProductDO = get(creativeProduct.getProductId());
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			imgService.deleteImg(creativeProductDO.getImgUrl());
			creativeProduct.setImgUrl(imgDO.getImgUrl());
		}
		if(files!=null && files[0] !=null && !files[0].isEmpty()){
			String productNo = creativeProductDO.getProductNo();
			imgService.deleteImgs(productNo);
			imgService.uplodeImg(files,productNo);
		}
		if(creativeProductDao.update(creativeProduct)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public int remove(Integer productId){
		return creativeProductDao.remove(productId);
	}

	@Override
	public int batchRemove(Integer[] productIds){
		return creativeProductDao.batchRemove(productIds);
	}

	@Override
	public List<DictDO> list(List<DictDO> list, CreativeProductDO creativeProduct) {
		String payType = creativeProduct.getPayType();
		String[] array = null;
		if(StringUtils.isBlank(payType)){
			array =new String[0];
		}else{
			array = payType.split(",");
		}
		for(DictDO bean:list){
			bean.setIsCheck("false");
			for(int i=0;i<array.length;i++){
				if(bean.getValue().equals(array[i])){
					bean.setIsCheck("true");
				}
			}
		}
		return list;
	}

}
