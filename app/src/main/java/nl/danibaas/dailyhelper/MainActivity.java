package nl.danibaas.dailyhelper;

import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import nl.danibaas.dailyhelper.handlers.ScreenHandler;
import nl.danibaas.dailyhelper.utilities.PasswordChecker;
import nl.danibaas.dailyhelper.utilities.Screens;

public class MainActivity extends AppCompatActivity {

    // Self created objects
    public PasswordChecker pw;
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
        banking = new Banking();
        screen = new ScreenHandler();
        setContentView(R.layout.activity_main);
    }

    public void loginButtonClick(View view) {
        screen.setContentView(Screens.LOGIN_SCREEN);
    }

    public void loginButton(View view) {
        pw.checkPassword();
    }

    public void modeSwitch(View view) { // when mode switch button is clicked
        screen.getSwitch().switchModes(!screen.getSwitch().getMode());
    }

    public void showPassword(View view) {
        pw.showPassword(!pw.IsShowingPassword());
    }

    // banking buttons
    public void bankingButton(View view) {
        screen.setContentView(Screens.BANKING_SCREEN);
        banking.refreshTotal();
    }

    public void totalButton(View view) {
        banking.refreshTotal();
    }

    // MONEY START
    // expenses
    public void expensesButton(View view) {
        screen.setContentView(Screens.EXPENSES_SCREEN);
        ListView lv = findViewById(R.id.AllExpenses);
        lv.setAdapter(banking.getExpenseHandler().getAdapter());
        banking.getExpenseHandler().refreshTotal();
    }

    public void addExpensesButton(View view) {
        screen.setContentView(Screens.ADD_EXPENSES_SCREEN);
    }

    public void totalExpenses(View view) {
        banking.getExpenseHandler().refreshTotal();
    }

    // income
    public void incomeButton(View view) {
        screen.setContentView(Screens.INCOME_SCREEN);
        ListView lv = findViewById(R.id.AllIncome);
        lv.setAdapter(banking.getIncomeHandler().getAdapter());
        banking.getIncomeHandler().refreshTotal();
    }

    public void addIncomeButton(View view) {
        screen.setContentView(Screens.ADD_INCOME_SCREEN);
    }

    public void totalIncome(View view) {
        banking.getIncomeHandler().refreshTotal();
    }
    // MONEY END

    public void backButton(View view) {
        screen.goBack();
    }

    // weight button
    public void weightButton(View view) {
        // TODO: open weight page
    }


}