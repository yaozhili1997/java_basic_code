package com.itheima.demo03.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo02MyTest {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入出生日期：yyyy-MM-dd");
        String birthday = scanner.next();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(birthday);
        long time = parse.getTime();
        long time1 = date.getTime();
        long time3 =time1-time;
        System.out.println("出生的天数："+time3/1000/24/60/60);
    }
}
