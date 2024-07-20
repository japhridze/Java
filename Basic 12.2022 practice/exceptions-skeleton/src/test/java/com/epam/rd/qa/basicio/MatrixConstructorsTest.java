package com.epam.rd.qa.basicio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixConstructorsTest {

    @ParameterizedTest
    @MethodSource("casesCreateMatrixWithGivenRowsAndColsShouldCreate")
    void testCreateMatrixWithGivenRowsAndColsShouldCreate(int r, int c) {
        Matrix m = new Matrix(r, c);
        assertEquals(r, m.getRows());
        assertEquals(c, m.getColumns());
    }

    static Stream<Arguments> casesCreateMatrixWithGivenRowsAndColsShouldCreate() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(1, 5),
                Arguments.of(3, 4),
                Arguments.of(999, 999)
        );
    }

    @ParameterizedTest
    @MethodSource("casesCreateMatrixWithGivenRowsAndColsShouldThrow")
    void testCreateMatrixWithGivenRowsAndColsShouldThrow(int r, int c) {
        assertThrows(MatrixException.class, () -> new Matrix(r, c));
    }

    static Stream<Arguments> casesCreateMatrixWithGivenRowsAndColsShouldThrow() {
        return Stream.of(
                Arguments.of(-1, 1),
                Arguments.of(1, -1),
                Arguments.of(0, 5),
                Arguments.of(5, 0),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesCreateMatrixWithGivenArrayShouldCreate")
    void testCreateMatrixWithGivenArrayShouldCreate(double[][] expected) {
        Matrix m = new Matrix(expected);
        assertEquals(expected, m.toArray());
    }

    static Stream<Arguments> casesCreateMatrixWithGivenArrayShouldCreate() {
        Random r = new Random(5);
        return Stream.of(
                Arguments.of((Object) randomInit(r, 5, 5)),
                Arguments.of((Object) randomInit(r, 3, 3)),
                Arguments.of((Object) randomInit(r, 1, 3)),
                Arguments.of((Object) randomInit(r, 3, 1)),
                Arguments.of((Object) randomInit(r, 2, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("casesCreateMatrixWithGivenArrayShouldThrow")
    void testCreateMatrixWithGivenArrayShouldThrow(double[][] values) {
        assertThrows(MatrixException.class, () -> new Matrix(values));
    }

    @Test
    void testCreateMatrixWithUnrectArrayShouldThrow() {
        assertThrows(MatrixException.class, () -> new Matrix(new double[][]{{1., 2.}, {0., 1., 2.}}));
    }

    static Stream<Arguments> casesCreateMatrixWithGivenArrayShouldThrow() {
        Random r = new Random(5);
        return Stream.of(
                Arguments.of((Object) randomInit(r, 0, 5)),
                Arguments.of((Object) randomInit(r, 3, 0)),
                Arguments.of((Object) randomInit(r, 0, 0))
        );
    }

    static double[][] randomInit(Random r, int rows, int cols) {
        double[][] doubles = new double[rows][];
        for (int i = 0; i < rows; i++) {
            doubles[i] = r.doubles(cols, -25., 25.).toArray();
        }
        return doubles;
    }
}