package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /*
    * 查询所有操作
    * */
    @Select("select * from user")
    List<User>findAll();
}
