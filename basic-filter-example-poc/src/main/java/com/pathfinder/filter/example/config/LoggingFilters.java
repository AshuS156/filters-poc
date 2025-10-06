package com.pathfinder.filter.example.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        /*logger.info("Logging Filter: Request Method : {} , Request URL : {}",
                    httpServletRequest.getMethod(),httpServletRequest.getRequestURL().toString());*/
        final String method = httpServletRequest.getMethod();
        final String servletPath = httpServletRequest.getServletPath();
        final String requestURI = httpServletRequest.getRequestURL().toString();
        final String requestURI1 =httpServletRequest.getRequestURI();
        logger.info("Logging Filter: Request Method : {} , Request URL : {} , servletPath : {} , requestURI : {}",
                method,requestURI,servletPath,requestURI1);

        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("Response received at : {} " , System.currentTimeMillis());

    }

    @Override
    public void destroy(){
        Filter.super.destroy();
    }
}
