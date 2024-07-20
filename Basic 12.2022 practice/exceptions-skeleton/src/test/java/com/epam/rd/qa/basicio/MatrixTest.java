package com.epam.rd.qa.basicio;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    double[][] values = {{1, 2, 3}, {3, 2, 1}};
    Matrix matrix = new Matrix(values);

    @Test
    void testGetShouldReturn() {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                assertEquals(values[i][j], matrix.get(i, j));
            }
        }
    }

    @Test
    void testSetShouldSet() {
        double[][] expected = new double[values.length][];
        for (int i = 0; i < values.length; i++) {
            expected[i] = Arrays.copyOf(values[i], values[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                expected[i][j] = expected[i][j] * 2;
            }
        }
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.set(i, j, expected[i][j]);
                assertEquals(expected[i][j], matrix.get(i, j));
            }
        }
    }

    @Test
    void testGetShouldThrow() {
        assertThrows(MatrixException.class, () -> matrix.get(matrix.getRows(), matrix.getColumns() - 1),
                "You should wrap original exception into your own exception or verify parameters manually");
        assertThrows(MatrixException.class, () -> matrix.get(matrix.getRows() - 1, matrix.getColumns()),
                "You should wrap original exception into your own exception or verify parameters manually");
        assertThrows(MatrixException.class, () -> matrix.get(-1, 0),
                "You should wrap original exception into your own exception or verify parameters manually");
        assertThrows(MatrixException.class, () -> matrix.get(0, -1),
                "You should wrap original exception into your own exception or verify parameters manually");
    }

    @Test
    void testSetShouldThrow() {
        assertThrows(MatrixException.class, () -> matrix.set(matrix.getRows(), matrix.getColumns() - 1, 0),
                "You should check values before set");
        assertThrows(MatrixException.class, () -> matrix.set(matrix.getRows() - 1, matrix.getColumns(), 0),
                "You should check values before set");
        assertThrows(MatrixException.class, () -> matrix.set(-1, 0, 0),
                "You should check values before set");
        assertThrows(MatrixException.class, () -> matrix.set(0, -1, 0),
                "You should check values before set");
    }
}
