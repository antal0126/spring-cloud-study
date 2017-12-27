package cc.comac.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-hi")  // 指定消费的接口的服务名
public interface ISchedualServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)  // 指定的映射须与服务名提供的接口相同
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
