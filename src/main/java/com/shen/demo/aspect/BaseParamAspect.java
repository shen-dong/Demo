package com.shen.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * @author shen
 * @date 2021/11/19 9:32
 */
@Component
@Aspect
public class BaseParamAspect {
    @Pointcut("execution(public * com.shen..controller.*.*(..))")
    public void globalPointCut(){}

    @Around("globalPointCut()")
    public Object baseLogHandler(ProceedingJoinPoint joinPoint) throws Throwable {
        //save request body
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            attributes.getRequest().setAttribute("requestBody", Arrays.toString(joinPoint.getArgs()));
        }
        // run service
        long startTimeMillis = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        //save service spent time
        if (attributes != null) {
            attributes.getRequest().setAttribute("useTimeMillis", (System.currentTimeMillis() - startTimeMillis));
        }
        return proceed;
    }
}
