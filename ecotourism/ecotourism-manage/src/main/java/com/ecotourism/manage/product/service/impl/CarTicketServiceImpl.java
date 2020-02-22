package com.ecotourism.manage.product.service.impl;

import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.common.utils.StringUtils;
import com.ecotourism.manage.img.domain.ImgDO;
import com.ecotourism.manage.img.service.ImgService;
import com.ecotourism.manage.product.dao.CarTicketDao;
import com.ecotourism.manage.product.domain.CarTicketDO;
import com.ecotourism.manage.product.service.CarTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Service
public class CarTicketServiceImpl implements CarTicketService {
	@Autowired
	private CarTicketDao carTicketDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private ImgService imgService;
	@Override
	public CarTicketDO get(Integer productId){
		return carTicketDao.get(productId);
	}

	@Override
	public List<CarTicketDO> list(Map<String, Object> map){
		List<CarTicketDO> list = carTicketDao.list(map);
		dictService.buildDictName(list);
		return list;
	}

	@Override
	public int count(Map<String, Object> map){
		return carTicketDao.count(map);
	}

	@Override
	public R save(CarTicketDO carTicket, MultipartFile img, MultipartFile[] files){
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			carTicket.setImgUrl(imgDO.getImgUrl());
		}
		imgDO = imgService.uplodeImg(files,carTicket.getProductNo());
		if(carTicketDao.save(carTicket)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public R update(CarTicketDO carTicket, MultipartFile img, MultipartFile[] files){
		CarTicketDO carTicketDO = get(carTicket.getProductId());
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			imgService.deleteImg(carTicketDO.getImgUrl());
			carTicket.setImgUrl(imgDO.getImgUrl());
		}
		if(files!=null && files[0] !=null && !files[0].isEmpty()){
			String productNo = carTicketDO.getProductNo();
			imgService.deleteImgs(productNo);
			imgService.uplodeImg(files,productNo);
		}
		if(carTicketDao.update(carTicket)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public int remove(Integer productId){
		return carTicketDao.remove(productId);
	}

	@Override
	public int batchRemove(Integer[] productIds){
		return carTicketDao.batchRemove(productIds);
	}

	@Override
	public List<DictDO> list(List<DictDO> list, CarTicketDO carTicket) {
		String payType = carTicket.getPayType();
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
