package com.ecotourism.manage.product.service.impl;

import com.ecotourism.manage.common.domain.DictDO;
import com.ecotourism.manage.common.service.DictService;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.common.utils.StringUtils;
import com.ecotourism.manage.img.domain.ImgDO;
import com.ecotourism.manage.img.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.product.dao.SpotTicketDao;
import com.ecotourism.manage.product.domain.SpotTicketDO;
import com.ecotourism.manage.product.service.SpotTicketService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class SpotTicketServiceImpl implements SpotTicketService {
	@Autowired
	private SpotTicketDao spotTicketDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private ImgService imgService;
	@Override
	public SpotTicketDO get(Integer productId){
		return spotTicketDao.get(productId);
	}
	
	@Override
	public List<SpotTicketDO> list(Map<String, Object> map){
		List<SpotTicketDO> list = spotTicketDao.list(map);
		dictService.buildDictName(list);
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return spotTicketDao.count(map);
	}
	
	@Override
	public R save(SpotTicketDO spotTicket, MultipartFile img, MultipartFile[] files){
			ImgDO imgDO = imgService.uplodeImg(img,false);
			if(imgDO!=null){
				spotTicket.setImgUrl(imgDO.getImgUrl());
			}
			imgDO = imgService.uplodeImg(files,spotTicket.getProductNo());
			if(spotTicketDao.save(spotTicket)>0){
				return R.ok();
			}
		return R.error();
	}
	
	@Override
	public R update(SpotTicketDO spotTicket, MultipartFile img, MultipartFile[] files){
		SpotTicketDO spotTicketDO = get(spotTicket.getProductId());
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			imgService.deleteImg(spotTicketDO.getImgUrl());
			spotTicket.setImgUrl(imgDO.getImgUrl());
		}
		if(files!=null && files[0] !=null && !files[0].isEmpty()){
			String productNo = spotTicketDO.getProductNo();
			imgService.deleteImgs(productNo);
			imgService.uplodeImg(files,productNo);
		}
		if(spotTicketDao.update(spotTicket)>0){
			return R.ok();
		}
		return R.error();
	}
	
	@Override
	public int remove(Integer productId){
		return spotTicketDao.remove(productId);
	}

	@Override
	public R changeSort(Integer productId, Integer sort) {
		SpotTicketDO spotTicket = new SpotTicketDO();
		spotTicket.setProductId(productId);
		spotTicket.setSort(sort);
		if(spotTicketDao.updateSort(spotTicket)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public int batchRemove(Integer[] productIds){
		return spotTicketDao.batchRemove(productIds);
	}

	@Override
	public List<DictDO> list(List<DictDO> list, SpotTicketDO spotTicket) {
		String payType = spotTicket.getPayType();
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
