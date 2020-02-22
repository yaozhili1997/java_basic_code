package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.QueryVo;
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
    private SqlSession session;
    private InputStream in;
    private UserDao userDao;
    @Before
    public void init()throws IOException{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        session.close();
        in.close();
    }

    @After
    public void commit(){
        //提交事务
        session.commit();
    }

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
        user.setUserName("mybatis_new22222");
        user.setUserAddress("成都市龙泉驿区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存造作前"+user);
        userDao.saveUser(user);
        System.out.println("保存造作后"+user);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setUserId(49);
        user.setUserName("mybatis_user");
        user.setUserAddress("成都市成华区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
        userDao.updateUser(user);
    }
    @Test
    public void testDelete(){
        userDao.deleteUser(48);
    }
    @Test
    public void testFindOne(){
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
//        List<User>users=userDao.findByName("%王%");
        List<User>users=userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testTotalById(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUserName("%王%");
        vo.setUser(user);
        List<User>users=userDao.findUserByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}