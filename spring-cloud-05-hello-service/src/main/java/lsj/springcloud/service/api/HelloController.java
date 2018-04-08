package lsj.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
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
public class HelloController {



    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }



}
