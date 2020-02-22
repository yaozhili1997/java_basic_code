package cn.itcast.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        //1.创建一对象，在内存中画图（验证码的图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrst0123456789";
        //创建随机角标
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //获取字符
            //写验证码
            g.drawString(ch+"",width/5*i+10,height/2);
        }
        //2.4画干扰线
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            //随机生成坐标点
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
