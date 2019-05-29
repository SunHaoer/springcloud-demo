package pro.sunhao.service1.service;

import pro.sunhao.service1.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getUserAll();

    User findUserByUsername(String name);

    void saveUser(User user);

    boolean deleteUserByUsername(String username);

}
