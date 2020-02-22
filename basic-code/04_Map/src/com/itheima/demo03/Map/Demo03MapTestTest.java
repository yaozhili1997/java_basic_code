package com.itheima.demo03.Map;

import java.util.*;

public class Demo03MapTestTest {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        HashMap<Character, Integer> objectObjectHashMap = new HashMap<>();
        for(char c:next.toCharArray()){
            if(objectObjectHashMap.containsKey(c)){
                Integer value = objectObjectHashMap.get(c);
                value++;
                objectObjectHashMap.put(c,value);
            }else {
                objectObjectHashMap.put(c,1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = objectObjectHashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"-"+value);
        }
    }
}
