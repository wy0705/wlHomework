package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDao userDao;

    public User findByidUser(int id){
        return userDao.findByidUser(id);
    }

    public User findBynameUser(String name){
        return userDao.findBynameUser(name);
    }

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public int updateUser(User user){
        return userDao.updateUser(user);
    }

    public boolean register(User user){
        //用户重名校验
        User user1=findByidUser(user.getId());
        if (user1!=null&&user1.getName()!=null&&user.getName().equals(user.getName())){
            return true;
        }
        user.setPassword(user.getPassword());
        return userDao.insertUser(user) != 0;
    }
}
