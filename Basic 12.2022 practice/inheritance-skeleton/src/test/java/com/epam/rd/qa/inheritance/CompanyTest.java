package com.epam.rd.qa.inheritance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private static final Map<String, Executable> executableMap = new HashMap<>();

    @BeforeAll
    static void setUp() {
        executableMap.put("Employee", (c, s, p) -> new Employee(c, s));
        executableMap.put("SalesPerson", SalesPerson::new);
        executableMap.put("Manager", Manager::new);
    }

    private interface Executable {
        Employee execute(String name, BigDecimal salary, int param);
    }

    @Test
    void testConstructorShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new Company(null));
    }

    @ParameterizedTest
    @MethodSource("casesTotalToPay")
    void testTotalToPay(Employee[] employees, BigDecimal bonus, BigDecimal expectedTotal, String expectedNameMaxSalary) {
        Company company = new Company(employees);
        company.giveEverybodyBonus(bonus);
        BigDecimal totalToPay = company.totalToPay();
        String nameMaxSalary = company.nameMaxSalary();
//        System.out.printf("bonus: %s, expectedTotal: %s, expectedNameMaxSalary: %s", bonus, totalToPay, nameMaxSalary);
        assertEquals(expectedTotal, totalToPay);
        assertEquals(expectedNameMaxSalary, nameMaxSalary);
    }

    @MethodSource("casesTotalToPayThrow")
    @ParameterizedTest
    void testTotalToPayShouldThrow(Employee[] employees, BigDecimal bonus) {
        Company company = new Company(employees);
        assertThrows(IllegalArgumentException.class, () -> company.giveEverybodyBonus(bonus));
    }

    static Stream<Arguments> casesTotalToPay() {
        Random classRandom = new Random(5);
        String[] classNames = executableMap.keySet().toArray(new String[0]);
        Random salaryRandom = new Random(15);
        Random paramRandom = new Random(27);

        return Stream.of(
                Arguments.of(
                        getEmployees(classRandom, classNames, salaryRandom, paramRandom),
                        new BigDecimal(String.valueOf(nextInt(paramRandom, 100, 500))),
                        new BigDecimal("45485.489438283149638664326630532741546630859375"),
                        "Manager157"),
                Arguments.of(
                        getEmployees(classRandom, classNames, salaryRandom, paramRandom),
                        new BigDecimal(String.valueOf(nextInt(paramRandom, 100, 500))),
                        new BigDecimal("38144.5761043381766057791537605226039886474609375"),
                        "Manager141")
                );
    }

    static Stream<Arguments> casesTotalToPayThrow() {
        Random classRandom = new Random(5);
        String[] classNames = executableMap.keySet().toArray(new String[0]);
        Random salaryRandom = new Random(15);
        Random paramRandom = new Random(27);

        return Stream.of(
                Arguments.of(
                        getEmployees(classRandom, classNames, salaryRandom, paramRandom),
                        BigDecimal.ZERO),
                Arguments.of(
                        getEmployees(classRandom, classNames, salaryRandom, paramRandom),
                        BigDecimal.ONE.negate())
                );
    }

    private static Employee[] getEmployees(Random classRandom, String[] classNames, Random salaryRandom, Random paramRandom) {
        return Stream.generate(() -> {
            String className = classNames[classRandom.nextInt(3)];
            double val = nextDouble(salaryRandom, 1000, 2000);
            int param = nextInt(paramRandom, 0, 200);
            return executableMap.get(className)
                    .execute(className + param, new BigDecimal(val), param);
        }).limit(20).toArray(Employee[]::new);
    }

    static double nextDouble(Random r, double origin, double bound) {
        return r.nextDouble() * (bound - origin) + origin;
    }

    static int nextInt(Random r, int origin, int bound) {
        return r.nextInt(bound - origin) + origin;
    }
}