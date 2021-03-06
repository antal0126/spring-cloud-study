package cc.comac.springcloud.haconfclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HaConfClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaConfClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@RequestMapping("/hi")
	public String hi() {
		return foo;
	}
}
