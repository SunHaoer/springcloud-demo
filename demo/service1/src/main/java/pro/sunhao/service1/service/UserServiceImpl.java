package pro.sunhao.service1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sunhao.service1.Exception.DataBaseException;
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
    public List<User> findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean saveUser(User user) {
        boolean saveUserSuccess = false;
        try {
            if(findUserByUsername(user.getUsername()).isEmpty()) {
                userDao.save(user);
                saveUserSuccess = true;
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        return saveUserSuccess;
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        boolean deleteSuccess = false;
        try {
            List<User> userList = findUserByUsername(username);
            if(userList.size() == 1) {
                userDao.delete(userList);
                deleteSuccess = true;
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        return deleteSuccess;
    }

    @Override
    public boolean updatePasswordByUsername(String username, String password) {
        boolean updateSuccess = false;
        try {
            List<User> userList = findUserByUsername(username);
            if(userList.size() == 1) {
                User user = userList.get(0);
                user.setPassword(password);
                userDao.save(user);
                updateSuccess = true;
            }
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
        return updateSuccess;
    }

}
