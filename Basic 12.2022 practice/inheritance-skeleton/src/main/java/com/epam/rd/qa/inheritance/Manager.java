package com.epam.rd.qa.inheritance;

import java.math.BigDecimal;

public class Manager extends Employee {
    private final int clientAmount;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        if (clientAmount < 0) {
            throw new IllegalArgumentException("Client amount cannot be negative");
        }
        this.clientAmount = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        if (bonus == null || bonus.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bonus must be greater than zero");
        }

        BigDecimal newBonus;
        if (clientAmount > 150) {
            newBonus = bonus.add(new BigDecimal(1000));
        } else if (clientAmount > 100) {
            newBonus = bonus.add(new BigDecimal(500));
        } else {
            newBonus = bonus;
        }
        super.setBonus(newBonus);
    }
}