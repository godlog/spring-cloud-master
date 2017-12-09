package lsj.springcloud.service.api;

import lsj.springcloud.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 13:04
 * @version:1.0.0
 */
@RestController
public class UserController {

    @RequestMapping(value = "/getUser", method = {RequestMethod.GET})
    public User getUser(@RequestParam("id") String id) {
        System.err.println("client2------id:" + id);
        return new User(id, "zhansan", 22);
    }


    @RequestMapping(value = "/postUser", method = {RequestMethod.POST})
    public User postUser(@RequestParam("id") String id) {
        System.err.println("client2------id:" + id);
        return new User(id, "lisi", 22);
    }

    @RequestMapping(value = "/insertUser", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json;charset=UTF-8"}, method = {RequestMethod.POST})
    public User insertUser(@RequestBody User user) {
        System.err.println("client2------insert:" + user.getId());
        return user;
    }

    @RequestMapping(value = "/putUser", produces = {"application/json;charset=UTF-8"}, consumes = {"application/json;charset=UTF-8"}, method = {RequestMethod.PUT})
    public void putUser(@RequestParam("id") String id, @RequestBody User user) {
        System.err.println("client2------update:" + id);
    }

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.DELETE})
    public void deleteUser(@RequestParam("id") String id) {
        System.err.println("client2------delete:" + id);
    }

    @RequestMapping(value = "/retry", method = {RequestMethod.GET})
    public String retry (){
        System.err.println("client2------retry:");
        return "client2 retry";
    }
}
