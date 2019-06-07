package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST })
public class RequestResponseLoggingFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        logger.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());

        filterchain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}