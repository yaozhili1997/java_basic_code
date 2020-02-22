package com.ecotourism.supplier.product.service.impl;

import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.common.utils.StringUtils;
import com.ecotourism.supplier.img.domain.ImgDO;
import com.ecotourism.supplier.img.service.ImgService;
import com.ecotourism.supplier.product.dao.TeamTicketDao;
import com.ecotourism.supplier.product.domain.TeamTicketDO;
import com.ecotourism.supplier.product.service.TeamTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Service
public class TeamTicketServiceImpl implements TeamTicketService {
	@Autowired
	private TeamTicketDao teamTicketDao;
	@Autowired
	private DictService dictService;
	@Autowired
	private ImgService imgService;
	@Override
	public TeamTicketDO get(Integer productId){
		return teamTicketDao.get(productId);
	}

	@Override
	public List<TeamTicketDO> list(Map<String, Object> map){
		List<TeamTicketDO> list = teamTicketDao.list(map);
		dictService.buildDictName(list);
		return list;
	}

	@Override
	public int count(Map<String, Object> map){
		return teamTicketDao.count(map);
	}

	@Override
	public R save(TeamTicketDO teamTicket, MultipartFile img, MultipartFile[] files){
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			teamTicket.setImgUrl(imgDO.getImgUrl());
		}
		imgDO = imgService.uplodeImg(files,teamTicket.getProductNo());
		if(teamTicketDao.save(teamTicket)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public R update(TeamTicketDO teamTicket, MultipartFile img, MultipartFile[] files){
		TeamTicketDO teamTicketDO = get(teamTicket.getProductId());
		ImgDO imgDO = imgService.uplodeImg(img,false);
		if(imgDO!=null){
			imgService.deleteImg(teamTicketDO.getImgUrl());
			teamTicket.setImgUrl(imgDO.getImgUrl());
		}
		if(files!=null && files[0] !=null && !files[0].isEmpty()){
			String productNo = teamTicketDO.getProductNo();
			imgService.deleteImgs(productNo);
			imgService.uplodeImg(files,productNo);
		}
		if(teamTicketDao.update(teamTicket)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public int remove(Integer productId){
		return teamTicketDao.remove(productId);
	}

	@Override
	public int batchRemove(Integer[] productIds){
		return teamTicketDao.batchRemove(productIds);
	}

	@Override
	public List<DictDO> list(List<DictDO> list, TeamTicketDO teamTicket) {
		String payType = teamTicket.getPayType();
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
