package cc.comac.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient     // 注册到Eureka服务器，以便查询已经注册的服务名
public class RibbonApplication {

	public static void main(String[] args) {

		SpringApplication.run(RibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced  // 使用@LoadBalanced 标记这个RestTemplate启用Ribbon的负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
