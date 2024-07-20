package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTask3Test {

    @Test
    public void testMultiplicationOfTheArithmeticProgressionNumbers() {
        assertEquals(6160, FunctionsTask3.multiArithmeticElements(5, 3, 4));
        assertEquals(15, FunctionsTask3.multiArithmeticElements(1, 2, 3));
        assertEquals(0, FunctionsTask3.multiArithmeticElements(0, 1, 3));
        assertEquals(1, FunctionsTask3.multiArithmeticElements(1, 0, 3));
        assertEquals(1, FunctionsTask3.multiArithmeticElements(1, 2, 1));
        assertEquals(-15, FunctionsTask3.multiArithmeticElements(-5, 2, 3));
        assertEquals(0, FunctionsTask3.multiArithmeticElements(-2, 2, 3));
        assertEquals(1393557504, FunctionsTask3.multiArithmeticElements(10, -4, 20));

    }

    @Test
    public void multiplicationOfTheArithmeticProgressionNumbersWithIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask3.multiArithmeticElements(1, 2, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask3.multiArithmeticElements(1, 2, -5);
        });
    }
}
