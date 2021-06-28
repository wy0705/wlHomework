package dao;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByidUser(int id){
        final User user=new User();
        String sql="select name,password,math,chinese,english from user where id=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setName(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setMath(resultSet.getInt(3));
                user.setChinese(resultSet.getInt(4));
                user.setEnglish(resultSet.getInt(5));
            }
        });
        return user;
    }

    public User findBynameUser(String name){
        final User user=new User();
        String sql="select name,password,math,chinese,english from user where name=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setName(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setMath(resultSet.getInt(3));
                user.setChinese(resultSet.getInt(4));
                user.setEnglish(resultSet.getInt(5));
            }
        });
        return user;
    }

    public int insertUser(User user){
        String sql="insert into user(name,password,math,chinese,english) value(?,?,?,?,?)";
        return jdbcTemplate.update(sql, user.getName(),user.getPassword(),user.getMath(),user.getChinese(),user.getEnglish());
    }

    public int updateUser(User user){
        String sql="update user set name=? password=? math=? chinese=? english=? where id=?";
        return jdbcTemplate.update(sql,user.getName(),user.getPassword(),user.getPassword(),user.getMath(),user.getChinese(),user.getEnglish(),user.getId());
    }
}
