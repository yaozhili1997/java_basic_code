package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
    User findById(Integer userId);
    List<User> findByName(String username);
    List<User> findUserByVo(QueryVo vo);
    //不确定的条件查询，里面的参数不确定
    List<User>findUserByCondition(User user);
    //根据queryVo中提供的id集合，查询用户信息
    List<User>findUserInIds(QueryVo vo);
}
