package com.anti.springbootaop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

//1）target：目标类
//需要被代理的类。例如：UserService
//2）Joinpoint：连接点
//所谓连接点是指那些可能被拦截到的方法。例如：所有的方法
//3）PointCut：切入点
//已经被增强的连接点。例如：addUser()
//4）advice：通知/增强
//增强代码。例如：after、before
//5）Weaving：织入
//指把增强advice应用到目标对象target来创建新的代理对象proxy的过程.
//6）proxy 代理类
//7) Aspect(切面): 是切入点pointcut和通知advice的结合
//一个线是一个特殊的面。
//一个切入点和一个通知，组成成一个特殊的面。

@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.anti.springbootaop.config.LogFilter)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        try {
            // 执行方法
            result = point.proceed();
            saveRequestLog(point);
        } catch (Exception e) {
            saveExceptionLog(point, e.getMessage());
        }
        return result;
    }

    private void saveExceptionLog(ProceedingJoinPoint point, String exeMsg) {
        LOGGER.info("捕获异常:" + exeMsg);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LOGGER.info("请求路径:" + request.getRequestURL());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LOGGER.info("请求方法:" + method.getName());
        // 获取方法上LogFilter注解
        LogFilter logFilter = method.getAnnotation(LogFilter.class);
        String value = logFilter.value();
        LOGGER.info("模块描述:" + value);
        Object[] args = point.getArgs();
        LOGGER.info("请求参数:" + Arrays.toString(args));
    }

    private void saveRequestLog(ProceedingJoinPoint point) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LOGGER.info("请求路径:" + request.getRequestURL());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LOGGER.info("请求方法:" + method.getName());
        // 获取方法上LogFilter注解
        LogFilter logFilter = method.getAnnotation(LogFilter.class);
        String value = logFilter.value();
        LOGGER.info("模块描述:" + value);
        Object[] args = point.getArgs();
        LOGGER.info("请求参数:" + Arrays.toString(args));
    }
}
