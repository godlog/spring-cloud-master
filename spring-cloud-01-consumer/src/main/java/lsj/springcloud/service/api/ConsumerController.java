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
 * @date 2017/12/7 22:53
 * @version:1.0.0
 */
@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;


    /**
     * @description: http方式调用,与springcloud调用服务没有关系
     * @author 16519
     * @date 2017/12/7 22:59
     * @version 1.0
     */
    @RequestMapping(value = "/getByUrl", method = {RequestMethod.GET})
    public String getByUrl(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://provider-service/provider/hello", String.class);
        String body = response.getBody();
        System.err.println("body"+body);

        return "调用成功";
    }

    /**
     * @description: http方式调用,与springcloud调用服务没有关系
     * @author 16519
     * @date 2017/12/7 22:59
     * @version 1.0
     */
    @RequestMapping(value = "/getByAppName", method = {RequestMethod.GET})
    public String getByAppName(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://provider-service/provider/hello", String.class);
        String body = response.getBody();
        System.err.println("body"+body);

        return "调用成功";
    }
}
