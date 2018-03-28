package lsj.springcloud.server;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.undertow.util.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 18:22
 * @version:1.0.0
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callHelloFallback")
    public String callHello(){
        return restTemplate.getForObject("http://client-service/hello",String.class);
    }

    public String callHelloFallback(){
        return "执行降级策略";
    }

    @HystrixCommand(fallbackMethod = "handlerFallback", ignoreExceptions = {BadRequestException.class})
    public String handler() {
        throw new RuntimeException("运行时异常");
    }

    public String handlerFallback(Throwable e){
        return e.getMessage();
    }


    @HystrixCommand(
            fallbackMethod = "handlerCallHi",
            commandKey = "hiKey",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String callHi() {
        return restTemplate.getForObject("http://client-service/hi",String.class);
    }

    public String handlerCallHi(Throwable e){
        return "执行降级策略";
    }





    @HystrixCommand(
            fallbackMethod = "handlerCallHiThread",
            commandKey = "threadKey",
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"),
                @HystrixProperty(name = "execution.isolation.strategy.maxConcurrentRequests",value = "50")
            })
    public String callHiThread() {
        return restTemplate.getForObject("http://client-service/hi",String.class);
    }

    public String callHiFallback(Throwable e){
        return "执行降级策略";
    }
}
