package lsj.springcloud.feign.hystrix;

import lsj.springcloud.feign.HelloFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author TF016519
 * @description:
 * @date 2018-3-29 15:58
 * @version:1.0.0
 */
@Component
public class HelloFeignClientHytrixFallback implements HelloFeignClient {
    @Override
    public String hello() {
        System.out.println("hello方法的降级策略");
        return "--hello方法的降级策略--";
    }

    @Override
    public String hi() {
        System.out.println("hi方法的降级策略");
        return "--hi方法的降级策略--";
    }
}
