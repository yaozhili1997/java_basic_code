package com.ecotourism.api.pay.wechat.util;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 *说明：缓存工具类
 * @author 陈启勇
 *创建时间：2017年8月8日
 * @version
 */
public class CacheUtil {
	private static final Map<String,Object>  cache = new ConcurrentHashMap<String, Object>();
	private static final Map<String,Long>  cacheTime = new ConcurrentHashMap<String, Long>();
	private static final long clearTime = 1000*7000;//缓存时间 7000s
	/**
	 * 设置缓存
	 * @param key
	 * @param value
	 */
	public static void setCache(String key,Object value){
			cache.put(key, value);
			cacheTime.put(key,new Date().getTime());//缓存开始时间
	}
	
	
	/**
	 * 从缓存中获取对象
	 * @param key
	 * @return
	 */
	public static Object getCache(String key){
		 Object obj = null;
		 Long time = cacheTime.get(key);
		 if(null !=time){
			 long nowtime = new Date().getTime();
			 if(nowtime-time >clearTime){
				 remove(key);
			 }
			 obj = cache.get(key);
		 }
		 return obj;
	}
	/**
	 * 清除指定key值的缓存
	 * @param key
	 */
	public static void remove(String key){
		cache.remove(key);
		cacheTime.remove(key);
	}
	/**
	 * 清空缓存
	 * @param key
	 */
	public static void clear(){
			cache.clear();
			cacheTime.clear();
	}
}
