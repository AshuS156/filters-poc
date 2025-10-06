package com.pathfinder.filter.example.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilters implements Filter{

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilters.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,ServletResponse servletResponse,FilterChain filterChain) throws IOException, ServletException{
   logger.info("Request received at : {} " , System.currentTimeMillis());
        HttpServletRequest httpServletRequest = null;
        HttpServletResponse httpServletResponse = null;
        if(servletRequest instanceof HttpServletRequest) {
            httpServletRequest = (HttpServletRequest) servletRequest;
        }
        if(servletResponse instanceof HttpServletResponse) {
            httpServletResponse = (HttpServletResponse) servletResponse;
        }

        final String method = httpServletRequest.getMethod();
        final String servletPath = httpServletRequest.getServletPath();
        final String requestURI = httpServletRequest.getRequestURL().toString();
        final String requestURI1 =httpServletRequest.getRequestURI();
        logger.info("Logging Filter: Request Method : {} , Request URL : {} , servletPath : {} , requestURI : {}",
                method,requestURI,servletPath,requestURI1);

        MDC.put("requestId",String.valueOf(System.currentTimeMillis()));
        MDC.put("requestMethod",method);
        MDC.put("requestURI",requestURI);
        MDC.put("servletPath",servletPath);

        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("Response received at : {} " , System.currentTimeMillis());

        MDC.remove("requestId");
        MDC.remove("requestMethod");
        MDC.remove("requestURI");
        MDC.remove("servletPath");


    }

    @Override
    public void destroy(){
        Filter.super.destroy();
    }
}
