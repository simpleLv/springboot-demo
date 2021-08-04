package com.lfs.config;


import com.lfs.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

  /*      registry.addViewController("/index").setViewName("index.html");*/
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      /*  registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/sys/login")
                .excludePathPatterns("/*.html")
                .excludePathPatterns("/*.css")
                .excludePathPatterns("/*.js")
                .excludePathPatterns("/swagger/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/sysFile/**")
                .excludePathPatterns("/setSession/**")
                .excludePathPatterns("/base/**");*/

    }
}
