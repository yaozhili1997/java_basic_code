package com.itheima.test;

import com.itheima.dao.IUserDao;
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
 * @create: 2020-02-20 22:41
 **/
public class AnnouctionCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws IOException {
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
         factory = new SqlSessionFactoryBuilder().build(in);
         session=factory.openSession();
         userDao=session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }
    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("annotation");
        user.setAddress("攀枝花市机场路");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(42);
        user.setUsername("annotation");
        user.setAddress("攀枝花市机场路");
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.upDateUser(user);
    }
    @Test
    public void testDelete(){
        userDao.deleteUser(56);
    }

    @Test
    public void testFindById(){
        User user = userDao.findById(42);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> users= userDao.findByName("老");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }

}