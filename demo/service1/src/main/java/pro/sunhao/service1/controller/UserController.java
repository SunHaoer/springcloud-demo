package pro.sunhao.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.service1.pojo.User;
import pro.sunhao.service1.pojo.UserInfo;
import pro.sunhao.service1.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findUserAll")
    public List<User> findUserAll() {
        return userService.findUserAll();
    }

    @RequestMapping("/findUserPage")
    public Page findUserAll(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size) {
        Page userPage = null;
        try {
            userPage = userService.findUserAll(page, size);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userPage;
    }

    @RequestMapping("/findUserByName")
    public List<User> findUserByUsername(@RequestParam(defaultValue = "userUsername") String username) {
        List<User> userList = null;
        try {
            userList = userService.findUserByUsername(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @RequestMapping("/saveUser")
    public boolean saveUser(@RequestParam(defaultValue = "username") String username,
                         @RequestParam(defaultValue = "password") String password,
                         @RequestParam(defaultValue = "phone") String phone) {
        boolean success = false;
        try {
            success = userService.saveUser(new User(null, username, password, phone));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return success;
    }

    @RequestMapping("/deleteUserByUsername")
    public boolean deleteUserByUsername(@RequestParam(defaultValue = "username") String username) {
        boolean success = false;
        try {
            success = userService.deleteUserByUsername(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return success;
    }

    @RequestMapping("/updateUserByUsername")
    public boolean updatePasswordByUsername(@RequestParam(defaultValue = "username") String username,
                                            @RequestParam(defaultValue = "password") String password) {
        boolean success = false;
        try {
            success = userService.updatePasswordByUsername(username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return success;
    }

    @RequestMapping("/findUserInfoAll")
    public List<UserInfo> findUserInfoAll() {
        List<UserInfo> userInfoList = null;
        try {
            userInfoList = userService.findUserInfoAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userInfoList;
    }

}
