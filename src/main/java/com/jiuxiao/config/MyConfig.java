package com.jiuxiao.config;

import com.jiuxiao.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自拦截器、资源等配置
 *
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 14:00
 * @Version: 1.0.0
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    /**
     * 登录拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin");
    }
}