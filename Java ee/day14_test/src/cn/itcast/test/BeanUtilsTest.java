package cn.itcast.test;

import cn.itcast.domin.User;
import org.apache.commons.beanutils.BeanUtils;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-01-27 13:22
 **/
public class BeanUtilsTest {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        BeanUtils.setProperty(user,"username","zhangsan");
        System.out.println(user);
    }
}