package com.epam.rd.qa.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @ParameterizedTest
    @MethodSource("casesConstructorShouldThrow")
    void testConstructorShouldThrow(Class<Deposit> depositClass, BigDecimal amount, int period) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    try {
                        depositClass.getDeclaredConstructor(BigDecimal.class, Integer.TYPE).newInstance(amount, period);
                    } catch (ReflectiveOperationException e) {
                        if (e.getCause() instanceof IllegalArgumentException) {
                            throw e.getCause();
                        }
                        throw new RuntimeException(e);
                    }
                });
    }

    static Stream<Arguments> casesConstructorShouldThrow() {
        return Stream.of(
                Arguments.of(SpecialDeposit.class, new BigDecimal("0."), 1),
                Arguments.of(SpecialDeposit.class, new BigDecimal("-1000"), 75),
                Arguments.of(LongDeposit.class, new BigDecimal("10.00001"), 0),
                Arguments.of(LongDeposit.class, new BigDecimal("1000"), -3)
        );
    }

    @ParameterizedTest
    @MethodSource("casesDeposit")
    void testGetAmount(Deposit deposit, BigDecimal expectedAmount, int expectedPeriod) {
        assertEquals(expectedAmount, deposit.getAmount());
        assertEquals(expectedPeriod, deposit.getPeriod());
    }

    static Stream<Arguments> casesDeposit() {
        return Stream.of(
                Arguments.of(new SpecialDeposit(new BigDecimal("0.00001"), 1), new BigDecimal("0.00001"), 1),
                Arguments.of(new SpecialDeposit(new BigDecimal("1000"), 75), new BigDecimal("1000"), 75),
                Arguments.of(new LongDeposit(new BigDecimal("0.00001"), 1), new BigDecimal("0.00001"), 1),
                Arguments.of(new LongDeposit(new BigDecimal("1000"), 75), new BigDecimal("1000"), 75)
        );
    }

    @Test
    void testCompareTo() {
        assertEquals(0, new LongDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new LongDeposit(new BigDecimal("0.00001"), 2)));
        assertEquals(0, new SpecialDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new SpecialDeposit(new BigDecimal("0.00001"), 2)));
        assertEquals(0, new SpecialDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new LongDeposit(new BigDecimal("0.00001"), 2)));
        assertEquals(0, new LongDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new SpecialDeposit(new BigDecimal("0.00001"), 2)));

        assertTrue(new LongDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new LongDeposit(new BigDecimal("0.000001"), 2)) > 0);
        assertTrue(new SpecialDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new SpecialDeposit(new BigDecimal("0.000001"), 2)) > 0);
        assertTrue(new LongDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new SpecialDeposit(new BigDecimal("0.000001"), 2)) > 0);
        assertTrue(new SpecialDeposit(new BigDecimal("0.00001"), 1)
                .compareTo(new LongDeposit(new BigDecimal("0.000001"), 2)) > 0);

        assertTrue(new LongDeposit(new BigDecimal("0.000001"), 1)
                .compareTo(new LongDeposit(new BigDecimal("0.00001"), 2)) < 0);
        assertTrue(new SpecialDeposit(new BigDecimal("0.000001"), 1)
                .compareTo(new SpecialDeposit(new BigDecimal("0.00001"), 2)) < 0);
        assertTrue(new LongDeposit(new BigDecimal("0.000001"), 1)
                .compareTo(new SpecialDeposit(new BigDecimal("0.00001"), 2)) < 0);
        assertTrue(new SpecialDeposit(new BigDecimal("0.000001"), 1)
                .compareTo(new LongDeposit(new BigDecimal("0.00001"), 2)) < 0);
    }
}