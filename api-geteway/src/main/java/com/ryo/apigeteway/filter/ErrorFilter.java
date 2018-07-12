package com.ryo.apigeteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /*
    *
    * 异常处理必须调用SendErrorFilter，所以需要在error.status_code赋值
    * */
    @Override
    public Object run() throws ZuulException {
        RequestContext requsetContext=RequestContext.getCurrentContext();
        Throwable throwable=requsetContext.getThrowable();
        requsetContext.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        requsetContext.set("error.exception", throwable.getCause());
        return  null;
    }
}
