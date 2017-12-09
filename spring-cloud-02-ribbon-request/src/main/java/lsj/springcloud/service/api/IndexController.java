package lsj.springcloud.service.api;

import lsj.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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


    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public String get() {
        ResponseEntity<User> response = restTemplate.getForEntity("http://client-service/getUser?id={1}", User.class, "001");
        User user = response.getBody();
        System.err.println("username:" + user.getName());
        return "----------get--------";
    }

    @RequestMapping(value = "/post", method = {RequestMethod.GET})
    public String post() {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.set("id", "002");
        ResponseEntity<User> response = restTemplate.postForEntity("http://client-service/postUser", form, User.class);
        User user = response.getBody();
        System.err.println("username:" + user.getName());
        return "----------post--------";
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.GET})
    public String insert() {
        User user = new User("003", "zhansan", 22);
        ResponseEntity<User> response = restTemplate.postForEntity("http://client-service/insertUser", user, User.class);
        User responseUser = response.getBody();
        System.err.println("username:" + responseUser.getName());
        return "----------insert--------";
    }



    @RequestMapping(value = "/put", method = {RequestMethod.GET})
    public String put() {
        User user = new User("003", "zhansan", 22);
        restTemplate.put("http://client-service/putUser?id={1}", user, "003");

        return "----------put--------";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public String delete() {
        restTemplate.delete("http://client-service/deleteUser?id={1}",  "003");
        return "----------delete--------";
    }


}
