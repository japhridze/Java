package com.epam.rd.qa.inheritance;

import java.math.BigDecimal;

public class Company {
    private final Employee[] employees;

    public Company(Employee[] employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employees array cannot be null");
        }
        this.employees = employees;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus) {
        for (Employee emp : employees) {
            emp.setBonus(companyBonus);
        }
    }

    public BigDecimal totalToPay() {
        BigDecimal totalSalary = BigDecimal.ZERO;
        for (Employee emp : employees) {
            totalSalary = totalSalary.add(emp.toPay());
        }
        return totalSalary;
    }

    public String nameMaxSalary() {
        if (employees.length == 0) {
            return null;
        }

        Employee maxPaidEmployee = employees[0];
        for (int i = 1; i < employees.length; i++) {
            if (employees[i].toPay().compareTo(maxPaidEmployee.toPay()) > 0) {
                maxPaidEmployee = employees[i];
            }
        }
        return maxPaidEmployee.getName();
    }


}