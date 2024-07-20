package com.epam.rd.qa.inheritance;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCodeComplianceTest {
    @Test
    void testEmployeeCodeCompliance() {
        Class<Employee> employeeClass = Employee.class;

        Field[] declaredFields = employeeClass.getDeclaredFields();
        assertEquals(3, declaredFields.length);

        Optional<Field> nameField = Arrays.stream(declaredFields)
                .filter(f -> f.getName().equals("name"))
                .filter(f -> Modifier.isPrivate(f.getModifiers())
                        && Modifier.isFinal(f.getModifiers())
                        && f.getType() == String.class)
                .findAny();
        assertTrue(nameField.isPresent(), "'name' must be private " +
                "because it should not be accessed directly in child classes. " +
                "It should be `final` because its readonly and has type 'String'");

        Optional<Field> salaryField = Arrays.stream(declaredFields)
                .filter(f -> f.getName().equals("salary"))
                .filter(f -> Modifier.isPrivate(f.getModifiers())
                        && Modifier.isFinal(f.getModifiers())
                        && f.getType() == BigDecimal.class)
                .findAny();
        assertTrue(salaryField.isPresent(), "'salary' must be private " +
                "because it should not be accessed directly in child classes. " +
                "It should be `final` because its readonly. " +
                "It must has type 'BigDecimal' because its money");

        Optional<Field> bonusField = Arrays.stream(declaredFields)
                .filter(f -> f.getName().equals("bonus"))
                .filter(f -> Modifier.isPrivate(f.getModifiers())
                        && f.getType() == BigDecimal.class)
                .findAny();
        assertTrue(bonusField.isPresent(), "'bonus' must be private " +
                "because 'setBonus()' must be overridden due the specification. " +
                "It must has type 'BigDecimal' because it's money");

        Method[] declaredMethods = employeeClass.getDeclaredMethods();
        Optional<Method> getName = Arrays.stream(declaredMethods)
                .filter(f -> f.getName().equals("getName"))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .findAny();
        assertTrue(getName.isPresent(), "The public method 'getName' must be present " +
                "because 'name' is property");

        Optional<Method> setName = Arrays.stream(declaredMethods)
                .filter(f -> f.getName().equals("setName"))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .findAny();
        assertFalse(setName.isPresent(), "The method 'setName' must not be present " +
                "because 'name' is readonly property");

        Optional<Method> getSalary = Arrays.stream(declaredMethods)
                .filter(f -> f.getName().equals("getSalary"))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .findAny();
        assertTrue(getSalary.isPresent(), "The public method 'getSalary' must be present");

        Optional<Method> setSalary = Arrays.stream(declaredMethods)
                .filter(f -> f.getName().equals("setSalary"))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .findAny();
        assertFalse(setSalary.isPresent(), "The public method 'setSalary' must not be present " +
                "because 'salary' is readonly property");

        Optional<Method> setBonus = Arrays.stream(declaredMethods)
                .filter(f -> f.getName().equals("setBonus"))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .findAny();
        assertTrue(setBonus.isPresent(), "The public method 'setBonus' must be present");

        Optional<Method> getBonus = Arrays.stream(declaredMethods)
                .filter(f -> f.getName().equals("getBonus"))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .findAny();
        assertFalse(getBonus.isPresent(), "The public method 'getBonus' " +
                "must not be present due the specification");

        Optional<Method> toPay = Arrays.stream(declaredMethods)
                .filter(f -> f.getName().equals("toPay"))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .findAny();
        assertTrue(toPay.isPresent(), "The public method 'toPay' " +
                "must be present due the specification");
    }

    @Test
    void testSalesPersonCodeCompliance() {
        Class<SalesPerson> salesPersonClass = SalesPerson.class;

        Field[] declaredFields = salesPersonClass.getDeclaredFields();
        assertEquals(1, declaredFields.length);

        Optional<Field> percentField = Arrays.stream(declaredFields)
                .filter(f -> f.getName().equals("percent"))
                .filter(f -> Modifier.isPrivate(f.getModifiers())
                        && Modifier.isFinal(f.getModifiers())
                        && f.getType() == Integer.TYPE)
                .findAny();
        assertTrue(percentField.isPresent(), "'percent' must be private final and has type 'int'");

        assertEquals(Employee.class, salesPersonClass.getSuperclass(),
                "'SalesPerson' must directly inherit 'Employee'");
    }

    @Test
    void testManagerCompliance() {
        Class<Manager> managerClass = Manager.class;

        Field[] declaredFields = managerClass.getDeclaredFields();
        assertEquals(1, declaredFields.length);

        Optional<Field> clientAmount = Arrays.stream(declaredFields)
                .filter(f -> f.getName().equals("clientAmount"))
                .filter(f -> Modifier.isPrivate(f.getModifiers())
                        && Modifier.isFinal(f.getModifiers())
                        && f.getType() == Integer.TYPE)
                .findAny();
        assertTrue(clientAmount.isPresent(), "'clientAmount' must be private final and has type 'int'");

        assertEquals(Employee.class, managerClass.getSuperclass(),
                "'Manager' must directly inherit 'Employee'");
    }
}