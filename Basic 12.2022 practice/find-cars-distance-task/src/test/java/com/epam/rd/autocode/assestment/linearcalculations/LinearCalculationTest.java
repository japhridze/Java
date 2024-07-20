package com.epam.rd.autocode.assestment.linearcalculations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class LinearCalculationTest {

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/cars.csv"}, delimiterString = ";")
    void testFindCarsDistance(double car1Speed, double car2Speed, double initialDistance, double time, double expected) {
        assertEquals(expected, round(LinearCalculation.findCarsDistance(car1Speed, car2Speed, initialDistance, time), 4));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}