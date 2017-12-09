package lsj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author 16519
 * @date 2017/12/7 22:44
 * @version 1.0
 */
@EnableDiscoveryClient	//表示我是一个服务,注册到服务中心上
@SpringBootApplication
public class ConsumerApplication {

	@Bean
	@LoadBalanced //自动负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
}
