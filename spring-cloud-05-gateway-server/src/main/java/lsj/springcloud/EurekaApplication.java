package lsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 17:49
 * @version:1.0.0
 */
@EnableEurekaServer//表现服务发现中心的启用
@SpringBootApplication
public class EurekaApplication {
    public static void main (String[] args){
        SpringApplication.run(EurekaApplication.class, args);
    }
}
