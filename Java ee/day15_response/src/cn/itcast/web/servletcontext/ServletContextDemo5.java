package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/ServletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过request对象获取
        ServletContext context = request.getServletContext();
        //2.获取文件的服务器路径
        String realPath = context.getRealPath("/WEB-INF/classes/a.txt");
        String realPath1 = context.getRealPath("/b.txt");
        String realPath2 = context.getRealPath("/WEB-INF/c.txt");
        File file = new File(realPath);
        System.out.println(realPath);
        System.out.println(realPath1);
        System.out.println(realPath2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
