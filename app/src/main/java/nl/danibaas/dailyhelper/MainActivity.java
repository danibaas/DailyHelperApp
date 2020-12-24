package nl.danibaas.dailyhelper;

import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import nl.danibaas.dailyhelper.utilities.ModeSwitcher;
import nl.danibaas.dailyhelper.utilities.PasswordChecker;
import nl.danibaas.dailyhelper.utilities.Screens;

public class MainActivity extends AppCompatActivity {

    // Self created objects
    public PasswordChecker pw;
    public ModeSwitcher mode;
    public Banking banking;
    public ScreenHandler screen;

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        pw = new PasswordChecker();
        mode = new ModeSwitcher();
        banking = new Banking();
        screen = new ScreenHandler();
        setContentView(R.layout.activity_main);
    }

    public void loginButtonClick(View view) {
        setContentView(R.layout.login_screen);
    }

    public void loginButton(View view) {
        pw.checkPassword();
    }

    public void modeSwitch(View view) { // when mode switch button is clicked
        mode.switchModes(!mode.getMode());
    }

    // banking buttons
    public void bankingButton(View view) {
        screen.setContentView(Screens.BANKING_SCREEN);
        banking.refreshTotal();
        mode.refresh();
    }

    public void totalButton(View view) {
        banking.refreshTotal();
    }

    // expenses
    public void expensesButton(View view) {
        screen.setContentView(Screens.EXPENSES_SCREEN);
        ListView lv = findViewById(R.id.AllExpenses);
        lv.setAdapter(banking.getHandler().getAdapter());
        banking.getHandler().refreshTotal();
        mode.refresh();
    }

    public void backButton(View view) {
        screen.goBack();
    }

    public void totalExpenses(View view) {
        banking.getHandler().refreshTotal();
    }

    // weight button
    public void weightButton(View view) {
        // TODO: open weight page
    }
}