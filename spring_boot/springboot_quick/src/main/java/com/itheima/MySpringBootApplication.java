package com.itheima;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*申明该类是一个SpingBoot的引导类*/
@SpringBootApplication
public class MySpringBootApplication {
    //run方法，表示运行SpringBoot的引导类，run参数就是SpringBoot引导类的字节码对象
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class);
    }
}