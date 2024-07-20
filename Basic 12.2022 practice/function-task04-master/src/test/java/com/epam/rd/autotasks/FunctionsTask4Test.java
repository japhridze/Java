package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTask4Test {

    @Test
    public void testSummaryOfTheGeometricProgressionNumbers() {
        assertEquals(175, FunctionsTask4.sumGeometricElements(100, 0.5, 20));
        assertEquals(200, FunctionsTask4.sumGeometricElements(100, 0.5, 0));
        assertEquals(2200, FunctionsTask4.sumGeometricElements(2000, 0.1, 50));
        assertEquals(522, FunctionsTask4.sumGeometricElements(100, 0.9, 50));
        assertEquals(50, FunctionsTask4.sumGeometricElements(5, 0.9, 0));
    }

    @Test
    public void summaryOfTheGeometricProgressionNumbersWithIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, -0.1, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 0, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 1, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 1.1, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(0, 0.5, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(10, 0.5, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(0, 0.5, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 0.9, 100);
        });
         assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(-100, 0.5, -20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(1, 0.9, -1);
        });
    }
}
