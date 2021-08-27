package nl.danibaas.dailyhelper.objects;

import java.time.Instant;

public class ExpenseObject extends FinanceObject {

    public ExpenseObject(String name, double amount, Instant dateOfExpense, FinanceType type) {
        super(name, amount, dateOfExpense, type);
    }
}
