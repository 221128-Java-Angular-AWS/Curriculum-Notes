package com.revature.TDD;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/*
    The 3 A's of unit testing:
     - Arrange - set up the parameters for valid testing
     - Act - perform the test
     - Assert - verify the outcome of the action


     @Test
     @BeforeEach
     @AfterEach
     @AfterAll
     @BeforeAll
 */


@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    public Calculator sut;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Starting tests...");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests are complete!");
    }

    @BeforeEach
    public void beforeEach(@Mock OtherClass otherClass) {
        sut = new Calculator(otherClass);
        Mockito.when(otherClass.testMethod(Mockito.<String>any())).thenReturn("String");
    }

    @AfterEach
    public void afterEach() {
        sut = null;
    }


    @Test
    public void testAddMethodToSeeIfItCanAddTwoPositiveNumbers() {

        //arrange: need parameters, expected results, need the SUT object
        int a = 2;
        int b = 2;

        int expectedSum = 4;

        //act: call the method
        Integer actualSum = sut.add(a, b);

        //assert: check that our actual result is the same as our expected result.
        Assertions.assertEquals(expectedSum, actualSum);

        /*
        What other testable possibilities should we cover?
        test bad data

         */
    }

    @Test
    public void testSubtractionWithGoodParametersMockingOtherClass() {
        //arrange
        int a = 5;
        int b = 1;
        int expectedResult = 4;

        //act
        int actualResult = sut.subtract(a, b);

        //assert
        Assertions.assertEquals(expectedResult, actualResult);

    }

}
