package com.ecotourism.supplier.payment.service.impl;

import com.ecotourism.supplier.common.service.DictService;
import com.ecotourism.supplier.common.utils.ShiroUtils;
import com.ecotourism.supplier.common.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.ecotourism.supplier.payment.dao.AlipayDao;
import com.ecotourism.supplier.payment.domain.AlipayDO;
import com.ecotourism.supplier.payment.service.AlipayService;



@Service
public class AlipayServiceImpl implements AlipayService {
	@Autowired
	private AlipayDao alipayDao;
	@Autowired
	private DictService dictService;
	
	@Override
	public AlipayDO get(Long id){
		return alipayDao.get(id);
	}
	
	@Override
	public List<AlipayDO> list(Map<String, Object> map){
		List<AlipayDO> list = alipayDao.list(map);
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return alipayDao.count(map);
	}
	
	@Override
	public int save(AlipayDO alipay){
		alipay.setAlipayNo(getNo());
        alipay.setCreateTime(new Date());
		alipay.setCreateUser(ShiroUtils.getUser().getUsername());
		return alipayDao.save(alipay);
	}

	private String getNo(){
		String alipay_no = Tools.getRandomString(6);
		int countNo = alipayDao.findCountNo(alipay_no);
		if(countNo>0){
			return getNo();
		}
		return alipay_no;
    }

	@Override
	public int update(AlipayDO alipay){
		alipay.setUpdateTime(new Date());
		alipay.setUpdateUser(ShiroUtils.getUser().getUsername());
		return alipayDao.update(alipay);
	}
	
	@Override
	public int remove(Long id){
		return alipayDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return alipayDao.batchRemove(ids);
	}
	
}
