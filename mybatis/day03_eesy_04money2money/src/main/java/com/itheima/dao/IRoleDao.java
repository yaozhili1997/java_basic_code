package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-17 23:22
 **/
public interface IRoleDao {
    List<Role>findAll();
}