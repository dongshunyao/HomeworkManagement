package com.hwm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.hwm.controller..*.*(..))")
    public void controller() {
    }

    @Before("controller()")
    public void beforeController(JoinPoint joinPoint) {
        final String info = "---> Start\n" +
                "Name: " + joinPoint.toString() + "\n" +
                "Time: " + new Date() + "\n" +
                "Kind: " + joinPoint.getKind() + "\n" +
                "Signature: " + joinPoint.getSignature();
        System.out.println(info);
    }

    @After("controller()")
    public void afterController() {
        final String info = "End Time: " + new Date() + "\n" +
                "---> End\n";
        System.out.println(info);
    }
}
