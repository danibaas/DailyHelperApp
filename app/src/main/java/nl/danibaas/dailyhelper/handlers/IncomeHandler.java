package nl.danibaas.dailyhelper.handlers;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;
import nl.danibaas.dailyhelper.objects.ExpenseObject;
import nl.danibaas.dailyhelper.objects.IncomeObject;
import nl.danibaas.dailyhelper.utilities.Formatter;

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

    public void removeItem(IncomeObject obj) {
        objects.remove(obj);
        adapter.notifyDataSetChanged();
    }

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalIncome);
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
