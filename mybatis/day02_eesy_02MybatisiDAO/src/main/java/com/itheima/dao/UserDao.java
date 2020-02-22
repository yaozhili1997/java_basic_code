package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-14 16:27
 **/
public interface UserDao {
    List<User>findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findById(Integer userId);
    List<User>findByName(String username);
    int findTotal();

}