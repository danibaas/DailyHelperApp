package nl.danibaas.dailyhelper;

import android.widget.TextView;

import nl.danibaas.dailyhelper.handlers.ExpenseHandler;
import nl.danibaas.dailyhelper.handlers.IncomeHandler;
import nl.danibaas.dailyhelper.utilities.Formatter;

import java.util.Random;

public class Banking {
    private ExpenseHandler expenses;
    private IncomeHandler income;

    public Banking() {
        expenses = new ExpenseHandler();
        income = new IncomeHandler();
    }

    public ExpenseHandler getExpenseHandler() {
        return expenses;
    }

    public IncomeHandler getIncomeHandler() {
        return income;
    }

    private double getTotal() {
        // TODO: Calculate total and return it
        Random random = new Random();
        return random.nextDouble() * 100;
    }

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalMoney);
        String text = MainActivity.getInstance().getString(R.string.banking_total) + " ";
        String toAdd = "0";
        try {
            toAdd = Formatter.formatDouble(getTotal());
        } catch (NullPointerException e) {
            System.out.println("Number was not formattable! " + e);
        } finally {
            text += toAdd;
            tv.setText(text);
        }
    }
}
