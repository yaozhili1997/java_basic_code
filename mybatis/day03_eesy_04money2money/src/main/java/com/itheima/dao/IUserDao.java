package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
//查询所有用户，同时获取所有账户的信息
    List<User> findAll();
    User findById(Integer userId);

}
