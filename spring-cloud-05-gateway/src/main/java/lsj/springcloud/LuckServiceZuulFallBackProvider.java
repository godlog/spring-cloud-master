package lsj.springcloud;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TF016519
 * @description:
 * @date 2018-4-3 15:44
 * @version:1.0.0
 */
@Component
public class LuckServiceZuulFallBackProvider implements FallbackProvider {

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        System.err.println("error");
        cause.printStackTrace();
        return new ClientHttpResponse() {
            //响应头
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            //响应内容
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("请求错误".getBytes());
            }

            //自定义响应的状态
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            //自定义响应的状态码
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            //状态文本信息
            @Override
            public String getStatusText() throws IOException {
                return null;
            }

            @Override
            public void close() {

            }
        };
    }

    @Override
    public String getRoute() {
        return "luck-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        System.err.println("no error");
        return new ClientHttpResponse() {
            //响应头
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            //响应内容
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("请求错误".getBytes());
            }

            //自定义响应的状态
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            //自定义响应的状态码
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            //状态文本信息
            @Override
            public String getStatusText() throws IOException {
                return null;
            }

            @Override
            public void close() {

            }
        };
    }
}
