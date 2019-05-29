package pro.sunhao.service1.service;

import pro.sunhao.service1.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getUserAll();

    List<User> findUserByUsername(String name);

    boolean saveUser(User user);

    boolean deleteUserByUsername(String username);

    boolean updatePasswordByUsername(String username, String tel);
}
