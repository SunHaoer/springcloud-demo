package pro.sunhao.springcloud.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sunhao.springcloud.service2.service.TestService;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/service2")
    public String service2(){
        return testService.callService1();
    }

}
