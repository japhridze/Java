package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, '2.0 1.0'",  // discriminant > 0
            "1, -5, 6, '3.0 2.0'",  // discriminant > 0
            "2, -4, 2, '1.0 1.0'",  // discriminant > 0
            "3, -6, 2, '2.0 1.0'"    // discriminant > 0
    })
    public void testCase(double a, double b, double c, String expected) {
        String result = quadraticEquation.solve(a, b, c);
        String[] expectedRoots = expected.split(" ");
        String[] resultRoots = result.split(" ");
        assertTrue((resultRoots[0].equals(expectedRoots[0]) && resultRoots[1].equals(expectedRoots[1])) ||
                (resultRoots[0].equals(expectedRoots[1]) && resultRoots[1].equals(expectedRoots[0])));
    }
}
