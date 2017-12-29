package cc.comac.springcloud.zipkinservicemiya;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Slf4j
public class ZipkinServiceMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServiceMiyaApplication.class, args);
	}

    @RequestMapping("/hi")
    public String home() {
	    log.info("hi is being called.");
	    return "hi, i'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
	    log.info("info is being called.");
	    return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

    @Autowired
    RestTemplate restTemplate;

	@Bean
    RestTemplate getRestTemplate() {
	    return new RestTemplate();
    }

    @Bean
    public AlwaysSampler defaultSampler() {
	    return new AlwaysSampler();
    }
}
