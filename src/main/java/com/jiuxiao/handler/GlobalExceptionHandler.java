package com.jiuxiao.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常拦截器
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月30日 9:25
 * @Version: 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 异常处理
     *
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        logger.error("RequestURL : {}, Exception : {}", requestURL, exception.getMessage());

        //自定义异常单独处理，返回到自定义的页面
        if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null){
            throw exception;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url", requestURL);
        mv.addObject("exception", exception);
        mv.setViewName("error/error");
        return mv;
    }
}