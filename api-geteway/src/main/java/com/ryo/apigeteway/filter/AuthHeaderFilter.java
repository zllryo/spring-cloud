package com.ryo.apigeteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class AuthHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run()  {
        RequestContext  requestContext=RequestContext.getCurrentContext();
        requestContext.addZuulRequestHeader("Authorization","");
        return null;
    }
}
