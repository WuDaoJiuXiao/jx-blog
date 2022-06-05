package com.jiuxiao.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @Author: 悟道九霄
 * @Date: 2022年06月01日 14:53
 * @Version: 1.0.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * @param request
     * @param response
     * @param handler
     * @return: boolean
     * @decription 未登录就重定向到登录页
     * @date 2022/6/5 10:02
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}