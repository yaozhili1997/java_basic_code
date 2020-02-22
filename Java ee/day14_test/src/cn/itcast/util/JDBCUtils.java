package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description:
 * @author: 姚志立
 * @create: 2020-01-26 21:25
 **/
public class JDBCUtils {
    private static DataSource ds;
    /*
    * 获取连接池对象
    * */
    public static DataSource getDataSource(){
        return ds;
    }
    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader加载配置文件，获取直接输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDateSource(){
        return ds;
    }

    /*
    * 获取Connection对象
    * */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}