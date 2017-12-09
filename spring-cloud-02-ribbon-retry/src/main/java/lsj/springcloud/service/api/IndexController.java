package lsj.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 13:04
 * @version:1.0.0
 */
@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/retry", method = {RequestMethod.GET})
    public String retry (){
        ResponseEntity<String> response = restTemplate.getForEntity("http://client-service/retry", String.class, "001");
        String body = response.getBody();
        System.err.println("retry:" + body);
        return "------------------"+body;
    }


}
