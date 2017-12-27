package cc.comac.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        // 由于使用@EnableDiscoveryClient注册到了Eureka服务，所以以下的服务名（SERVICE-HI）在运行时会被替换为具体的URL
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }
}
