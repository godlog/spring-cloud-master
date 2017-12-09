package lsj.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/7 22:29
 * @version:1.0.0
 */
@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){

        return "hello world";
    }

}
