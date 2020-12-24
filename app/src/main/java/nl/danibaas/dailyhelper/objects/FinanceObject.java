package nl.danibaas.dailyhelper.objects;

import java.util.Date;

public abstract class FinanceObject {
    private String name = null;
    private double amount = 0d;
    private Date dateOfExpense = null;
    private FinanceType type;

    public enum FinanceType {
        EXPENSE, INCOME
    }

    public FinanceObject(String name, double amount, Date dateOfExpense, FinanceType type) {
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

    public Date getDate() {
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

    public void setDate(Date dateOfExpense) {
        this.dateOfExpense = dateOfExpense;
    }
}
