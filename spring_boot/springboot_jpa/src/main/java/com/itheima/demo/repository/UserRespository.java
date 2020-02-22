package com.itheima.demo.repository;

import com.itheima.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-10 20:02
 **/
public interface UserRespository extends JpaRepository<User,Long> {
    public List<User>findAll();
}