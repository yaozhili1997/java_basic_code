package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-14 00:04
 **/
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory=factory;
    }
    public List<User> findAll() {
        //1.使用工厂创建session对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询结果
        List<User> users = session.selectList("com.itheima.dao.UserDao.findAll");
        session.close();
        //3.返回查询结果
        return users;
    }
}