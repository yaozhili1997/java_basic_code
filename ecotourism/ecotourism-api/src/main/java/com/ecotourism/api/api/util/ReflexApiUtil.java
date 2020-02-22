package com.ecotourism.api.api.util;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.config.ResponseType;
import com.ecotourism.api.api.domain.ReflexResultDo;
import com.ecotourism.api.api.domain.RequestVo;
import com.ecotourism.api.api.domain.api.ApiMgmtVo;
import com.ecotourism.api.api.domain.common.FieldParam;
import com.ecotourism.api.common.annotation.ApiMgmt;
import com.ecotourism.api.common.annotation.Param;
import com.ecotourism.api.common.config.ApplicationContextRegister;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 说明：接口反射工具类
 * 创建人：陈启勇
 * 创建时间: 2018/8/22 18:00
 **/
@Component
public class ReflexApiUtil {
    private static Map<String,Field> apiMap = new HashMap<String,Field>();

    public ReflexApiUtil() {
        getApiMap();
    }

    public static void buildApiResult(RequestVo requestVo){
        try
        {
            ReflexResultDo reflexResultDo = doApiService(requestVo);
            buildResponse(reflexResultDo,requestVo);
            //ApiUtils.saveApiTimeConsume(requestVo);//接口耗时记录
        }catch(Exception e){
            HttpServletResponse response = requestVo.getResponse();
            response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String message = ApiUtils.buildExceptionResult(e, requestVo);
            ApiUtils.saveException(requestVo,message);
            writer.write(message);
            writer.flush();
            writer.close();
        }
        
    }

    private static void buildResponse(ReflexResultDo reflexResultDo,RequestVo requestVo) throws IOException {
        ApiMgmt annotation = reflexResultDo.getAnnotation();
        R r = reflexResultDo.getR();
        String resultString = ApiUtils.getResultString(r, requestVo);
        HttpServletResponse response = requestVo.getResponse();
        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        PrintWriter writer = response.getWriter();
        if(annotation!=null){
            String s = annotation.responseType();
            if(ResponseType.redirect.equals(s) && R.SUCCESS.equals(r.getReturn_code())){//重定向
                response.sendRedirect(r.getObj()==null?"":r.getObj().toString());
                return;
            } else if(ResponseType.html.equals(s) && R.SUCCESS.equals(r.getReturn_code())){//返回html页面
                response.setContentType("text/html;charset=utf-8");
                writer = response.getWriter();
                writer.write((String) r.getObj());// 直接将完整的表单html输出到页面
            }else if(ResponseType.RObjSuccess.equals(s)&& R.SUCCESS.equals(r.getReturn_code())){
                writer.write(r.getObj()==null?"":r.getObj().toString());
            }else if(ResponseType.RObj.equals(s)){
                writer.write(r.getObj()==null?"":r.getObj().toString());
            }else{
                writer.write(resultString);
            }
        }else{
            writer.write(resultString);
        }
        writer.flush();
        writer.close();

    }

    /**
     * @Description 接口反射逻辑处理
     * @Author scotte
     * @Date 2018/8/29 11:09
     * @Param [requestVo]
     * @return java.lang.String
     */
    private static ReflexResultDo doApiService(RequestVo requestVo) throws NoSuchMethodException, IllegalAccessException {
        ReflexResultDo reflexResultDo = new ReflexResultDo();
        String api = requestVo.getApi();
        if(apiMap.isEmpty()) getApiMap();
        if(StringUtils.isBlank(api) || !apiMap.containsKey(api)){
            reflexResultDo.setR(R.error(ApiEnum.apiError.code,ApiEnum.apiError.msg));
            return reflexResultDo;
        }
        Field field = apiMap.get(api);
        ApiMgmt annotation = field.getAnnotation(ApiMgmt.class);
        reflexResultDo.setAnnotation(annotation);
        requestVo.setApiEnum(annotation.name());
        Class params = annotation.params();
        if(params !=Void.class){
            Object requestVoDataObject = ApiUtils.getRequestVoDataObject(requestVo, params);
            R r = ReflexApiUtil.checkByReflex(requestVoDataObject);//接口参数检测
            if(!R.SUCCESS.equals(r.getReturn_code())){
                reflexResultDo.setR(r);
                return reflexResultDo;
            }
            requestVo.setParamsVo(requestVoDataObject);
        }
        Class serviceClassName = annotation.serviceClassName();
        String serviceMethodName = annotation.serviceMethodName();
        Object bean = ApplicationContextRegister.getBean(serviceClassName);
        Method method = serviceClassName.getDeclaredMethod(serviceMethodName,annotation.serviceParams());
        R invoke = null;
        try {
            invoke = (R) method.invoke(bean, requestVo);
        } catch (InvocationTargetException e) {//捕获方法中未处理的异常
            e.printStackTrace();
            Throwable targetException = e.getTargetException();
            String s = ApiUtils.buildExceptionResult(targetException, requestVo);
            reflexResultDo.setR(ApiUtils.convertStrToR(s));
            return reflexResultDo;
        }
        reflexResultDo.setR(invoke);
        return reflexResultDo;
    }
    /**
     * @Description 获取所有api
     * @Author scotte
     * @Date 2018/8/29 11:19
     * @Param []
     * @return void
     */
    private static void getApiMap(){
        apiMap.clear();
        getApiByAnParam(ApiMgmtVo.class);
    }

    private static void getApiByAnParam(Class<?> aClass){
        if(aClass!=null){
            List<Field> fields = getFieldList(aClass);
            for (Field field : fields) {
                Class<?> aclass = field.getType();
                if(aclass !=null){
                    if(aclass ==String.class){
                        getApiMgmt(field,aClass);
                    }else{
                        getApiByAnParam(aclass);
                    }

                }
            }
        }
    }
    private static void getApiMgmt(Field field,Class<?> aClass){
        if(field!=null && aClass!=null){
            Object o = null;
            try {
                o = aClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(field.isAnnotationPresent(ApiMgmt.class)) {//判断是否字典注解
                ApiMgmt annotation = field.getAnnotation(ApiMgmt.class);
                Class serviceClassName = annotation.serviceClassName();
                String serviceMethodName = annotation.serviceMethodName();
                if(serviceClassName !=Void.class && StringUtils.isNotBlank(serviceMethodName)){
                    field.setAccessible(true);
                    String name = field.getName();
                    try {
                        name = (String) field.get(o);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    ApiEnum name1 = annotation.name();
                    apiMap.put(name,field);
                }
            }
        }
    }

    /**
     * @Description 通过反射检测参数
     * @Author scotte
     * @Date 2018/8/22 18:02
     * @Param [obj]
     * @return com.ecotourism.api.common.utils.R
     */
    public static R checkByReflex(Object obj){
        Class<?> aClass = obj.getClass();
        List<Field> declaredFields = getFieldList(aClass);
        String calssName = aClass.getName();
        Map<String, Object> map = new HashMap<String, Object>();
        String code = ApiEnum.paramsCheckError.code;
        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(Param.class)){//判断是否字典注解
                field.setAccessible(true);
                Param annotation = field.getAnnotation(Param.class);
                Object value = null;
                try {
                    value = field.get(obj);
                } catch (IllegalAccessException e) {
                }
                if(annotation.notEmpty()){//不可为空
                    if(value==null || StringUtils.isBlank(value.toString())){
                        return R.error(code,annotation.errorMsg());
                    }
                }
                String name = field.getName();
                String errorMsg = "类名("+calssName+")->字段名("+name+");";
                if(annotation.useOther() && value!=null){//使用外部方法检测
                    String otherClassName = annotation.otherClassName();
                    String otherMethodName = annotation.otherMethodName();
                    errorMsg +="外部方法类名（"+otherClassName+")->调用方法名("+otherMethodName+")";
                    if(StringUtils.isBlank(otherClassName) || StringUtils.isBlank(otherMethodName)){
                        return R.error(code,ApiEnum.OtherCalssError.msg+errorMsg).setUseMsg(false);
                    }
                    Object bean = map.get(otherClassName);
                    if(bean==null){
                        try {
                            bean = ApplicationContextRegister.getBean(otherClassName);
                            map.put(otherClassName,bean);
                        }catch (Exception e){}
                    }
                    if(bean==null || StringUtils.isBlank(bean.toString())){
                        return R.error(code,ApiEnum.OtherCalssNoBeanError.msg+errorMsg).setUseMsg(false);
                    }
                    Method method = null;
                    try {
                        method = bean.getClass().getDeclaredMethod(otherMethodName, FieldParam.class);
                    } catch (NoSuchMethodException e) {
                        return R.error(code,ApiEnum.methodNullError.msg+errorMsg).setUseMsg(false);
                    }
                    R invoke =null;
                    try {
                        FieldParam fieldParam = new FieldParam();
                        fieldParam.setName(annotation.fieldName());
                        fieldParam.setValue(value);
                        invoke = (R) method.invoke(bean, fieldParam);
                    } catch (Exception e) {
                        return R.error(code,ApiEnum.methodNullError.msg+errorMsg).setUseMsg(false);
                    }
                    if(invoke==null) return R.error(code,ApiEnum.methodReturnNullError.msg+errorMsg).setUseMsg(false);
                    if(!R.SUCCESS.equals(invoke.getReturn_code())){
                        return R.error(code,invoke.getReturn_msg());
                    }
                }
                if(annotation.isEntity() && value!=null && !annotation.useOther()){//为实体属性字段,并且未使用外部方法检测
                    if(value instanceof List){
                        List<Object> obj1 = (List<Object>) value;
                        for (Object o : obj1) {
                            R r = checkByReflex(o);
                            if(!R.SUCCESS.equals(r.getReturn_code())){
                                return r;
                            }
                        }
                    }else{
                        R r = checkByReflex(value);
                        if(!R.SUCCESS.equals(r.getReturn_code())){
                            return r;
                        }
                    }
                }
            }
        }
        return R.ok();
    }
    /**
     * @Description 获取所有成员变量，包括父类
     * @Author scotte
     * @Date 2018/8/22 22:31
     * @Param [obj]
     * @return java.lang.reflect.Field[]
     */
    public static List<Field> getFieldList(Class<?> clazz){
        if(null == clazz){
            return null;
        }
        List<Field> fieldss = new LinkedList<Field>();
        List<Field> fieldList = new LinkedList<Field>();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            /** 过滤静态属性**/
            if(Modifier.isStatic(field.getModifiers())){
                continue;
            }
            /** 过滤transient 关键字修饰的属性**/
            if(Modifier.isTransient(field.getModifiers())){
                continue;
            }
            fieldList.add(field);
        }
        /** 处理父类字段**/
        Class<?> superClass = clazz.getSuperclass();
        if(superClass.equals(Object.class)){
            return fieldList;
        }
        fieldss.addAll(getFieldList(superClass));
        fieldss.addAll(fieldList);
        return fieldss;
    }
}
