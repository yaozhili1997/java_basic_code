package com.ecotourism.manage.product.service.impl;

import com.ecotourism.manage.common.domain.Tree;
import com.ecotourism.manage.common.utils.BuildTree;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.common.utils.ShiroUtils;
import com.ecotourism.manage.common.utils.StringUtils;
import com.ecotourism.manage.img.domain.ImgDO;
import com.ecotourism.manage.img.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.ecotourism.manage.product.dao.ProductTypeDao;
import com.ecotourism.manage.product.domain.ProductTypeDO;
import com.ecotourism.manage.product.service.ProductTypeService;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeDao productTypeDao;
	@Autowired
	private ImgService imgService;
	@Override
	public ProductTypeDO get(Integer id){
		return productTypeDao.get(id);
	}
	
	@Override
	public List<ProductTypeDO> list(Map<String, Object> map){
		return productTypeDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return productTypeDao.count(map);
	}
	
	@Override
	public R save(ProductTypeDO productType, MultipartFile icon, MultipartFile[] files){
		if(icon==null || icon.isEmpty()) return R.error("请上传小图标!");
		Map<String, Object> map = new HashMap<>();
		map.put("productTypeNo",productType.getProductTypeNo());
		int count = count(map);
		if(count>0){
			return R.error("类型编号重复!");
		}
		ImgDO imgDO = imgService.uplodeImg(icon,false);
		productType.setParentTypeNo("0");
        productType.setIcon(imgDO.getImgUrl());
		productType.setCreateTime(new Date());
		productType.setCreateUser(ShiroUtils.getUser().getUsername());
		imgDO = imgService.uplodeImg(files,null);
		if(imgDO!=null){
			productType.setImgNo(imgDO.getImgNo());
		}
		if(productTypeDao.save(productType)>0){
			return R.ok();
		}
		return R.error();
	}

	@Override
	public R update(ProductTypeDO productType, MultipartFile icon, MultipartFile[] files){
		ImgDO imgDO = imgService.uplodeImg(icon,false);
		ProductTypeDO productTypeDO = null;
		if(imgDO!=null){
			imgService.deleteImg(productTypeDO.getIcon());
			productType.setIcon(imgDO.getImgUrl());
			productTypeDO = get(productType.getId());
		}
		productType.setUpdateTime(new Date());
		productType.setUpdateUser(ShiroUtils.getUser().getUsername());
		imgDO = imgService.uplodeImg(files,null);
		if(imgDO!=null){
			imgService.deleteImgs(productTypeDO.getImgNo());
			productType.setImgNo(imgDO.getImgNo());
			if(productTypeDO ==null){
				productTypeDO = get(productType.getId());
			}
		}
		if(productTypeDao.update(productType)>0){
			return R.ok();
		}
		return R.error();
	}
	
	@Override
	public R remove(Integer id){
		ProductTypeDO productTypeDO = get(id);
		Map<String, Object> map = new HashMap<>();
		map.put("parentTypeNo",productTypeDO.getProductTypeNo());
		int count = count(map);
		if(count>0){
			return R.error("存在子类型，无法删除!");
		}
		if(productTypeDao.remove(id)>0){
			String icon = productTypeDO.getIcon();
			String imgNo = productTypeDO.getImgNo();
			if(StringUtils.isNotBlank(icon)){
				imgService.deleteImg(icon);
			}
			if(StringUtils.isNotBlank(imgNo)){
				imgService.deleteImgs(imgNo);
			}
			return R.ok();
		}
		return R.error();
	}
	
	@Override
	public R batchRemove(Integer[] ids){
		int count = productTypeDao.countChildrenType(ids);
		if(count>0){
			return R.error("存在子类型，无法删除!");
		}
		productTypeDao.batchRemove(ids);
		for (Integer id : ids) {
			ProductTypeDO productTypeDO = get(id);
			String icon = productTypeDO.getIcon();
			String imgNo = productTypeDO.getImgNo();
			if(StringUtils.isNotBlank(icon)){
				imgService.deleteImg(icon);
			}
			if(StringUtils.isNotBlank(imgNo)){
				imgService.deleteImgs(imgNo);
			}
		}
		return R.ok();
	}

	@Override
	public Tree<ProductTypeDO> getTree(Map<String, Object> map) {
		List<Tree<ProductTypeDO>> trees = new ArrayList<Tree<ProductTypeDO>>();
		map.put("parentTypeNo","0");
		List<ProductTypeDO> productTypes = productTypeDao.listParent(map);
		List<ProductTypeDO> productTypeDetails = productTypeDao.listChildren(map);
		for (ProductTypeDO bean : productTypes) {
			Tree<ProductTypeDO> tree = new Tree<ProductTypeDO>();
			tree.setId(bean.getProductTypeNo());
			tree.setParentId("0");
			tree.setText(bean.getProductTypeName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			state.put("mType", "dept");
			tree.setState(state);
			trees.add(tree);
		}
		for (ProductTypeDO bean : productTypeDetails) {
			Tree<ProductTypeDO> tree = new Tree<ProductTypeDO>();
			tree.setId(bean.getProductTypeNo());
			tree.setParentId(bean.getParentTypeNo());
			tree.setText(bean.getProductTypeName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			state.put("mType", "user");
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<ProductTypeDO> t = BuildTree.build(trees);
		return t;
	}
}
