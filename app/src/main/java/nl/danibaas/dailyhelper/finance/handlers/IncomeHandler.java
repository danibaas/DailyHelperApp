package nl.danibaas.dailyhelper.finance.handlers;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;

import java.time.Instant;
import java.util.ArrayList;

import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;
import nl.danibaas.dailyhelper.finance.objects.FinanceObject;
import nl.danibaas.dailyhelper.finance.objects.IncomeObject;
import nl.danibaas.dailyhelper.utilities.CustomToast;
import nl.danibaas.dailyhelper.utilities.Formatter;
import nl.danibaas.dailyhelper.utilities.Screens;

public class IncomeHandler {
    private ArrayList<IncomeObject> objects = new ArrayList<>();
    private ArrayAdapter<IncomeObject> adapter;

    public IncomeHandler() {
        adapter = new ArrayAdapter<>(MainActivity.getInstance().getApplicationContext(), R.layout.banking_income_screen, objects);
    }

    public ArrayAdapter<IncomeObject> getAdapter() {
        return adapter;
    }

    public double getTotal() {
        double total = 0;
        for (IncomeObject obj : objects) {
            total += obj.getAmount();
        }
        return total;
    }

    public void addItem(IncomeObject obj) {
        objects.add(obj);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<String> getFormattedObjects() {
        ArrayList<String> objs = new ArrayList<>();
        for (IncomeObject obj : objects) {
            objs.add(obj.getName() + "   " + obj.getAmount());
        }
        return objs;
    }

    public void removeItem(IncomeObject obj) {
        objects.remove(obj);
        adapter.notifyDataSetChanged();
    }

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalIncome);
        String text = MainActivity.getInstance().getString(R.string.banking_total) + " ";
        String toAdd = "0";
        final double total = getTotal();
        if (total > 0) {
            try {
                toAdd = Formatter.formatDouble(getTotal());
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
        if (MainActivity.getInstance().screen.getCurrentScreen() == Screens.INCOME_SCREEN) {
            ListView lv = MainActivity.getInstance().findViewById(R.id.AllIncome);
            ArrayList<String> income = getFormattedObjects();
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.getInstance(), R.layout.banking_object, R.id.IncomeName, income);
            lv.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public boolean addIncome() {
        if (MainActivity.getInstance().screen.getCurrentScreen() == Screens.ADD_INCOME_SCREEN) {
            AppCompatEditText txt = MainActivity.getInstance().findViewById(R.id.IncomeNameInput);
            AppCompatEditText money = MainActivity.getInstance().findViewById(R.id.IncomeAmountInput);
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
            IncomeObject obj = new IncomeObject(name, parsedMoney, Instant.now(), FinanceObject.FinanceType.INCOME);
            addItem(obj);
            return true;
        }
        return false;
    }
}
