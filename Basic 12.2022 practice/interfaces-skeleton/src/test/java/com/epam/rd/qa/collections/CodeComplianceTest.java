package com.epam.rd.qa.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CodeComplianceTest {
    @Test
    void testCodeComplianceDepositClass() throws NoSuchMethodException {
        Class<Deposit> depositClass = Deposit.class;
        assertTrue(Modifier.isAbstract(depositClass.getModifiers()),
                "Deposit class should be 'abstract'");

        Constructor<?>[] declaredConstructors = depositClass.getDeclaredConstructors();
        assertEquals(1, declaredConstructors.length,
                "'Deposit' class should declare only one constructor " +
                        "to receive amount and period");

        assertDoesNotThrow(() -> depositClass.getDeclaredConstructor(BigDecimal.class, Integer.TYPE),
                "'Deposit' class should declare only one constructor " +
                        "to receive amount and period");

        Constructor<Deposit> constructor = depositClass.getDeclaredConstructor(BigDecimal.class, Integer.TYPE);
        assertTrue(Modifier.isProtected(constructor.getModifiers()),
                "The constructor should be protected");

        Class<?>[] depositClassInterfaces = depositClass.getInterfaces();
        assertEquals(1, depositClassInterfaces.length,
                "'Deposit' class should implement only 'Comparable' interface");

        Optional<Class<?>> comparableOpt = Arrays.stream(depositClassInterfaces)
                .filter(iFace -> iFace.getName().equals("java.lang.Comparable"))
                .findAny();
        assertTrue(comparableOpt.isPresent(),
                "'Deposit' class should implement 'Comparable<Deposit>' interface");

        Field[] declaredFields = depositClass.getDeclaredFields();
        assertEquals(2, declaredFields.length);

        Optional<Field> amount = Arrays.stream(declaredFields)
                .filter(field -> field.getName().equals("amount")
                        && Modifier.isProtected(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers())
                        && field.getType() == BigDecimal.class
                        && !Modifier.isStatic(field.getModifiers()))
                .findAny();
        assertTrue(amount.isPresent(),
                "'amount' should be 'protected final BigDecimal' " +
                        "and should not be static");

        Optional<Field> period = Arrays.stream(declaredFields)
                .filter(field -> field.getName().equals("period")
                        && Modifier.isProtected(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers())
                        && field.getType() == Integer.TYPE
                        && !Modifier.isStatic(field.getModifiers()))
                .findAny();
        assertTrue(period.isPresent(),
                "'period' should be 'protected final int' " +
                        "and should not be static");
    }

    @ParameterizedTest
    @MethodSource("casesCodeComplianceProlongableDepositClass")
    void testCodeComplianceProlongableDepositClass(Class<Deposit> depositClass) throws NoSuchMethodException {
        assertFalse(Modifier.isAbstract(depositClass.getModifiers()),
                "'SpecialDeposit' class should not be 'abstract");

        Constructor<?>[] declaredConstructors = depositClass.getDeclaredConstructors();
        assertEquals(1, declaredConstructors.length,
                "'Deposit' class should declare only one constructor " +
                        "to receive amount and period");

        assertDoesNotThrow(() -> depositClass.getDeclaredConstructor(BigDecimal.class, Integer.TYPE),
                "'Deposit' class should declare only one constructor " +
                        "to receive amount and period");

        Constructor<Deposit> constructor = depositClass.getDeclaredConstructor(BigDecimal.class, Integer.TYPE);
        assertTrue(Modifier.isPublic(constructor.getModifiers()),
                "The constructor should be public");

        Class<?>[] depositClassInterfaces = depositClass.getInterfaces();
        assertEquals(1, depositClassInterfaces.length,
                "'Deposit' class should directly implement only " +
                        "'com.epam.rd.qa.collections.Prolongable' interface");

        Optional<Class<?>> comparableOpt = Arrays.stream(depositClassInterfaces)
                .filter(iFace -> iFace.getName().equals("com.epam.rd.qa.collections.Prolongable"))
                .findAny();
        assertTrue(comparableOpt.isPresent(),
                "'"+ depositClass.getName() + "' class should implement " +
                        "'com.epam.rd.qa.collections.Prolongable' interface");

        Field[] declaredFields = depositClass.getDeclaredFields();

        assertEquals(declaredFields.length, Arrays.stream(declaredFields)
                        .filter(field -> Modifier.isPrivate(field.getModifiers())
                                && Modifier.isStatic(field.getModifiers())
                                && Modifier.isFinal(field.getModifiers()))
                        .toArray().length,
                "'"+ depositClass.getName() + "' can declare only 'private static final' fields, " +
                        "which do not hide 'Deposit' fields");
    }

    static Stream<Arguments> casesCodeComplianceProlongableDepositClass() {
        return Stream.of(
                Arguments.of(SpecialDeposit.class),
                Arguments.of(LongDeposit.class)
        );
    }
}