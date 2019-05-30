package pro.sunhao.service1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pro.sunhao.service1.Exception.DataBaseException;
import pro.sunhao.service1.dao.UserDao;
import pro.sunhao.service1.pojo.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUserAll() {
        userDao.findAll();
        return userDao.findAll();
    }

    @Override
    public Page findUserAll(int page, int size) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "userUsername"));
        Pageable pageable = new PageRequest(page, size, sort);
        return userDao.findAll(pageable);
    }

    @Override
    public List<User> findUserByUsername(String username) {
        return userDao.findByUserUsername(username);
    }

    @Transactional
    @Override
    public boolean saveUser(User user) throws DataBaseException {
        boolean saveUserSuccess = false;
        try {
            if(findUserByUsername(user.getUserUsername()).isEmpty()) {
                userDao.save(user);
                saveUserSuccess = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new DataBaseException("database error and rollback");
        }
        return saveUserSuccess;
    }

    @Transactional
    @Override
    public boolean deleteUserByUsername(String username) throws DataBaseException {
        boolean deleteSuccess = false;
        try {
            List<User> userList = findUserByUsername(username);
            if(userList.size() == 1) {
                userDao.delete(userList);
                deleteSuccess = true;
            }
        } catch (Exception e) {
            throw new DataBaseException("database error and rollback");
        }
        return deleteSuccess;
    }

    @Transactional
    @Override
    public boolean updatePasswordByUsername(String username, String password) throws DataBaseException {
        boolean updateSuccess = false;
        try {
            if(userDao.updateUserPasswordByUserUsername(username, password) > 0) {
                updateSuccess = true;
            }
        } catch (Exception e) {
            throw new DataBaseException("database error and rollback");
        }
        return updateSuccess;
    }

}
