package lsj.springcloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author TF016519
 * @description:
 * @date 2018-3-30 10:48
 * @version:1.0.0
 */
@Component
public class CustomAuthFilter extends ZuulFilter{
    /**
     *  pre:在请求被路由之前调用
     *  routing: 在请求被路由之中调用
     *  post: 在请求被路由之后调用
     *  error: 处理请求发生错误时调用
     **/
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * filter执行优先级顺序,数值越小越先执行
     **/
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行这个filter
     **/
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * filter 具体逻辑
     **/
    @Override
    public Object run() {
        RequestContext ctx =  RequestContext.getCurrentContext();
        HttpServletRequest request =  ctx.getRequest();
        String uri = request.getRequestURI();
        boolean isUploadPath = false;
        if(uri.equals("/luck-service/upload") || uri.equals("/zuul/luck-service/upload")){
            isUploadPath = true;
        }

        String token = request.getHeader("x-auth-token");
        token="12354567";
        if(StringUtils.isBlank(token) && !isUploadPath){
            System.err.println("token为空");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("---no token---");
            return null;
        } else {
          if("12354567".equals(token) || isUploadPath){
              ctx.addZuulRequestHeader("user","123");
          } else {
              ctx.setSendZuulResponse(false);
              ctx.setResponseStatusCode(401);
              ctx.setResponseBody("--- token auth fail ---");
              return null;
          }
        }
        return ctx;
    }
}
