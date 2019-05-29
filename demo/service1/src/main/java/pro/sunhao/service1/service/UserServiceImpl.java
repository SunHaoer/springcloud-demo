package pro.sunhao.service1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.service1.dao.UserDao;
import pro.sunhao.service1.pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        boolean deleteSuccess = false;
        User user = findUserByUsername(username);
        if(user != null) {
            userDao.delete(user);
            deleteSuccess = true;
        }
        return deleteSuccess;
    }

}
