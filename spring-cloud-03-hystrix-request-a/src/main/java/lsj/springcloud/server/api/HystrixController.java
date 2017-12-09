package lsj.springcloud.server.api;

import lsj.springcloud.server.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 18:20
 * @version:1.0.0
 */
@RestController
public class HystrixController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hystrix-hello", method = {RequestMethod.GET})
    public String hello() {
        return helloService.callHello();
    }

    @RequestMapping(value = "/hystrix-handler", method = {RequestMethod.GET})
    public String handler() {
        return helloService.handler();
    }

    @RequestMapping(value = "/hystrix-hi", method = {RequestMethod.GET})
    public String hi() {
        return helloService.callHi();
    }


}
