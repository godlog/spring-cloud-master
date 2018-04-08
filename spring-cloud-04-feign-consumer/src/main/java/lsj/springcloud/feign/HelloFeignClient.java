package lsj.springcloud.feign;

import lsj.springcloud.feign.hystrix.HelloFeignClientHytrixFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author TF016519
 * @description:
 * @date 2018-3-29 15:56
 * @version:1.0.0
 */
@FeignClient(name = "feign-provider", fallback = HelloFeignClientHytrixFallback.class)
public interface HelloFeignClient {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    String hello() ;


    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    String hi() ;

}
