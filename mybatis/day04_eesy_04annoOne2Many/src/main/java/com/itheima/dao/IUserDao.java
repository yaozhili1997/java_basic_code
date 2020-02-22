package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @description:在mybatis中针对，CRUD一个有四个注解：
 * @Select @Insert @Update @Delete
 * @author: 姚志立
 * @create: 2020-02-20 21:22
 **/

public interface IUserDao {
    //查询所有用户
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",fetchType= FetchType.LAZY))
    })
    List<User> findAll();


    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    //    @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    @ResultMap("userMap")
    List<User> findByName(String userName);

}