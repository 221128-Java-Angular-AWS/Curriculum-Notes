package com.revature.aop;

import org.springframework.stereotype.Component;

@Component
public class AdvisedClass {

    public void testBeforeJoinPoint() {
        System.out.println("Before Method");
    }

    public boolean testAfterThrowingJoinPoint() throws Exception{
        System.out.println("After Throwing Method");
        throw new Exception("test");
    }

    public String testAfterJoinPoint(String string) {
        System.out.println("After Join Point");
        return string;
    }

    public String testAroundJoinPoint(String string) {
        System.out.println("Around join point");
        return string;
    }


}
