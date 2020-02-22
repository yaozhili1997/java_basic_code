package cn.itcast.Dao;

import cn.itcast.domin.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    //声明JDBCTemplate对象共用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDateSource());
    /*
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据
     * */
    public User login(User loginUser) {
        try {
            //1.编写sql
            String sql = "select * from user where username=? and password=?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
