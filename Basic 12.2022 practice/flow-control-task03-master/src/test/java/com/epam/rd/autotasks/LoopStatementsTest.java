package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopStatementsTest {

    @Test
    public void testSumOfFibonacciNumbersSimpleCase() {

        assertEquals(33, LoopStatements.sumOfFibonacciNumbers(8));
        assertEquals(143, LoopStatements.sumOfFibonacciNumbers(11));

       
    }

    


}
