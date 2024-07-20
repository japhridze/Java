package com.epam.rd.qa.collections;


import java.math.BigDecimal;

public class SpecialDeposit extends Deposit implements Prolongable {
    public SpecialDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal currentAmount = amount;
        for (int i = 1; i <= period; i++) {
            currentAmount = currentAmount.multiply(BigDecimal.valueOf(1 + (double) i / 100));
        }
        return currentAmount.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public boolean canToProlong() {
        return amount.compareTo(BigDecimal.valueOf(1000)) > 0;
    }
}
