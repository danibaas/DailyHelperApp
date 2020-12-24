package nl.danibaas.dailyhelper.objects;

import java.util.Date;

public class ExpenseObject extends FinanceObject {

    public ExpenseObject(String name, double amount, Date dateOfExpense, FinanceType type) {
        super(name, amount, dateOfExpense, type);
    }
}
