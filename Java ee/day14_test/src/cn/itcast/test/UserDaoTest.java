package cn.itcast.test;

import cn.itcast.Dao.UserDao;
import cn.itcast.domin.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-01-26 23:06
 **/
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);
    }

}