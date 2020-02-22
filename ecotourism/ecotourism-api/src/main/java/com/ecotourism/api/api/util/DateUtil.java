package com.ecotourism.api.api.util;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.api.application.domain.ApplicationOrderDO;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/** 
 * 说明：日期处理
 * 创建人：FH Q313596790
 * 修改时间：2015年11月24日
 * @version
 */
public class DateUtil {
	/**
	 * yyyy
	 */
	public final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
	/**
	 * yyyy-MM-dd
	 */
	public final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * yyyyMMdd
	 */
	public final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * yyyyMMddHHmmss
	 */
	public final static SimpleDateFormat sdfTimes = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 获取yyyyMMddHHmmss格式
	 * @return
	 */
	public static String getSdfTimes() {
		return sdfTimes.format(new Date());
	}
	
	/**
	 * 获取YYYY格式
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}
	
	/**
	 * 获取YYYY-MM-DD格式
	 * @return
	 * @throws ParseException 
	 */
	public static String formatSdfDay(String date) throws ParseException {
		return sdfDay.format(sdfDay.parse(date));
	}
	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * @return
	 * @throws ParseException
	 */
	public static String formatsdfTimeDay(String date) throws ParseException {
		return sdfTime.format(sdfTime.parse(date));
	}

	/**
	 * 获取YYYYMMDD格式
	 * @return
	 */
	public static String getDays(){
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	/**
	* @Title: compareDate
	* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	* @author fh
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * 获取毫秒 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static long getTime(String date) {
		try {
			return sdfTime.parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 获取毫秒 yyyy-MM-dd
	 * @return
	 */
	public static long getsdfDayTime(String date) {
		try {
			return sdfDay.parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 格式化日期
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 格式化日期yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date fomatSdfTimeDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取时间传差 yyyy-MM-dd HH:mm:ss
	 * @return 时间戳差值
	 */
	public static long getTimeDifference(String starTime,String endTime){
		long startime = fomatSdfTimeDate(starTime).getTime();
		long endtime = fomatSdfTimeDate(endTime).getTime();
		return Math.abs(endtime-startime);
	}


	/**
	 * 格式化日期
	 * @return
	 */
	public static String fomatDateTime(Date date) {
		try {
			return sdfTime.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期
	 * @return
	 */
	public static String fomatDate(Date date) {
		try {
			return sdfDay.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	
	/**
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//long aa=0;
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	 
	/**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }

	/**
	 * <li>功能描述：时间相减得到天数
	 * @param endDateStr
	 * @return
	 * long
	 * @author Administrator
	 */
	public static long getDaySub(Date endDateStr){
		long day=0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(getDay());
			endDate= format.parse(fomatDate(endDateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day=(beginDate.getTime()-endDate.getTime())/(24*60*60*1000);
		//System.out.println("相隔的天数="+day);

		return day;
	}
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    /**
     * 获取当天加上自定义 HH:mm:ss 格式的时间
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date getNowDateOrder(String pattern) throws ParseException
    {
  	  String day = getDay() +" "+pattern;
  	  return sdfTime.parse(day);
    }
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        return dateStr;
    }
    /**
	 * 获取n天后的日期
	 * @param n
	 * @return
	 */
	public static String getDate(int n){
		  Calendar calendar1 = Calendar.getInstance();
		  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		  calendar1.add(Calendar.DATE,n);
		  return sdf1.format(calendar1.getTime());
	}
	/**
	 * 获取指定日期n天后的日期
	 * @param n
	 * @return
	 * @throws ParseException 
	 */
	public static String getDateByDay(int n,String date) throws ParseException{
		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		calendar1.setTime(sdf1.parse(date));
		calendar1.add(Calendar.DATE,n);
		return sdf1.format(calendar1.getTime());
	}
	
	
	/**
	 * 获取n天前的月份
	 * @param n
	 * @return
	 */
	public static String getMonth(int n){
		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
		calendar1.add(Calendar.MONTH,n);
		return sdf1.format(calendar1.getTime());
	}
	/**
	 * 获取昨天到前第n天的日期段：2017-09-20，2017-09-21...
	 * @param n
	 * @return
	 * @throws ParseException
	 */
	public static List<String> findDates(int n) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dBegin = sdf.parse(getDate(-n-1));
		Date dEnd = sdf.parse(getDate(-1));
		List<String> lDate = new ArrayList<String>();
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(sdf.format(calBegin.getTime()));
		}
		return lDate;
	}
	/**
	 * 获取日期段：2017-09-20，2017-09-21...
	 * @param
	 * @return
	 * @throws ParseException
	 */
	public static List<String> findDates(String startDate,String endDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isBlank(startDate)){
			startDate = getDate(-31);
		}
		if(StringUtils.isBlank(endDate)){
			endDate = getDay();
		}
		Date dBegin = sdf.parse(startDate);
		Date dEnd = sdf.parse(endDate);
		List<String> lDate = new ArrayList<String>();
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		lDate.add(sdf.format(dBegin.getTime()));
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(sdf.format(calBegin.getTime()));
		}
		return lDate;
	}
	
	public static String getDateName(long time){
		String sb = "";
		long second = time/1000;
		 if(second>=60){
			long branch =  second/60;//分
			if(branch>=60){
				long hour =  branch/60;//小时
				if(hour>=24){
					long day = hour/24;//天
					sb = day+"天"+(hour-day*24)+"小时"+(branch -hour*60)+"分钟"+(second-branch*60)+"秒";
				}else{
					if((branch -hour*60)==0 && (second-branch*60)==0){
						sb = hour+"小时";
					}else if((branch -hour*60)!=0 && (second-branch*60)==0){
						sb = hour+"小时"+(branch -hour*60)+"分钟";
					}else if((branch -hour*60)!=0 && (second-branch*60)!=0){
						sb = hour+"小时"+(branch -hour*60)+"分钟"+(second-branch*60)+"秒";
					}else if((branch -hour*60) ==0 && (second-branch*60)!=0){
						sb = hour+"小时"+(second-branch*60)+"秒";
					}else{
						sb = hour+"小时"+(branch -hour*60)+"分钟"+(second-branch*60)+"秒";
					}
				}
			}else{
				second = second-branch*60;
				if(second==0){
					sb = branch+"分钟";
				}else{
					sb = branch+"分钟"+second+"秒";
				}
			}
		 }else{
			 sb = second+"秒";
		 }
		return sb;
	}
	/**
	 * 获取当前日期是星期几<br>
	 *
	 * @param date 星期编码
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date date) {
		//String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		String[] weekDays = { "025007", "025001", "025002", "025003", "025004", "025005", "025006" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	public static void main(String[] args) throws ParseException {
    	/*System.out.println(DateUtil.getDaySub("2017-10-01 10:34:23", DateUtil.getDay()));
    	System.out.println(findDates("2017-10-01 10:34:23", "2017-10-20 10:34:23"));
    	System.out.println(getDate(2));
    	System.out.println(getDateByDay(2,"2017-10-01"));
    	System.out.println(DateUtil.getWeekOfDate(new Date()));*/
		ApplicationOrderDO applicationOrderDO = new ApplicationOrderDO();
		applicationOrderDO.setCustomerName("1241");
		applicationOrderDO.setOrderStatus("qwrqw");
		applicationOrderDO.setOmsResult("omsresult");
		System.out.println(JSONObject.toJSONString(applicationOrderDO));
    }

}
