package nl.danibaas.dailyhelper.utilities;

import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;
import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;

public class PasswordChecker {

    public void checkPassword() {
        EditText passwordField = MainActivity.getInstance().findViewById(R.id.PasswordEntry);
        final String pw = "IMadeThisMyself#2020";
        if (passwordField.getText().toString().equals(pw)) {
            MainActivity.getInstance().screen.setContentView(Screens.MAIN_SCREEN);
        } else {
            showToast();
        }
    }

    private void showToast() { // displays message when the player enters incorrect password
        Context context = MainActivity.getInstance().getApplicationContext();
        String message = "Incorrect password, please try again.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, Html.fromHtml("<font color='#FF0000'>" + message + "</font>", 0), duration);
        toast.show();
    }
}
