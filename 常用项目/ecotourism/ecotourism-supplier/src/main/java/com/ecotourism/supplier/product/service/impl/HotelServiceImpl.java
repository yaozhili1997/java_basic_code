package com.ecotourism.supplier.product.service.impl;

import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.common.utils.StringUtils;
import com.ecotourism.supplier.img.domain.ImgDO;
import com.ecotourism.supplier.img.service.ImgService;
import com.ecotourism.supplier.product.dao.HotelDao;
import com.ecotourism.supplier.product.domain.HotelDO;
import com.ecotourism.supplier.product.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private ImgService imgService;
	@Override
	public HotelDO get(Integer productId){
		return hotelDao.get(productId);
	}

	@Override
	public List<HotelDO> list(Map<String, Object> map){
		List<HotelDO> list = hotelDao.list(map);
		dictService.buildDictName(list);
		return list;
	}

	@Override
	public int count(Map<String, Object> map){
		return hotelDao.count(map);
	}

	@Override
	public R save(HotelDO hotel, MultipartFile img, MultipartFile[] files){
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			hotel.setImgUrl(imgDO.getImgUrl());
		}
		imgDO = imgService.uplodeImg(files,hotel.getProductNo());
		if(hotelDao.save(hotel)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public R update(HotelDO hotel, MultipartFile img, MultipartFile[] files){
		HotelDO hotelDO = get(hotel.getProductId());
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			imgService.deleteImg(hotelDO.getImgUrl());
			hotel.setImgUrl(imgDO.getImgUrl());
		}
		if(files!=null && files[0] !=null && !files[0].isEmpty()){
			String productNo = hotelDO.getProductNo();
			imgService.deleteImgs(productNo);
			imgService.uplodeImg(files,productNo);
		}
		if(hotelDao.update(hotel)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public int remove(Integer productId){
		return hotelDao.remove(productId);
	}

	@Override
	public int batchRemove(Integer[] productIds){
		return hotelDao.batchRemove(productIds);
	}

	@Override
	public List<DictDO> list(List<DictDO> list, HotelDO hotel) {
		String payType = hotel.getPayType();
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
