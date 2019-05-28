package pro.sunhao.springcloud.service2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements TestService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String callService1() {
        return restTemplate.getForObject("http://service1/service1", String.class);
    }

}
