package nl.danibaas.dailyhelper.objects;

import java.time.Instant;

public class IncomeObject extends FinanceObject {

    public IncomeObject(String name, double amount, Instant dateOfExpense, FinanceType type) {
        super(name, amount, dateOfExpense, type);
    }
}
