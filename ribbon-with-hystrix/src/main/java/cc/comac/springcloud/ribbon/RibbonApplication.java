package cc.comac.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient     // 注册到Eureka服务器，以便查询已经注册的服务名
@EnableHystrix                 // 启用Hystrix熔断器功能，在需要使用熔断器的方法上加@HystrixCommand注解
@EnableHystrixDashboard// 启用Hystrix Dashboard
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
