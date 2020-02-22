/*
package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
*/
/*
* 完成登录验证的过滤器
* *//*

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取资源请求求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关资源路径
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")){
            chain.doFilter(req,resp);
        }else {
            //不包含，需要验证用户是否登录
            //3.从session中获取user
            request.getSession().getAttribute("user")
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
*/
