package com.epam.rd.qa.collections;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongDepositTest {

    @ParameterizedTest
    @MethodSource("casesCanToProlong")
    void testCanToProlong(LongDeposit deposit, boolean expected) {
        assertEquals(expected, deposit.canToProlong());
    }

    static Stream<Arguments> casesCanToProlong() {
        return Stream.of(
                Arguments.of(new LongDeposit(new BigDecimal("1000."), 36), false),
                Arguments.of(new LongDeposit(new BigDecimal("1000."), 35), true),
                Arguments.of(new LongDeposit(new BigDecimal("1000.0000001"), 36), false),
                Arguments.of(new LongDeposit(new BigDecimal("2047.345"), 35), true),
                Arguments.of(new LongDeposit(new BigDecimal("999.9999999999999"), 36), false),
                Arguments.of(new LongDeposit(new BigDecimal("999.9999999999999"), 35), true)
        );
    }
}