package pro.sunhao.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.service1.pojo.User;
import pro.sunhao.service1.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUserAll")
    public String getUserAll() {
        List<User> userList = userService.getUserAll();
        return userList.toString();
    }

}
