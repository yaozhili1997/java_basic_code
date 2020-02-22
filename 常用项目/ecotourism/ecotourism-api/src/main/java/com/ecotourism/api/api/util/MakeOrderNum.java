package com.ecotourism.api.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MakeOrderNum {
	/** 
     * 锁对象，可以为任意对象 
     */  
    private static Object lockObj = "lockerOrder";  
    /** 
     * 订单号生成计数器 
     */  
    private static long orderNumCount = 0L;  
    /** 
     * 每毫秒生成订单号数量最大值 
     */  
    private static int maxPerMSECSize=1000;  
    /** 
     * 生成非重复订单号，理论上限1毫秒1000个，可扩展
     */  
    public static String makeOrderNum() {  
        try {  
            // 最终生成的订单号  
            String finOrderNum = "";  
            synchronized (lockObj) {  
                // 取系统当前时间作为订单号变量前半部分，精确到毫秒
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String dateNowStr = sdf.format(date)+"00000";
                long baseDate = Long.parseLong(dateNowStr);
                System.out.println("baseDate================"+baseDate);
                long nowLong = date.getTime()+baseDate;
                System.out.println("nowLong================"+nowLong);
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万  
                if (orderNumCount >= maxPerMSECSize) {  
                    orderNumCount = 0L;  
                }  
                //组装订单号  
                String countStr=maxPerMSECSize +orderNumCount+"";  
                finOrderNum=nowLong+countStr.substring(1);  
                orderNumCount++; 
               // System.out.println(finOrderNum + "--" + Thread.currentThread().getName() + "::" );
                return finOrderNum; 
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;
    }
    public static long encrypt(long plainText,int key)
    {
        return plainText^key;
    }
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 1000; i++) {
                Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        System.out.println("======="+makeOrderNum());
                    }
                }, "at" + i);
                t1.start();

                Thread t2 = new Thread(new Runnable() {
                    public void run() {
                        System.out.println("======="+makeOrderNum());
                    }
                }, "bt" + i);
                t2.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    
    public static String checkSixCode() {
        long st = Long.parseLong(makeOrderNum());
        long st1 = 1000000000L;
        return String.valueOf(st/st1+st%st1);
    }
    public static String getWeek(String strDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// 定义日期格式  
        Date date = null;  
        try {  
            date = format.parse(strDate);// 将字符串转换为日期  
        } catch (ParseException e) {  
            System.out.println("输入的日期格式不合理！");  
        } 
		String[] weeks = {"025007","025001","025002","025003","025004","025005","025006"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(week_index<0){
			week_index = 0;
		} 
		return weeks[week_index];
	}
    
}
