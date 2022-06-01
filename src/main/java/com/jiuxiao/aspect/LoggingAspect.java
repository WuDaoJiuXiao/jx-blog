package com.jiuxiao.aspect;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面
 *
 * @Author: 悟道九霄
 * @Date: 2022年05月30日 10:21
 * @Version: 1.0.0
 */
@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.jiuxiao.controller.*.*(..))")
    public void log() {

    }

    /**
     * 获取请求地址、请求 ip、请求的方法、参数、返回类型等信息，输出到日志
     *
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        String RequestURL = request.getRequestURL().toString();
        String RequestIP = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] RequestArgs = joinPoint.getArgs();

        RequestLog requestLog = new RequestLog(RequestURL, RequestIP, classMethod, RequestArgs);
        logger.info("Request : {}", requestLog);
    }

    @After("log()")
    public void doAfter() {

    }

    /**
     * 获得返回的信息
     *
     * @param result
     */
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) {
        logger.info("Result : {}", result);
    }
}


/**
 * 日志获取信息内容类
 */
@AllArgsConstructor
@ToString
class RequestLog {
    private final String RequestURL;
    private final String RequestIP;
    private final String classMethod;
    private final Object[] RequestArgs;
}