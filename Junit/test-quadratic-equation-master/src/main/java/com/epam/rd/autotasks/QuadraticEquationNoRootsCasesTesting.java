package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticEquationNoRootsCasesTesting {

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "1, 0, 1",  // discriminant < 0
            "1, 2, 3",  // discriminant < 0
            "5, 3, 4",  // discriminant < 0
            "2, 1, 2"   // discriminant < 0
    })
    public void testCase(double a, double b, double c) {
        assertEquals("no roots", quadraticEquation.solve(a, b, c));
    }
}
