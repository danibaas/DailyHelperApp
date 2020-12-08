package nl.danibaas.dailyhelper;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Self created objects
    public PasswordChecker pw;
    public ModeSwitcher mode;

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
        setContentView(R.layout.activity_main);
    }

    public void loginButtonClick(View view) {
        setContentView(R.layout.login_screen);
    }

    public void loginButton(View view) {
        pw.checkPassword();
    }

    public void bankingButton(View view) {
        setContentView(R.layout.banking_screen);
    }

    public void weightButton(View view) {
        // TODO: open weight page
    }

    public void modeSwitch(View view) { // when mode switch button is clicked
        mode.switchModes(!mode.jokerMode);
    }
}