package pro.sunhao.service1.service;

import org.springframework.data.domain.Page;
import pro.sunhao.service1.pojo.User;
import pro.sunhao.service1.pojo.UserInfo;

import java.util.List;

public interface UserService {

    List<User> findUserAll();

    Page findUserAll(int page, int size);

    List<User> findUserByUsername(String username);

    boolean saveUser(User user);

    boolean deleteUserByUsername(String username);

    boolean updatePasswordByUsername(String username, String password);

    List<UserInfo> findUserInfoAll();

}
