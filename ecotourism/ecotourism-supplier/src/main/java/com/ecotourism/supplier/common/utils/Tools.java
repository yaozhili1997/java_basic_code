package com.ecotourism.supplier.common.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * 说明：常用工具
 * 创建人：FH Q313596790
 * 修改时间：2015年11月24日
 * @version
 */
public class Tools {
	
	/**
	 * 随机生成六位数验证码 
	 * @return
	 */
	public static int getRandomNum(){
		 Random r = new Random();
		 return r.nextInt(900000)+100000;//(Math.random()*(999999-100000)+100000)
	}
	public static String getString(Object obj){
		return obj==null?"":obj.toString();
	}
	/**
     * 生成n位随机数 param codeLength(多少位)
     * @return
     */
    public static String getRandomString(int codeLength) {
        String code = "";
        for (int i = 0; i < codeLength; i++) {
            code += (int) (Math.random() * 9);
        }
        return code;
    }
	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s){
		return s!=null && !"".equals(s) && !"null".equals(s);
	}
	
	/**
	 * 检测字符串是否为空(null,"","null")
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s){
		return s==null || "".equals(s) || "null".equals(s);
	}
	
	/**
	 * 字符串转换为字符串数组
	 * @param str 字符串
	 * @param splitRegex 分隔符
	 * @return
	 */
	public static String[] str2StrArray(String str,String splitRegex){
		if(isEmpty(str)){
			return null;
		}
		return str.split(splitRegex);
	}
	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * @param str	字符串
	 * @return
	 */
	public static String[] str2StrArray(String str){
		return str2StrArray(str,",\\s*");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String date2Str(Date date){
		return date2Str(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date){
		if(notEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		}else{
			return null;
		}
	}
	
	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}
	
	/**
	 * 把时间根据时、分、秒转换为时间段
	 * @param StrDate
	 */
	public static String getTimes(String StrDate){
		String resultTimes = "";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now;

	    try {
	    	now = new Date();
	    	Date date=df.parse(StrDate);
	    	long times = now.getTime()-date.getTime();
	    	long day  =  times/(24*60*60*1000);
	    	long hour = (times/(60*60*1000)-day*24);
	    	long min  = ((times/(60*1000))-day*24*60-hour*60);
	    	long sec  = (times/1000-day*24*60*60-hour*60*60-min*60);
	        
	    	StringBuffer sb = new StringBuffer();
	    	//sb.append("发表于：");
	    	if(hour>0 ){
	    		sb.append(hour+"小时前");
	    	} else if(min>0){
	    		sb.append(min+"分钟前");
	    	} else{
	    		sb.append(sec+"秒前");
	    	}
	    		
	    	resultTimes = sb.toString();
	    } catch (ParseException e) {
	    	e.printStackTrace();
	    }
	    
	    return resultTimes;
	}
	
	/**
	 * 写txt里的单行内容
	 * @param fileP  文件路径
	 * @param content  写入的内容
	 */
	public static void writeFile(String fileP,String content){
		String filePath = Thread.currentThread().getContextClassLoader().getResource("") +"../../";	//项目路径
		filePath = (filePath.trim() + fileP.trim()).substring(6).trim();
		if(filePath.indexOf(":") != 1){
			filePath = File.separator + filePath;
		}
		try {
	        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8);
	        BufferedWriter writer=new BufferedWriter(write);          
	        writer.write(content);      
	        writer.close(); 

	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * 验证邮箱
	  * @param email
	  * @return
	  */
	 public static boolean checkEmail(String email){
	  boolean flag = false;
	  try{
	    String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	    Pattern regex = Pattern.compile(check);
	    Matcher matcher = regex.matcher(email);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }
	
	 /**
	  * 验证手机号码
	  * @return
	  */
	 public static boolean checkMobileNumber(String mobileNumber){
	  boolean flag = false;
	  try{
	    Pattern regex = Pattern.compile("^1(3|4|5|6|7|8|9)\\d{9}$");
	    Matcher matcher = regex.matcher(mobileNumber);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }

	/**
	 * 读取txt里的单行内容
	 * @param fileP  文件路径
	 */
	public static String readTxtFile(String fileP) {
		try {
			
			String filePath = Thread.currentThread().getContextClassLoader().getResource("") +"../../";	//项目路径
			filePath = filePath.replaceAll("file:/", "");
			filePath = filePath.replaceAll("%20", " ");
			filePath = filePath.trim() + fileP.trim();
			if(filePath.indexOf(":") != 1){
				filePath = File.separator + filePath;
			}
			String encoding = "utf-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { 		// 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
				new FileInputStream(file), encoding);	// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					return lineTxt;
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件,查看此路径是否正确:"+filePath);
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
		}
		return "";
	}
	 /**
	  * 验证非负数字
	  * @return
	  */
	 public static boolean checkNumber(String number){
	  boolean flag = false;
	  try{
	    Pattern regex = Pattern.compile("^(0|[0-9]*)$");
	    Matcher matcher = regex.matcher(number);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }
	 /**
	  * 验证金额
	  * @param number
	  * @return
	  */
	 public static boolean checkMoney(String number){
		 boolean flag = false;
		 try{
			 Pattern regex = Pattern.compile("(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)");
			 Matcher matcher = regex.matcher(number);
			 flag = matcher.matches();
		 }catch(Exception e){
			 flag = false;
		 }
		 return flag;
	 }
	
	 /**
	  * 验证日期格式为YYYY-MM-DD的正则表达式
	  * @param StrSource
	  * @return
	  */
     public static boolean IsDate(String StrSource)
     {
    	 boolean flag = false;
		 try{
			 Pattern regex = Pattern.compile("([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))");
			 Matcher matcher = regex.matcher(StrSource);
			 flag = matcher.matches();
		 }catch(Exception e){
			 flag = false;
		 }
		 return flag;
     }
     /** 
      * 18位身份证校验,比较严格校验 
      * @author lyl 
      * @param idCard 
      * @return 
      */  
     public static boolean is18ByteIdCardComplex(String idCard){  
         Pattern pattern1 = Pattern.compile("^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$");   
         Matcher matcher = pattern1.matcher(idCard);  
         int[] prefix = new int[]{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};  
         int[] suffix = new int[]{ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 };  
         if(matcher.matches()){  
             Map<String, String> cityMap = initCityMap();  
             if(cityMap.get(idCard.substring(0,2)) == null ){  
                 return false;  
             }  
             int idCardWiSum=0; //用来保存前17位各自乖以加权因子后的总和  
             for(int i=0;i<17;i++){  
                 idCardWiSum+=Integer.valueOf(idCard.substring(i,i+1))*prefix[i];  
             }  
               
             int idCardMod=idCardWiSum%11;//计算出校验码所在数组的位置  
             String idCardLast=idCard.substring(17);//得到最后一位身份证号码  
               
             //如果等于2，则说明校验码是10，身份证号码最后一位应该是X  
             if(idCardMod==2){
                 return idCardLast.equalsIgnoreCase("x");
             }else{  
                 //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码  
                 return idCardLast.equals(suffix[idCardMod] + "");
            }  
         }  
         return false;  
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
	public static boolean isEmail(String email){
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}

	public static boolean isPhone(String phone){
		String check = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0,5-9])|(19[89]))\\d{8})$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(phone);
		return matcher.matches();
	}
	public static void main(String[] args) {
		System.out.println(is18ByteIdCardComplex("511129198901065942"));
		System.out.println(checkMobileNumber("16605560580"));
		System.out.println(isPhone("16605560580"));
	}
	
}
