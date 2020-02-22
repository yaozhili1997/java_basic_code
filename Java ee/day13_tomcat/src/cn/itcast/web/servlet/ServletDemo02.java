package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/*
* Servlet的快速入门
* */
public class ServletDemo02 implements Servlet {
    /*
    * 初始化方法
    * 在Servlet创建时，只会执行一次
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.....");
    }

    /*
    * 获取ServletConfig对象
    * ServletConfig：Servlet的配置对象
    * */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
    * 提供服务的方法
    * 每一次Servlet被访问时，执行。执行多次
    * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet....");
    }

    /*
    * 获取Servlet的一些信息，版本，作者
    * */
    @Override
    public String getServletInfo() {
        return null;
    }
    /*
    * 销毁方法
    * 在服务器正常执行时，执行，执行一次
    * */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
