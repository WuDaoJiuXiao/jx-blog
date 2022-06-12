package com.jiuxiao.aspect;

import com.jiuxiao.annotation.MyLogAnnotation;
import com.jiuxiao.pojo.Journal;
import com.jiuxiao.service.journal.JournalService;
import com.jiuxiao.tools.TimeTools;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 自定义日志切面
 * @Author: 悟道九霄
 * @Date: 2022年06月07日 10:00
 * @Version: 1.0.0
 */
@Aspect
@Component
public class MyLogAspect {

    @Autowired(required = false)
    private JournalService journalService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @return: void
     * @decription 配置织入点
     * @date 2022/6/7 10:09
     */
    @Pointcut("@annotation(com.jiuxiao.annotation.MyLogAnnotation)")
    public void MyLogApi() {
    }

    @Before("MyLogApi()")
    public void doBefore(JoinPoint joinPoint) throws Exception {

    }

    /**
     * @param joinPoint
     * @return: java.lang.Object
     * @decription 使用环绕
     * @date 2022/6/7 16:19
     */
    @Around("MyLogApi()")
    public Object around(ProceedingJoinPoint joinPoint) throws Exception {
        Object res = null;
        //检查是否存在该自定义注解
        this.checkPermission(joinPoint);
        try {
            res = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return res;
    }

    /**
     * @param joinPoint
     * @return: void
     * @decription 检查是否被注解，若有注解则存入数据库
     * @date 2022/6/7 16:19
     */
    private void checkPermission(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        String operateName = null;
        MyLogAnnotation myLogAnnotation = method.getAnnotation(MyLogAnnotation.class);
        if (myLogAnnotation != null){
            operateName = myLogAnnotation.value();
        }

        String success = "成功";
        String requestUrl = null;
        String requestIp = null;
        String requestClassName = null;
        String requestMethodName = null;

        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();

            try {
                requestUrl = request.getRequestURL().toString();
                requestIp = request.getRemoteAddr();
                String[] classList = joinPoint.getSignature().getDeclaringTypeName().split("\\.");
                requestClassName = classList[classList.length - 1];
                requestMethodName = joinPoint.getSignature().getName();
            } catch (Exception e) {
                success = "失败";
                logger.debug(e.getMessage());
            }

            Journal journal = new Journal();
            journal.setId(journalService.queryJournalCount() + 1);
            journal.setOperateName(operateName);
            journal.setSuccess(success);
            journal.setRequestIp(requestIp);
            journal.setRequestClassName(requestClassName);
            journal.setRequestMethodName(requestMethodName);
            journal.setRequestUrl(requestUrl);
            journal.setCreatedTime(TimeTools.getCurrentTime());

            //只有数据库中不存在该记录，才会保存
            List<Journal> queryIfExist = journalService.queryIfExist(journal);
            if (queryIfExist.size() == 0) {
                journalService.insertJournal(journal);
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
    }
}