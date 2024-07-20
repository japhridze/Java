package com.epam.rd.qa.inheritance;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    static Map<String, Executable> map = new HashMap<>();

    @BeforeAll
    static void setUp() {
        map.put("Employee", (c, s, p) -> new Employee(c, s));
        map.put("SalesPerson", SalesPerson::new);
        map.put("Manager", Manager::new);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/casesConstructorShouldThrow.csv", delimiterString = ",")
    void testConstructorShouldThrow(String className, String name, String salary, String param) {
        assertThrows(IllegalArgumentException.class, () -> map.get(className)
                .execute(name, salary == null ? null : new BigDecimal(salary),
                        param == null ? 0 : Integer.parseInt(param)));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/casesConstructorShouldCreate.csv", delimiterString = ",")
    void testConstructorShouldCreate(String className, String name, String salary, String bonus) {
        assertDoesNotThrow(() -> map.get(className)
                .execute(name, salary == null ? null : new BigDecimal(salary),
                        bonus == null ? 0 : Integer.parseInt(bonus)));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/casesToPay.csv", delimiterString = ",")
    void testToPay(String className, String name, String salary, String param, String bonus, String expected) {
        Employee e = map.get(className).execute(name, new BigDecimal(salary), Integer.parseInt(param));
        e.setBonus(new BigDecimal(bonus));
        assertEquals(new BigDecimal(expected), e.toPay());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/casesSetBonus.csv", delimiterString = ",")
    void testSetBonusShouldThrow(String className, String name, String salary, String param, String bonus, String expected) {
        Employee e = map.get(className).execute(name, new BigDecimal(salary), Integer.parseInt(param));
        BigDecimal companyBonus = bonus == null ? null : new BigDecimal(bonus);
        assertThrows(IllegalArgumentException.class, () -> e.setBonus(companyBonus));
    }

    private interface Executable {
        Employee execute(String name, BigDecimal salary, int param);
    }
}