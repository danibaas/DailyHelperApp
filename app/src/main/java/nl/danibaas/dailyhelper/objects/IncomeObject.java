package nl.danibaas.dailyhelper.objects;

import java.util.Date;

public class IncomeObject extends FinanceObject {

    public IncomeObject(String name, double amount, Date dateOfExpense, FinanceType type) {
        super(name, amount, dateOfExpense, type);
    }
}
