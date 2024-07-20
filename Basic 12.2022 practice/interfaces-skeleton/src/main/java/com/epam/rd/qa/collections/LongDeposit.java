package com.epam.rd.qa.collections;
 

import java.math.BigDecimal;

public class LongDeposit extends Deposit implements Prolongable {
    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        if (period <= 6) return BigDecimal.ZERO;
        BigDecimal currentAmount = amount;
        for (int i = 7; i <= period; i++) {
            currentAmount = currentAmount.multiply(BigDecimal.valueOf(1.15));
        }
        return currentAmount.subtract(amount).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public boolean canToProlong() {
        return period <= 36;
    }
}
