package com.atguigu.config;

import com.atguigu.component.LoginHandlerInterceptor;
import com.atguigu.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter () {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("login");
                    registry.addViewController("/index.html").setViewName("login");
                    registry.addViewController("/main.html").setViewName("dashboard");
                    }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(
                        "/index.html", "/", "/user/login", "/login.html", "/webjars/**", "/asserts/**", "/favicon.ico");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
