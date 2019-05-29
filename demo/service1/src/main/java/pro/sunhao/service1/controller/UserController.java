package pro.sunhao.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.service1.pojo.User;
import pro.sunhao.service1.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUserAll")
    public List<User> getUserAll() {
        return userService.getUserAll();
    }

    @RequestMapping("/getUserByName")
    public List<User> getUserByUsername(@RequestParam(defaultValue = "username") String username) {
        return userService.findUserByUsername(username);
    }

    @RequestMapping("/saveUser")
    public boolean saveUser(@RequestParam(defaultValue = "username") String username,
                         @RequestParam(defaultValue = "password") String password,
                         @RequestParam(defaultValue = "tel") String tel) {
        return userService.saveUser(new User(null, username, password, tel));
    }

    @RequestMapping("/deleteUserByUsername")
    public boolean deleteUserByUsername(@RequestParam(defaultValue = "username") String username) {
        return userService.deleteUserByUsername(username);
    }

    @RequestMapping("/updateUserByUsername")
    public boolean updatePasswordByUsername(@RequestParam(defaultValue = "username") String username,
                                           @RequestParam(defaultValue = "password") String password) {
        return userService.updatePasswordByUsername(username, password);
    }

}
