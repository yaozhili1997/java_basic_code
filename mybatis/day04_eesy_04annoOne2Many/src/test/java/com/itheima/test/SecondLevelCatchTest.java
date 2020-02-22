package com.itheima.test;

import com.itheima.dao.IAccountDao;
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

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-22 11:06
 **/
public class SecondLevelCatchTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao iUserDao;

    @Before
    public void init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession();
        iUserDao=session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        in.close();
    }

    @Test
    public void testFindOne(){
        User user=iUserDao.findById(46);
        System.out.println(user);
        //释放一级缓存
        session.close();
        SqlSession session1=factory.openSession();
        IUserDao iUserDao1=session1.getMapper(IUserDao.class);
        User user1=iUserDao1.findById(46);
        System.out.println(user1);
        session1.close();

    }

}