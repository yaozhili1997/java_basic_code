package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-14 16:31
 **/
public class MybatisTest {
    private InputStream in;
    private UserDao userDao;
    @Before
    public void init()throws IOException{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂对象创建dao对象
       userDao=new UserDaoImpl(factory);
    }
    @After
    public void destory() throws IOException {

        in.close();
    }

/*    @After
    public void commit(){
        //提交事务
        session.commit();
    }*/

    @Test
    public void testFindAll()  {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() {
        User user=new User();
        user.setUsername("mydao998");
        user.setAddress("成都市龙泉驿区wwww");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存造作前"+user);
        userDao.saveUser(user);
        System.out.println("保存造作后"+user);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(49);
        user.setUsername("mybatis_user");
        user.setAddress("成都市6666");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }
    @Test
    public void testDelete(){
        userDao.deleteUser(49);
    }
    @Test
    public void testFindOne(){
        User user = userDao.findById(41);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
       List<User>users=userDao.findByName("%王%");

        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testTotalById(){
        int total = userDao.findTotal();
        System.out.println(total);
    }


}