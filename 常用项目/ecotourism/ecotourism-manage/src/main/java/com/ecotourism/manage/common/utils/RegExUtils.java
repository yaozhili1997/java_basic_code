package com.ecotourism.manage.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则验证
 * @author: chqy
 * @create: 2018-07-17 11:54
 **/
public class RegExUtils {
    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X|x)$";

    /**
     * 正则表达式：验证港澳台证
     */
    public static final String REGEX_ID_HKMT = "/([A-Z]{1,2}[0-9]{6}([0-9A]))|(^[1|5|7][0-9]{6}\\([0-9Aa]\\))|([A-Z][0-9]{9})/";
    /**
     * 正则表达式：验证护照
     */
    public static final String REGEX_ID_PASSPORT = " /^1[45][0-9]{7}|([P|p|S|s]\\d{7})|([S|s|G|g]\\d{8})|([Gg|Tt|Ss|Ll|Qq|Dd|Aa|Ff]\\d{8})|([H|h|M|m]\\d{8,10})$/";
    /**
     * 正则表达式：验证军官证
     */
    public static final String REGEX_ID_COO = " /[\\u4e00-\\u9fa5](字第){1}(\\d{4,8})(号?)$/";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

    //************************************网上找的，一般难用到***********************************
    /**
     * 检查字符串中是否还有HTML标签
     */
    public static final String HTMLTAGHAS = "<(\\S*?)[^>]*>.*?</\\1>|<.*? />";
    /**
     * 检查IP是否合法
     */
    public static final String IPADRESS = "\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}";
    /**
     * 检查QQ号是否合法
     */
    public static final String QQCODE = "[1-9][0-9]{4,13}";
    /**
     * 检查邮编是否合法
     */
    public static final String POSTCODE = "[1-9]\\d{5}(?!\\d)";
    /**
     * 正整数
     */
    public static final String POSITIVE_INTEGER = "^[0-9]\\d*$";
    /**
     * 正浮点数
     */
    public static final String POSITIVE_FLOAT = "^[1-9]\\d*.\\d*|0.\\d*[0-9]\\d*$";
    /**
     * 整数或小数
     */
    public static final String POSITIVE_DOUBLE = "^[0-9]+(\\.[0-9]+)?$";
    /**
     * 年月日 2012-1-1,2012/1/1,2012.1.1
     */
    public static final String DATE_YMD = "^\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}$";

    /**
    *正则验证
    * @author: chqy
    * @create: 2018/7/17 11:57
    **/
    public static boolean checkRegEX(String regEx,String param){
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(param);
        return m.matches();
    }

}
