package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopStatementsTest {

    @Test
    public void testSumOfBinarySimpleCase() {

        assertEquals(3, LoopStatements.sumOfBinary(14));
        assertEquals(1, LoopStatements.sumOfBinary(128));

      

    }

   


}
