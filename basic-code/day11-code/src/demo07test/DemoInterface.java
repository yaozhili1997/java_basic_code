package demo07test;

import java.util.ArrayList;
import java.util.List;

/*
 * java.util.List正是ArrayList所实现的接口
 * */
public class DemoInterface {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> strings = addNames(list);
//        System.out.println(list);
//        String[] arrays = {"h", "s"};
//        System.out.println(arrays[1]);//打印数组的方法
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(list.get(i));//打印集合的方法
        }
    }

    public static List<String> addNames(List<String> list) {
        list.add("迪丽热巴");
        list.add("马尔扎哈");
        return list;
    }
}
