package com.epam.rd.qa.collections;


import java.math.BigDecimal;

public abstract class Deposit implements Comparable<Deposit> {
    protected final BigDecimal amount;
    protected final int period;

    public Deposit(BigDecimal depositAmount, int depositPeriod) {
        if (depositAmount.compareTo(BigDecimal.ZERO) <= 0 || depositPeriod <= 0) {
            throw new IllegalArgumentException("Deposit amount and period must be greater than 0.");
        }
        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income();

    @Override
    public int compareTo(Deposit o) {
        return this.totalAmount().compareTo(o.totalAmount());
    }

    protected BigDecimal totalAmount() {
        return amount.add(income());
    }
}
