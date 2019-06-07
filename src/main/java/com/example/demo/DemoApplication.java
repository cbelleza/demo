package com.example.demo;

import javax.servlet.DispatcherType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.demo.filter.RequestResponseLoggingFilter;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(
                new RequestResponseLoggingFilter());
        //filterRegistrationBean.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);

        return filterRegistrationBean;
    }
}
