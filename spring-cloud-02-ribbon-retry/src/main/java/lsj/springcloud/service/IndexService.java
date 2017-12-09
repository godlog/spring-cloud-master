package lsj.springcloud.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author TF016519
 * @description:
 * @date 2017/12/9 15:17
 * @version:1.0.0
 */
@Service
public class IndexService {
    //方法:需要进行重试(远程调用失败的情况,再次进行调用)

    @Retryable(value = {RemoteAccessException.class}, //value 什么样的异常进行重试
            maxAttempts = 3, //重试次数
            backoff = @Backoff(delay = 5000, multiplier = 5))   //delay:间隔,多少个执行者并发的概念
    public void call() throws Exception{

        System.err.println("调用了call方法,执行-----");
        throw new RemoteAccessException("RPC调用异常");

    }

    @Recover//最最终失败的补偿
    public void recover(RemoteAccessException e){
        System.err.println("-----最终处理" + e.getMessage());
    }
}
