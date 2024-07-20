package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testZeroInput() {
        assertEquals("1", factorial.factorial("0"));
    }

    @Test
    void testLargeInput() {
        assertEquals("2432902008176640000", factorial.factorial("20")); // 20!
    }

    @Test
    void testOneInput() {
        assertEquals("1", factorial.factorial("1"));
    }
}
