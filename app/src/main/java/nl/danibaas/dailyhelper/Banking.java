package nl.danibaas.dailyhelper;

import android.widget.TextView;

import java.util.Random;

public class Banking {

    private double getTotal() {
        // TODO: Calculate total and return it
        Random random = new Random();
        return random.nextDouble() * 100;
    }

    public void refreshTotal() {
        TextView tv = MainActivity.getInstance().findViewById(R.id.TotalMoney);
        tv.setText(MainActivity.getInstance().getString(R.string.banking_total) + " " + formatNumber(getTotal()));
    }

    private String formatNumber(double amount) {
        String total = amount + "";
        String[] split = total.split("\\.");
        return split[0] + "." + split[1].substring(0, 2);
    }
}
