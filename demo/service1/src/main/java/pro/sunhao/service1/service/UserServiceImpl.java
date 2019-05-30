package pro.sunhao.service1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pro.sunhao.service1.Exception.DataBaseException;
import pro.sunhao.service1.dao.AddressDao;
import pro.sunhao.service1.dao.UserDao;
import pro.sunhao.service1.pojo.User;
import pro.sunhao.service1.pojo.UserInfo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<User> findUserAll() throws DataBaseException {
        List<User> userList;
        try {
            userList = userDao.findUserAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("database error and rollback");
        }
        return userList;
    }

    @Override
    public Page findUserAll(int page, int size) throws DataBaseException {
        Page userPage;
        try {
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "userUsername"));
            Pageable pageable = new PageRequest(page, size, sort);
            userPage = userDao.findAll(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("database error and rollback");
        }
        return userPage;
    }

    @Override
    public List<User> findUserByUsername(String username) throws DataBaseException {
        List<User> userList;
        try {
            userList = userDao.findByUserUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("database error and rollback");
        }
        return userList;
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
            throw new DataBaseException("database error and rollback");
        }
        return updateSuccess;
    }

    @Override
    public List<UserInfo> findUserInfoAll() {
        List<UserInfo> userInfoList = new ArrayList<UserInfo>();
        try {
            List<User> userList = userDao.findAll();
            for(User user : userList) {
                UserInfo userInfo = new UserInfo(user);
                userInfo.setUserAddress(addressDao.findAddressByUserId(user.getId()));
                userInfoList.add(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("database error and rollback");
        }
        return userInfoList;
    }

}
