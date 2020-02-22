package com.itheima.demo;

import com.itheima.demo.domain.User;
import com.itheima.demo.repository.UserRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-02-10 20:08
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class JpaTest {
    @Autowired
    private UserRespository userRespository;
    @Test
    public void test(){
        List<User> all = userRespository.findAll();
        System.out.println(all);

    }
}