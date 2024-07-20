package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionStatementsTest {

    @Test
    public void test2SimpleCase() {
        assertEquals(651, ConditionStatements.task2(165));
        assertEquals(321, ConditionStatements.task2(123));


    }


}
