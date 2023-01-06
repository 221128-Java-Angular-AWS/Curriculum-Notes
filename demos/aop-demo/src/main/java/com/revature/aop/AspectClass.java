package com.revature.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {
    @Before("execution(public void testBeforeJoinPoint())")
    public void before() {
        System.out.println("This is before advice");
    }

    @AfterThrowing("execution(public boolean testAfterThrowingJoinPoint(..))")
    public void afterThrowing() {
        System.out.println("This is afterThrowing advice");
    }

    @After("execution(public * testAfterJoinPoint(*))")
    public void after() {
        System.out.println("This is after advice");
    }

    @Around("execution(public String testAroundJoinPoint(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("This is around advice before proceeding to the join point");
        pjp.proceed(pjp.getArgs());

        System.out.println("This is around advice after proceeding to the join point");
        return "hello";
    }

}
