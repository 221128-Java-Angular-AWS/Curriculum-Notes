package com.revature.TDD;

public class Calculator {

    public Integer add(Integer ...nums) {
        Integer sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public Integer subtract(Integer a, Integer b) {
        return null;
    }
}
