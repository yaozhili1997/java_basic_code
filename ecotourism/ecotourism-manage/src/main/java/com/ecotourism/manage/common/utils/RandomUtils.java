package com.ecotourism.manage.common.utils;

import java.util.Date;
import java.util.Random;

public class RandomUtils {
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
     * 生成结算单编号
     * @return
     */
    public static String getSettlementNo(String orderDistributor) {
        String code = "JS-"+orderDistributor+"-"+new Date().getTime();
        return code;
    }
}
