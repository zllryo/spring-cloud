package com.ryo.apigeteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessZuulFilter extends ZuulFilter {


    private final Logger logger=LoggerFactory.getLogger(AccessZuulFilter.class);

    /*
    *
    * 定义filter的类型，有pre、route、post、error四种
    * */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
    *
    * 定义filter的顺序，数字越小表示顺序越高，越先执行
    * */
    @Override
    public int filterOrder() {
        return 0;
    }

    /*
    *
    * 表示是否需要执行该filter，true表示执行，false表示不执行
    * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
    *
    * filter需要执行的具体操作
    * */
    @Override
    public Object run() {
        RequestContext requestContext=RequestContext.getCurrentContext();;
        HttpServletRequest request=requestContext.getRequest();
        String token=request.getParameter("token");
        logger.info("token:"+token);
        System.out.println(token);
        //if(StringUtils.isNotBlank(token))
        {
            requestContext.setSendZuulResponse(true); //对请求进行路由
            requestContext.setResponseStatusCode(200);
            requestContext.set("isSuccess", true);
            return null;
        }
       /* else
        {
            requestContext.setSendZuulResponse(false); //不对其进行路由
            requestContext.setResponseStatusCode(400);
            requestContext.setResponseBody("token is empty");
            requestContext.set("isSuccess", false);
            return null;
        }*/
    }
}
