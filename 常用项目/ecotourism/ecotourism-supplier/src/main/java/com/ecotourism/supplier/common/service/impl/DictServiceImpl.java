package com.ecotourism.supplier.common.service.impl;

import com.ecotourism.supplier.common.annotation.Dict;
import com.ecotourism.supplier.common.dao.DictDao;
import com.ecotourism.supplier.common.domain.DictDO;
import com.ecotourism.supplier.common.service.DictService;
import com.ecotourism.supplier.common.utils.StringUtils;
import com.ecotourism.supplier.system.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dictDao;

    @Override
    public DictDO get(Long id) {
        return dictDao.get(id);
    }

    @Override
    public List<DictDO> list(Map<String, Object> map) {
        return dictDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return dictDao.count(map);
    }

    @Override
    public int save(DictDO dict) {
        return dictDao.save(dict);
    }

    @Override
    public int update(DictDO dict) {
        DictDO dictDO = get(dict.getId());
        return dictDao.update(dict);
    }

    @Override
    public int remove(Long id) {
        DictDO dictDO = get(id);
        return dictDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return dictDao.batchRemove(ids);
    }

    @Override

    public List<DictDO> listType() {
        return dictDao.listType();
    }

    @Override
    public String getName(String type, String value,String companyNo) {
        Map<String, Object> param = new HashMap<String, Object>(16);
        param.put("type", type);
        param.put("value", value);
        param.put("companyNo", companyNo);
        String rString = dictDao.list(param).get(0).getName();
        return rString;
    }

    @Override
    public List<DictDO> getHobbyList(UserDO userDO) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "hobby");
        List<DictDO> hobbyList = dictDao.list(param);

        if (StringUtils.isNotEmpty(userDO.getHobby())) {
            String[] userHobbys = userDO.getHobby().split(";");
            for (String userHobby : userHobbys) {
                for (DictDO hobby : hobbyList) {
                    if (!Objects.equals(userHobby, hobby.getId().toString())) {
                        continue;
                    }
                    hobby.setRemarks("true");
                    break;
                }
            }
        }

        return hobbyList;
    }

    @Override
    public List<DictDO> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return dictDao.list(param);
    }

    @Override
    public List<DictDO> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        return dictDao.list(param);
    }

    @Override
    public Object buildDictName(Object obj){
       if(obj !=null){
           Map<String, String> dictDo = new HashMap<>();
           List<DictDO> map = dictDao.findlistCache();
           for (DictDO dictDO : map) {
               dictDo.put(dictDO.getTypeKey(),dictDO.getName());
           }
            if(obj instanceof List){
                List<Object> obj1 = (List<Object>) obj;
                for (Object o : obj1) {
                    convertCodeToName(o,dictDo);
                }
            }else{
                convertCodeToName(obj,dictDo);
            }
       }
        return obj;
    }

    private void convertCodeToName(Object obj,Map<String, String> dictDo){
            try {
                Class<?> aClass = obj.getClass();
                Field[] declaredFields = aClass.getDeclaredFields();
                Field companyNoField = aClass.getDeclaredField("companyNo");
                companyNoField.setAccessible(true);
                String companyNo = companyNoField.get(obj)==null?"":companyNoField.get(obj).toString();
                for (Field field : declaredFields) {
                    if(field!=null && field.isAnnotationPresent(Dict.class)){//判断是否字典注解
                        field.setAccessible(true);
                        Dict annotation = field.getAnnotation(Dict.class);
                        String dictType = annotation.value();
                        Object value = field.get(obj);
                        if(value !=null){
                            String s = dictDo.get(dictType +companyNo+ value);
                            if(StringUtils.isNotBlank(s)){
                                    field.set(obj, s);
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
