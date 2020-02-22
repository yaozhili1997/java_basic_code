package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码ISO-8859-1 设置为：GBK
        //response.setCharacterEncoding("GBK");
        //告诉浏览器，服务器发送的消息数据的编码，建议该浏览器使用该编码解码
        //response.setHeader("content-type","text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        PrintWriter writer = response.getWriter();
        //2.输出数据
        writer.write("<h1>hello response</h1>");
        writer.write("你好");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
