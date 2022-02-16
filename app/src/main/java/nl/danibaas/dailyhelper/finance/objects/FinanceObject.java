package nl.danibaas.dailyhelper.finance.objects;

import java.time.Instant;

public abstract class FinanceObject {
    private String name = null;
    private double amount = 0d;
    private Instant dateOfExpense = null;
    private FinanceType type;

    public enum FinanceType {
        EXPENSE, INCOME
    }

    public FinanceObject(String name, double amount, Instant dateOfExpense, FinanceType type) {
        this.name = name;
        this.amount = amount;
        this.dateOfExpense = dateOfExpense;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public Instant getDate() {
        return dateOfExpense;
    }

    public FinanceType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Instant dateOfExpense) {
        this.dateOfExpense = dateOfExpense;
    }
}
