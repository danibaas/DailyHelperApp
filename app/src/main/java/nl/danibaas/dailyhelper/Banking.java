package nl.danibaas.dailyhelper;

import android.widget.TextView;
import nl.danibaas.dailyhelper.utilities.Formatter;

import java.util.Random;

public class Banking {
    private ExpenseHandler expenses;

    public Banking() {
        expenses = new ExpenseHandler();
    }

    public ExpenseHandler getHandler() {
        return expenses;
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
