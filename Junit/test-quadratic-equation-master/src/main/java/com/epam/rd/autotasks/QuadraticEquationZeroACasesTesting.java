package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuadraticEquationZeroACasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "0, 2, 3",  // a == 0
            "0, -5, 6", // a == 0
            "0, 0, 0",  // a == 0
            "0, 4, -1"  // a == 0
    })
    public void testCase(double a, double b, double c) {
        assertThrows(IllegalArgumentException.class, () -> quadraticEquation.solve(a, b, c));
    }
}
