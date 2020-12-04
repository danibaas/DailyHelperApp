package nl.danibaas.dailyhelper;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private boolean hqMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeHQMode(boolean newValue) {
        hqMode = newValue;
        if (newValue) {
            // TODO: set hq mode pictures
            ImageView imv = findViewById(R.id.background);
            imv.setImageResource(R.drawable.hq1);
        } else {
            // TODO: set safe mode pictures
        }
    }

    public void LoginButtonClick(View view) {
        changeHQMode(!hqMode);
    }
}