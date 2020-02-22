package com.ecotourism.api.api.util;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.common.FieldParam;
import com.ecotourism.api.common.utils.R;
import com.ecotourism.api.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 说明：参数检测外部方法:不为空时验证
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 10:35
 **/
@Component("CheckApiParamsUtil")
public class CheckApiParamsUtil {
    private static SimpleDateFormat datesdf=new SimpleDateFormat("yyyy-MM-dd");
    private static Map<String, String> payTypeMap = new HashMap<>();
    /**
     * @Description 检测游玩时间
     * @Author scotte
     * @Date 2018/8/23 10:52
     * @Param [fieldParam]
     * @return com.ecotourism.api.common.utils.R
     */
    public static R checkPlayTime(FieldParam fieldParam){
        Object playTime = fieldParam.getValue();
        String time = playTime == null ? "" : playTime.toString();
        if(StringUtils.isBlank(time)) return R.ok();
        Pattern regex = Pattern.compile("^(\\d{4})(-)(\\d{2})(-)(\\d{2})$");
        Matcher matcher = regex.matcher(time);
        if(!matcher.matches()){
            return R.error(ApiEnum.playTimeError.msg);
        }

        String today = DateUtil.getTime();//当前时间
        long todaySdf;//现在时间(购买时间)
        long playDaySdf;//游玩时间
        try {
            todaySdf = datesdf.parse(today).getTime();
            playDaySdf = datesdf.parse(playTime==null?"":playTime.toString()).getTime();//游玩当天时间
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(ApiEnum.playTimeError.msg);
        }
        if( playDaySdf<todaySdf){//游玩时间
            return R.error(ApiEnum.buyOutTimeError.msg);
        }
        return R.ok();
    }
    /**
     * @Description 检测支付方式
     * @Author scotte
     * @Date 2018/10/31 16:38
     * @Param [fieldParam]
     * @return com.ecotourism.api.common.utils.R
     */
    public static R checkPayType(FieldParam fieldParam){
        Object payType = fieldParam.getValue();
        String type = payType == null ? "" : payType.toString();
        if(StringUtils.isBlank(type)) return R.ok();
        if(payTypeMap.isEmpty()){
            payTypeMap.put("006001","微信");
            payTypeMap.put("006002","支付宝");
        }
        if(!payTypeMap.containsKey(type)){
            return R.error(ApiEnum.payTypeError.msg);
        }
        return R.ok();
    }

    /**
     * @Description 检测产品数量
     * @Author scotte
     * @Date 2018/8/23 11:10
     * @Param [fieldParam]
     * @return com.ecotourism.api.common.utils.R
     */
    public static R checkProductNum(FieldParam fieldParam){
        Object productNum = fieldParam.getValue();
        String num = productNum == null ? "" : productNum.toString();
        if(StringUtils.isBlank(num)) return R.ok();
        if(num.contains(" ")){
            return R.error(ApiEnum.paramHasNullStr.msg);
        }
        if(Integer.valueOf(num)<1){
            return R.error(ApiEnum.productNumError.msg);
        }
        return R.ok();
    }

    /**
     * @Description 检测yyyy-MM-dd 日期格式
     * @Author scotte
     * @Date 2018/8/23 11:10
     * @Param [fieldParam]
     * @return com.ecotourism.api.common.utils.R
     */
    public static R checkSdfDate(FieldParam fieldParam){
        Object paramObj = fieldParam.getValue();
        String param = paramObj == null ? "" : paramObj.toString();
        if(StringUtils.isBlank(param)) return R.ok();
        if(param.trim().length()!=10){
            return R.error(fieldParam.getName()+":"+ApiEnum.productNumError.msg);
        }
        try {
            datesdf.parse(param);
        } catch (ParseException e) {
            e.printStackTrace();
            return R.error(fieldParam.getName()+":"+ApiEnum.productNumError.msg);
        }
        return R.ok();
    }

    /**
     * @Description 手机号检测
     * @Author scotte
     * @Date 2018/8/23 10:39
     * @Param [fieldParam]
     * @return com.ecotourism.api.common.utils.R
     */
    public static R checkPhone(FieldParam fieldParam){
        boolean flag = false;
        Object phone = fieldParam.getValue();
        String phoneNum = phone == null ? "" : phone.toString();
        if(StringUtils.isBlank(phoneNum)) return R.ok();
        try{
            Pattern regex = Pattern.compile("^1(3|4|5|6|7|8|9)\\d{9}$");
            Matcher matcher = regex.matcher(phoneNum);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        if(!flag){
            return R.error(ApiEnum.phoneNumException.msg);
        }
        return R.ok();
    }
    /**
     * 验证非负数字
     * @return
     */
    public static R checkNumber(FieldParam fieldParam){
        Object value = fieldParam.getValue();
        String number = value == null ? "" : value.toString();
        if(StringUtils.isBlank(number)) return R.ok();
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^(0|[0-9]*)$");
            Matcher matcher = regex.matcher(number);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        if(!flag){
            return R.error(fieldParam.getName()+":"+ApiEnum.numError.msg);
        }
        return R.ok();
    }
    /**
     * 18位身份证校验,比较严格校验
     * @author lyl
     * @param fieldParam
     * @return
     */
    public static R is18ByteIdCardComplex(FieldParam fieldParam){
        Object idCardVo = fieldParam.getValue();
        String idCard = idCardVo == null ? "" : idCardVo.toString();
        if(StringUtils.isBlank(idCard)) return R.ok();
        boolean flag = false;
        Pattern pattern1 = Pattern.compile("^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$");
        Matcher matcher = pattern1.matcher(idCard);
        int[] prefix = new int[]{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        int[] suffix = new int[]{ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        if(matcher.matches()){
            Map<String, String> cityMap = initCityMap();
            if(cityMap.get(idCard.substring(0,2)) == null ){
                flag= false;
            }
            int idCardWiSum=0; //用来保存前17位各自乖以加权因子后的总和
            for(int i=0;i<17;i++){
                idCardWiSum+=Integer.valueOf(idCard.substring(i,i+1))*prefix[i];
            }

            int idCardMod=idCardWiSum%11;//计算出校验码所在数组的位置
            String idCardLast=idCard.substring(17);//得到最后一位身份证号码

            //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
            if(idCardMod==2){
                if(idCardLast.equalsIgnoreCase("x")){
                    flag=  true;
                }else{
                    flag=  false;
                }
            }else{
                //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
                if(idCardLast.equals(suffix[idCardMod]+"")){
                    flag=  true;
                }else{
                    flag=  false;
                }
            }
        }
        if(!flag){
            return R.error(ApiEnum.idCarError.msg);
        }
        return R.ok();
    }

    private static Map<String, String> initCityMap(){
        Map<String, String> cityMap = new HashMap<String, String>();
        cityMap.put("11", "北京");
        cityMap.put("12", "天津");
        cityMap.put("13", "河北");
        cityMap.put("14", "山西");
        cityMap.put("15", "内蒙古");

        cityMap.put("21", "辽宁");
        cityMap.put("22", "吉林");
        cityMap.put("23", "黑龙江");

        cityMap.put("31", "上海");
        cityMap.put("32", "江苏");
        cityMap.put("33", "浙江");
        cityMap.put("34", "安徽");
        cityMap.put("35", "福建");
        cityMap.put("36", "江西");
        cityMap.put("37", "山东");

        cityMap.put("41", "河南");
        cityMap.put("42", "湖北");
        cityMap.put("43", "湖南");
        cityMap.put("44", "广东");
        cityMap.put("45", "广西");
        cityMap.put("46", "海南");

        cityMap.put("50", "重庆");
        cityMap.put("51", "四川");
        cityMap.put("52", "贵州");
        cityMap.put("53", "云南");
        cityMap.put("54", "西藏");

        cityMap.put("61", "陕西");
        cityMap.put("62", "甘肃");
        cityMap.put("63", "青海");
        cityMap.put("64", "宁夏");
        cityMap.put("65", "新疆");

        cityMap.put("71", "台湾");
        cityMap.put("81", "香港");
        cityMap.put("82", "澳门");
        cityMap.put("91", "国外");
        return cityMap;
    }
}
