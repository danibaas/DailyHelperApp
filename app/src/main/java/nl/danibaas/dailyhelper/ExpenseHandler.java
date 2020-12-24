package nl.danibaas.dailyhelper;

import android.widget.ArrayAdapter;
import android.widget.TextView;
import nl.danibaas.dailyhelper.objects.ExpenseObject;
import nl.danibaas.dailyhelper.utilities.Formatter;

import java.util.ArrayList;

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

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalExpenses);
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
