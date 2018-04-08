package lsj.springcloud.service.api;

import lsj.springcloud.feign.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TF016519
 * @description:
 * @date 2018-3-29 15:44
 * @version:1.0.0
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloFeignClient helloFeignClient;

    @RequestMapping (value = "hello", method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        return helloFeignClient.hello();
    }

    @RequestMapping (value = "hi", method = RequestMethod.GET)
    public String hi() throws InterruptedException {
        return helloFeignClient.hi();
    }

}
