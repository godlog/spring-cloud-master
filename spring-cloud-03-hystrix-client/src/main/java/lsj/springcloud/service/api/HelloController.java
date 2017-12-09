package lsj.springcloud.service.api;

import org.springframework.web.bind.annotation.*;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 13:04
 * @version:1.0.0
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        System.err.println("hello ---");
        return "hello hystrix";
    }

    @RequestMapping(value = "/hi", method = {RequestMethod.GET})
    public String hi() throws InterruptedException {
        Thread.sleep(3000);
        System.err.println("hi ---");
        return "hi hystrix";
    }


}
