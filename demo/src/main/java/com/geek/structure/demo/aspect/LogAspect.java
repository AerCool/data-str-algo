package com.geek.structure.demo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * @desc: 日志记录的方法
 * @author: yxb
 * @since: 2019-11-29 14:54
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.geek.structure.demo.controller..*.*(..))")
    public void log() {}

    @Around("log()")
    public void aroud(ProceedingJoinPoint joinPoint) {
        try {
            String classType = joinPoint.getTarget().getClass().getName();
            Class<?> clazz = Class.forName(classType);
            String clazzName = clazz.getName();
            LOGGER.info("请求类名: {}", clazzName);
            String methodName = joinPoint.getSignature().getName();
            LOGGER.info("请求方法名: {}", methodName);
            Object[] args = joinPoint.getArgs();
            LOGGER.info("请求参数: {}", JSON.toJSONString(args));
            try {
                Object result = joinPoint.proceed();
                LOGGER.info("响应结果: {}", result);
            }catch (Throwable throwable) {
                LOGGER.error("请求出错了--> cause: {} msg : {}", throwable.getCause(), throwable.getMessage());
            }

        } catch (Exception e) {
            LOGGER.error("LogAspect exception ");
        }
    }
}
