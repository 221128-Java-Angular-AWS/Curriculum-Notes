package com.revature.TDD;

public class Calculator {
    OtherClass otherClass;

    public Calculator(OtherClass otherClass) {
        this.otherClass = otherClass;
    }

    public Integer add(Integer ...nums) {
        Integer sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public Integer subtract(Integer a, Integer b) {

        System.out.println("This happens...");

        System.out.println(otherClass.testMethod("We can't let this happen during the unit tests."));

        return a-b;
    }


}
