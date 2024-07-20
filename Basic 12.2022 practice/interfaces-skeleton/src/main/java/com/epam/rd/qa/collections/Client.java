package com.epam.rd.qa.collections;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Client implements Iterable<Deposit> {
    private final Deposit[] deposits;

    public Client() {
        this.deposits = new Deposit[10];
    }

    public Client(Deposit[] initialDeposits) {
        if (initialDeposits == null) {
            throw new IllegalArgumentException("Initial deposits cannot be null.");
        }
        this.deposits = new Deposit[10];
        System.arraycopy(initialDeposits, 0, this.deposits, 0, Math.min(initialDeposits.length, 10));
    }

    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome() {
        return Arrays.stream(deposits)
                .filter(java.util.Objects::nonNull)
                .map(Deposit::income)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal maxIncome() {
        return Arrays.stream(deposits)
                .filter(java.util.Objects::nonNull)
                .map(Deposit::income)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (number >= 0 && number < deposits.length && deposits[number] != null) {
            return deposits[number].income();
        }
        return BigDecimal.ZERO;
    }

    // Newly added method based on your requirement
    public void sortDeposits() {
        Arrays.sort(deposits, (a, b) -> {
            if (a == null && b == null) return 0;
            if (a == null) return 1;
            if (b == null) return -1;
            return b.totalAmount().compareTo(a.totalAmount());
        });
    }

    // Newly added method based on your requirement
    public int countPossibleToProlongDeposit() {
        return (int) Arrays.stream(deposits)
                .filter(java.util.Objects::nonNull)
                .filter(deposit -> deposit instanceof Prolongable && ((Prolongable) deposit).canToProlong())
                .count();
    }

    @Override
    public Iterator<Deposit> iterator() {
        return new Iterator<Deposit>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                while (currentIndex < deposits.length && deposits[currentIndex] == null) {
                    currentIndex++;
                }
                return currentIndex < deposits.length;
            }

            @Override
            public Deposit next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return deposits[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation is not supported.");
            }
        };
    }
}
