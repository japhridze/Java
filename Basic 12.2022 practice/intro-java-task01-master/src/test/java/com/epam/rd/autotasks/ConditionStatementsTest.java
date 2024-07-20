package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionStatementsTest {

    @Test
    public void test1SimpleCase() {
        assertEquals(16, ConditionStatements.task1(4));
        assertEquals(5, ConditionStatements.task1(-5));
        assertEquals(0, ConditionStatements.task1(0));
    }
}
