package com.revature.aop;

import com.revature.aop.AdvisedClass;
import com.revature.aop.BeanConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(com.revature.aop.BeanConfig.class);

        AdvisedClass advisedClass = context.getBean(AdvisedClass.class);

        advisedClass.testBeforeJoinPoint();

        try {
            advisedClass.testAfterThrowingJoinPoint();
        } catch (Exception e) {
            //do nothing with it.
        }


        advisedClass.testAroundJoinPoint("hello!");

        advisedClass.testAfterJoinPoint("Hello!");
    }
}
