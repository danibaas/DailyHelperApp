package nl.danibaas.dailyhelper.finance.handlers;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;

import java.time.Instant;
import java.util.ArrayList;

import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;
import nl.danibaas.dailyhelper.finance.objects.ExpenseObject;
import nl.danibaas.dailyhelper.finance.objects.FinanceObject;
import nl.danibaas.dailyhelper.utilities.CustomToast;
import nl.danibaas.dailyhelper.utilities.Formatter;
import nl.danibaas.dailyhelper.utilities.Screens;

public class ExpenseHandler {
    private ArrayList<ExpenseObject> objects = new ArrayList<>();
    private ArrayAdapter<ExpenseObject> adapter;

    public ExpenseHandler() {
        adapter = new ArrayAdapter<>(MainActivity.getInstance().getApplicationContext(), R.layout.banking_expenses_screen, objects);
    }

    public ArrayAdapter<ExpenseObject> getAdapter() {
        return adapter;
    }

    public double getTotal() {
        double total = 0;
        if (objects.isEmpty()) return total;
        for (ExpenseObject obj : objects) {
            total += obj.getAmount();
        }
        return total;
    }

    public void addItem(ExpenseObject obj) {
        objects.add(obj);
        adapter.notifyDataSetChanged();
    }

    public void removeItem(ExpenseObject obj) {
        objects.remove(obj);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<String> getFormattedObjects() {
        ArrayList<String> objs = new ArrayList<>();
        for (ExpenseObject obj : objects) {
            objs.add(obj.getName() + "   " + obj.getAmount());
        }
        return objs;
    }

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalExpenses);
        String text = MainActivity.getInstance().getString(R.string.banking_total) + " ";
        String toAdd = "0";
        final double total = getTotal();
        if (total > 0) {
            try {
                if (Formatter.canFormat(getTotal())) {
                    toAdd = Formatter.formatDouble(getTotal());
                }
            } catch (NullPointerException e) {
                System.out.println("Number was not formattable! " + getTotal());
                toAdd = getTotal() + "";
            } finally {
                text += toAdd;
                tv.setText(text);
            }
        } else {
            text += toAdd;
            tv.setText(text);
        }
        if (MainActivity.getInstance().screen.getCurrentScreen() == Screens.EXPENSES_SCREEN) {
            ListView lv = MainActivity.getInstance().findViewById(R.id.AllExpenses);
            ArrayList<String> expenses = getFormattedObjects();
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.getInstance(), R.layout.banking_object, R.id.ExpenseName, expenses);
            lv.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public boolean addExpense() {
        if (MainActivity.getInstance().screen.getCurrentScreen() == Screens.ADD_EXPENSES_SCREEN) {
            AppCompatEditText txt = MainActivity.getInstance().findViewById(R.id.NameInput);
            AppCompatEditText money = MainActivity.getInstance().findViewById(R.id.AmountInput);
            if (txt.getText() == null || money.getText() == null) {
                CustomToast.INCORRECT_FINANCE_PARAM.showToast();
                return false;
            }
            String name = txt.getText().toString();
            String moneyString = money.getText().toString();
            double parsedMoney = 0;
            moneyString = Formatter.makeMonetary(moneyString);
            if (Formatter.isParsable(moneyString)) {
                parsedMoney = Formatter.parseDouble(moneyString);
                if (Formatter.canFormat(parsedMoney)) {
                    parsedMoney = Formatter.parseDouble(Formatter.formatDouble(parsedMoney));
                } else {
                    return false;
                }
            } else {
                return false;
            }
            ExpenseObject obj = new ExpenseObject(name, parsedMoney, Instant.now(), FinanceObject.FinanceType.EXPENSE);
            addItem(obj);
            return true;
        }
        return false;
    }
}
