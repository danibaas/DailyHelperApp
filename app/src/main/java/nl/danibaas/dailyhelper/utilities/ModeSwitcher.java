package nl.danibaas.dailyhelper.utilities;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;

public class ModeSwitcher {

    boolean jokerMode = true;

    public void switchModes(boolean jokerMode) { // change background picture modes
        this.jokerMode = jokerMode;
        switchImages(jokerMode);
    }

    public void refresh() {
        switchImages(jokerMode);
        androidx.appcompat.widget.SwitchCompat jkMode = MainActivity.getInstance().findViewById(R.id.JokerMode);
        if (jkMode != null) jkMode.setChecked(!jokerMode);
    }

    public boolean getMode() {
        return jokerMode;
    }

    private void switchImages(boolean jokerMode) {
        ImageView mainBackground = MainActivity.getInstance().findViewById(R.id.MainBackground);
        ImageView homeScreenBackground = MainActivity.getInstance().findViewById(R.id.HomeBackground);
        ImageView bankingBackground = MainActivity.getInstance().findViewById(R.id.BankingBackground);
        ImageView expensesBackground = MainActivity.getInstance().findViewById(R.id.ExpensesBackground);
        ImageView incomeBackground = MainActivity.getInstance().findViewById(R.id.IncomeBackground);
        TextView homeScreenText = MainActivity.getInstance().findViewById(R.id.welcomeText);
        TextView expensesScreenText = MainActivity.getInstance().findViewById(R.id.Expenses);
        if (jokerMode) { // joker mode
            if (mainBackground != null) {
                mainBackground.setImageResource(R.drawable.joker);
                return;
            }
            if (homeScreenBackground != null){
                homeScreenBackground.setImageResource(R.drawable.joker1);
                homeScreenText.setTextColor(Color.WHITE);
                return;
            }
            if (bankingBackground != null) {
                bankingBackground.setImageResource(R.drawable.joker1);
                homeScreenText.setTextColor(Color.WHITE);
                return;
            }
            if (expensesBackground != null) {
                expensesBackground.setImageResource(R.drawable.joker1);
                if (expensesScreenText != null) expensesScreenText.setTextColor(Color.WHITE);
            }
            if (incomeBackground != null) {
                incomeBackground.setImageResource((R.drawable.joker1));
                // TODO: text?
            }
        } else { // harley quinn mode
            if (mainBackground != null) {
                mainBackground.setImageResource(R.drawable.hq1);
                return;
            }
            if (homeScreenBackground != null){
                homeScreenBackground.setImageResource(R.drawable.hq4proper);
                homeScreenText.setTextColor(Color.BLACK);
                return;
            }
            if (bankingBackground != null) {
                bankingBackground.setImageResource(R.drawable.hq2proper);
                homeScreenText.setTextColor(Color.BLACK);
                return;
            }
            if (expensesBackground != null) {
                expensesBackground.setImageResource(R.drawable.hq2proper);
                expensesScreenText.setTextColor(Color.BLACK);
            }
            if (incomeBackground != null) {
                incomeBackground.setImageResource((R.drawable.hq3));
                // TODO: text?
            }
        }
    }
}
