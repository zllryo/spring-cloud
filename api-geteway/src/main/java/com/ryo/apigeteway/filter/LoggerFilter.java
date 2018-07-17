package com.ryo.apigeteway.filter;
import brave.SpanCustomizer;
import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    SpanCustomizer span;



    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 90;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run()  {
        this.span.tag("operator", "admin");

        return null;
    }
}
