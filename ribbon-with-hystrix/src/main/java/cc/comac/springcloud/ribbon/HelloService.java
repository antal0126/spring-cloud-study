package cc.comac.springcloud.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        // 由于使用@EnableDiscoveryClient注册到了Eureka服务，所以以下的服务名（SERVICE-HI）在运行时会被替换为具体的URL
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    @Autowired
    RestTemplate restTemplate;

    public String hiError(String name) {
        return "hi, " + name + ", sorry, error!";
    }
}
