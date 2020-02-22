package com.ecotourism.oms.oms.service.impl;

import com.ecotourism.oms.common.utils.PageData;
import com.ecotourism.oms.oms.dao.ConfigDao;
import com.ecotourism.oms.oms.dao.ImgDao;
import com.ecotourism.oms.oms.dao.SpotTicketDao;
import com.ecotourism.oms.oms.domain.ImgDO;
import com.ecotourism.oms.oms.domain.RequestVo;
import com.ecotourism.oms.oms.domain.SpotTicketDO;
import com.ecotourism.oms.oms.service.CommonService;
import com.ecotourism.oms.oms.service.ProductsService;
import com.ecotourism.oms.oms.domain.ConfigDO;
import com.ecotourism.oms.oms.util.Tools;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    CommonService commonService;
    @Autowired
    SpotTicketDao spotTicketDao;
    @Autowired
    ConfigDao configDao;
    @Autowired
    ImgDao imgDao;
    @Override
    public String getProductsInfo(RequestVo requestVo) {
        List<SpotTicketDO> products = getProducts(requestVo);
        List<PageData> buildList = commonService.buildProductsInfo(products,requestVo.getApiVersion());
        addImg(buildList);
        return commonService.getResultOk(requestVo,buildList);
    }

    @Override
    public List<SpotTicketDO> getProducts(RequestVo requestVo) {
        Map<String, Object> map = new HashMap<>();
        map.put("distributionChannel",requestVo.getCooperationDistributionDO().getSaleChannelCode());
        List<SpotTicketDO> list =spotTicketDao.queryProductsInfo(map);
        List<SpotTicketDO> listPd = listCooProduct(requestVo,list);
        return listPd;
    }

    /**
     * 分销商产品
     * @return
     * @throws Exception
     */
    private List<SpotTicketDO> listCooProduct(RequestVo requestVo,List<SpotTicketDO> list){
        ConfigDO configDO = configDao.get(requestVo.getDistributionNo());
        List<SpotTicketDO> listProDuct = null;
        List<SpotTicketDO> showProDucts = new ArrayList<SpotTicketDO>();
        if(configDO!=null){
            PageData pageData2 = covertProduct(list);
            String productNos = Tools.getString(pageData2, "productNos");//所有产品编号
            String PRODUCT_NO_ORDER = configDO.getProductNoOrder();
            String SHOW_NO_ORDER = configDO.getShowNoOrder();
            listProDuct = new ArrayList<SpotTicketDO>();
            if(StringUtils.isNotBlank(PRODUCT_NO_ORDER)){//排序
                String[] split = PRODUCT_NO_ORDER.split(",");
                for (String string : split) {
                    if(pageData2.containsKey(string)){
                        SpotTicketDO spotTicketDO = (SpotTicketDO) pageData2.get(string);
                        if(!listProDuct.contains(spotTicketDO)){
                            listProDuct.add(spotTicketDO);
                        }
                        productNos.replaceAll(string,"");
                    }
                }
                String[] split1 = productNos.split(",");
                for (String s : split1) {
                    if(StringUtils.isNotBlank(s)){
                        if(pageData2.containsKey(s)){
                            SpotTicketDO spotTicketDO = (SpotTicketDO) pageData2.get(s);
                            if(!listProDuct.contains(spotTicketDO)) {
                                listProDuct.add(spotTicketDO);
                            }
                        }
                    }
                }
            }else{
                listProDuct =list;
            }
            if(StringUtils.isNotBlank(SHOW_NO_ORDER)){//处理显示数据
                pageData2 = covertProduct(listProDuct);
                String[] split = SHOW_NO_ORDER.split(",");
                for (String string : split) {
                    if(pageData2.containsKey(string)){
                        SpotTicketDO spotTicketDO = (SpotTicketDO) pageData2.get(string);
                        if(!showProDucts.contains(spotTicketDO)){
                            showProDucts.add(spotTicketDO);
                        }
                    }
                }
            }
        }else{
            listProDuct = list;
        }
        if(showProDucts !=null && showProDucts.size()!=0){
            listProDuct =showProDucts;
        }
        return listProDuct;
    }

    private PageData covertProduct(List<SpotTicketDO> list){
        PageData pageData2 = new PageData();
        String productNos = "";
        if(list!=null){
            for (SpotTicketDO pageDataPro : list) {
                String productNo = pageDataPro.getProductNo();
                pageData2.put(productNo, pageDataPro);
                if("".equals(productNos)){
                    productNos+=productNo;
                }else{
                    productNos += ","+productNo;
                }
            }
        }
        pageData2.put("productNos",productNos);
        return pageData2;
    }

    /**
     * 给产品添加图片
     * @param listProDuct
     * @return
     */
    private void addImg(List<PageData> listProDuct){
        List<ImgDO> list = imgDao.list(new HashMap<>());
        Map<String, List<String>> imgs = new HashMap<String,List<String>>();
        for (ImgDO pageData : list) {
            String img_url = pageData.getImgUrl();
            String product_no = pageData.getProductNo();
            List<String> strings = imgs.get(product_no);
            if(strings==null){
                strings = new ArrayList<String>();
                strings.add(img_url);
                imgs.put(product_no,strings);
            }else{
                strings.add(img_url);
            }
        }
        for (PageData pageData : listProDuct) {
            String product_no = Tools.getString(pageData, "productNo");
            List<String> strings = imgs.get(product_no);
            if(strings !=null && strings.size()!=0){
                pageData.put("imgs",imgs.get(product_no));
            }
        }
    }

}
