package nl.danibaas.dailyhelper;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nl.danibaas.dailyhelper.handlers.ExpenseHandler;
import nl.danibaas.dailyhelper.handlers.IncomeHandler;
import nl.danibaas.dailyhelper.utilities.Formatter;

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
        final double expn = expenses.getTotal();
        final double incm = income.getTotal();
        return incm - expn;
    }

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalMoney);
        String text = MainActivity.getInstance().getString(R.string.banking_total) + " ";
        String toAdd = "0";
        final double total = getTotal();
        try {
            toAdd = Formatter.formatDouble(getTotal());
        } catch (NullPointerException e) {
            System.out.println("Number was not formattable! " + e);
            toAdd = getTotal() + "";
        } finally {
            text += toAdd;
            tv.setText(text);
        }
        ListView lv = MainActivity.getInstance().findViewById(R.id.HomeIncome);
        ArrayList<String> income = reverse(getIncomeHandler().getFormattedObjects());
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.getInstance(), R.layout.banking_object, R.id.IncomeName, income);
        lv.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        ListView lv2 = MainActivity.getInstance().findViewById(R.id.HomeExpense);
        ArrayList<String> expenses = reverse(getExpenseHandler().getFormattedObjects());
        final ArrayAdapter<String> arrayAdapterV2 = new ArrayAdapter<>(MainActivity.getInstance(), R.layout.banking_object, R.id.ExpenseName, expenses);
        lv2.setAdapter(arrayAdapterV2);
        arrayAdapterV2.notifyDataSetChanged();
    }

    private ArrayList<String> reverse(ArrayList<String> toRev) {
        ArrayList<String> reversed = new ArrayList<>();
        for (int i = toRev.size() - 1; i >= 0; i--) {
            reversed.add(toRev.get(i));
        }
        return reversed;
    }
}
