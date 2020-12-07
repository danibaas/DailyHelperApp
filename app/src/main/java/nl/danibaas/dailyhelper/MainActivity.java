package nl.danibaas.dailyhelper;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private boolean hqMode;
    public PasswordChecker pw;

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        pw = new PasswordChecker();
        setContentView(R.layout.activity_main);
    }

    private void changeHQMode(boolean newValue) { // change mode and all pictures
        hqMode = newValue;
        if (newValue) {
            // TODO: set hq mode pictures
            ImageView imv = findViewById(R.id.MainBackground);
            //imv.setImageResource(R.drawable.hq1);
        } else {
            // TODO: set safe mode pictures
        }
    }

    public void LoginButtonClick(View view) {
        setContentView(R.layout.login_screen);
    }

    public void LoginButton(View view) {
        pw.checkPassword();
    }
}