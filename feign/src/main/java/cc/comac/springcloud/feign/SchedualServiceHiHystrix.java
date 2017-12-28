package cc.comac.springcloud.feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystrix implements ISchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry, " + name;
    }
}
