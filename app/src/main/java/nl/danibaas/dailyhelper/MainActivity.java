package nl.danibaas.dailyhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import nl.danibaas.dailyhelper.anime.Anime;
import nl.danibaas.dailyhelper.anime.PageOptions;
import nl.danibaas.dailyhelper.finance.Banking;
import nl.danibaas.dailyhelper.finance.handlers.ScreenHandler;
import nl.danibaas.dailyhelper.utilities.PasswordChecker;
import nl.danibaas.dailyhelper.utilities.Screens;

public class MainActivity extends AppCompatActivity {

    // Self created objects
    public PasswordChecker pw;
    public Banking banking;
    public ScreenHandler screen;
    public Anime anime;

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
        anime = new Anime();
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

    public void addExpense(View view) {
        if (banking.getExpenseHandler().addExpense()) {
            screen.goBack();
            banking.getExpenseHandler().refreshTotal();
        }
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

    public void addIncome(View view) {
        if (banking.getIncomeHandler().addIncome()) {
            screen.goBack();
            banking.getIncomeHandler().refreshTotal();
        }
    }

    public void totalIncome(View view) {
        banking.getIncomeHandler().refreshTotal();
    }
    // MONEY END

    public void backButton(View view) {
        screen.goBack();
        if (screen.getCurrentScreen() == Screens.BANKING_SCREEN) {
            banking.refreshTotal();
        }
    }

    public void exit(View view) {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }

    // mental button
    public void mentalButton(View view) {
        screen.setContentView(Screens.MENTAL_SCREEN);
    }

    /// Anime section
    // anime button
    public void animeButton(View view) {
        screen.setContentView(Screens.ANIME_SCREEN);
    }

    public void animeViewButton(View view) {
        screen.setContentView(Screens.ANIME_VIEW_SCREEN);
        if (anime.firstTime) {
            anime.loadPage(PageOptions.ANIME_LOGIN);
            anime.firstTime = false;
        } else {
            anime.loadPage(PageOptions.ANIME);
        }
    }

    public void animeListButton(View view) {
        anime.loadPage(PageOptions.ANIME);
    }

    public void animeHomeButton(View view) {
        anime.loadPage(PageOptions.ANIME_HOME);
    }

    public void animeWatchingButton(View view) {
        anime.loadPage(PageOptions.ANIME_WATCHING);
    }

    public void animeCompletedButton(View view) {
        anime.loadPage(PageOptions.ANIME_COMPLETED);
    }

    public void animeDroppedButton(View view) {
        anime.loadPage(PageOptions.ANIME_DROPPED);
    }

    public void animePlanningButton(View view) {
        anime.loadPage(PageOptions.ANIME_PLANNING);
    }

    // manga
    public void mangaButton(View view) {
        screen.setContentView(Screens.MANGA_SCREEN);
        if (anime.firstTime) {
            anime.loadPage(PageOptions.ANIME_LOGIN);
            anime.firstTime = false;
        } else {
            anime.loadPage(PageOptions.MANGA);
        }
    }

    public void mangaListButton(View view) {
        anime.loadPage(PageOptions.MANGA);
    }

    public void mangaReadingButton(View view) {
        anime.loadPage(PageOptions.MANGA_READING);
    }

    public void mangaCompleted(View view) {
        anime.loadPage(PageOptions.MANGA_COMPLETED);
    }

    public void mangaPlanning(View view) {
        anime.loadPage(PageOptions.MANGA_PLANNING);
    }
}