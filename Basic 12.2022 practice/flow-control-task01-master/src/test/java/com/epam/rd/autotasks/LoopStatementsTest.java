package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopStatementsTest {

    @Test
    public void testSumOddDigitsSimpleCase() {

        assertEquals(4, LoopStatements.sumOddDigits(1234));
        assertEquals(0, LoopStatements.sumOddDigits(246));
        assertEquals(3, LoopStatements.sumOddDigits(111));

        
    }

    


}
