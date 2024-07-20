package com.epam.rd.qa.inheritance;

import java.math.BigDecimal;

public class SalesPerson extends Employee {
    private final int percent;

    public SalesPerson(String name, BigDecimal salary, int percent) {
        super(name, salary);

        if (percent < 0) {
            throw new IllegalArgumentException("Percent must be greater than or equal to zero");
        }
        this.percent = percent;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        if (bonus == null || bonus.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bonus must be greater than zero");
        }

        BigDecimal multiplier = BigDecimal.valueOf(1);

        if (percent > 200) {
            multiplier = BigDecimal.valueOf(3);
        } else if (percent > 100) {
            multiplier = BigDecimal.valueOf(2);
        }

        super.setBonus(bonus.multiply(multiplier));
    }
}