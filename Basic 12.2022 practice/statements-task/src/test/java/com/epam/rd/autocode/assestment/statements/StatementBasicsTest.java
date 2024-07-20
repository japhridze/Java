package com.epam.rd.autocode.assestment.statements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.epam.rd.autocode.assestment.statements.StatementBasics.*;
import static org.junit.jupiter.api.Assertions.*;

class StatementBasicsTest {

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/ap.csv"}, delimiterString = ";")
    void testAddPositive(int value, int expected) {
        assertEquals(expected, addPositive(value));
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/apsn.csv"}, delimiterString = ";")
    void testAddPositiveSubtractNegative(int value, int expected) {
        assertEquals(expected, addPositiveSubtractNegative(value));
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/apsnrz.csv"}, delimiterString = ";")
    void testAddPositiveSubtractNegativeReplaceZero(int value, int expected) {
        assertEquals(expected, addPositiveSubtractNegativeReplaceZero(value));
    }
}