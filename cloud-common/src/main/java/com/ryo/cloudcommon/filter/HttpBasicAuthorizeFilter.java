package com.ryo.cloudcommon.filter;

import com.ryo.cloudcommon.base.ResponseCode;
import com.ryo.cloudcommon.base.ResponseData;
import com.ryo.cloudcommon.util.JWTUtils;
import com.ryo.cloudcommon.util.JsonUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpBasicAuthorizeFilter implements  Filter  {
    JWTUtils jwtUtils=JWTUtils.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context=filterConfig.getServletContext();
        ApplicationContext applicationContext=WebApplicationContextUtils.getWebApplicationContext(context);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        String auth = httpRequest.getHeader("Authorization");
        //健康检查控制
        String uri = httpRequest.getRequestURI();
        if (uri.equals("/autoconfig") || uri.equals("/configprops") || uri.equals("/beans") || uri.equals("/dump")
                || uri.equals("/env") || uri.equals("/health") || uri.equals("/info") || uri.equals("/mappings")
                || uri.equals("/metrics") || uri.equals("/shutdown") || uri.equals("/trace")) {
            if(httpRequest.getQueryString() == null || !httpRequest.getQueryString().equals("token=goojia123456")){
                PrintWriter print = httpResponse.getWriter();
                print.write(JsonUtils.toJson(ResponseData.fail("非法请求【缺少token信息】", ResponseCode.NO_AUTH_CODE.getCode())));
                return;
            }
            chain.doFilter(request, response);
        } else {
            //验证TOKEN
            if (!StringUtils.hasText(auth)) {
                PrintWriter print = httpResponse.getWriter();
                print.write(JsonUtils.toJson(ResponseData.fail("非法请求【缺少Authorization信息】", ResponseCode.NO_AUTH_CODE.getCode())));
                return;
            }
            JWTUtils.JWTResult jwt = jwtUtils.checkToken(auth);
            if (!jwt.isStatus()) {
                PrintWriter print = httpResponse.getWriter();
                print.write(JsonUtils.toJson(ResponseData.fail(jwt.getMsg(), jwt.getCode())));
                return;
            }
            chain.doFilter(httpRequest, response);
        }

    }

    @Override
    public void destroy() {

    }
}
