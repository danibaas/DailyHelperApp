package nl.danibaas.dailyhelper.finance;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;
import nl.danibaas.dailyhelper.finance.handlers.ExpenseHandler;
import nl.danibaas.dailyhelper.finance.handlers.IncomeHandler;
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
        return income.getTotal() - expenses.getTotal();
    }

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalMoney);
        String text = MainActivity.getInstance().getString(R.string.banking_total) + " ";
        if (Formatter.canFormat(getTotal())) {
            text += Formatter.formatDouble(getTotal());
        } else {
            return;
        }
        tv.setText(text);
        setListViewAdapter(MainActivity.getInstance().findViewById(R.id.HomeIncome), reverse(getIncomeHandler().getFormattedObjects()), R.layout.banking_object, R.id.IncomeName);
        setListViewAdapter(MainActivity.getInstance().findViewById(R.id.HomeExpense), reverse(getExpenseHandler().getFormattedObjects()), R.layout.banking_object, R.id.ExpenseName);
    }

    private ArrayList<String> reverse(ArrayList<String> toRev) {
        ArrayList<String> reversed = new ArrayList<>();
        for (int i = toRev.size() - 1; i >= 0; i--) {
            reversed.add(toRev.get(i));
        }
        return reversed;
    }

    public void setListViewAdapter(ListView lv, ArrayList<String> objs, int layout, int textViewID) {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.getInstance(), layout, textViewID, objs);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
