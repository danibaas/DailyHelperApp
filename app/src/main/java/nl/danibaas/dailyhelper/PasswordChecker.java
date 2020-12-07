package nl.danibaas.dailyhelper;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.EditText;

public class PasswordChecker {

    private final String pw = "IMadeThisMyself#2020";

    public void checkPassword() {
        EditText passwordField = MainActivity.getInstance().findViewById(R.id.PasswordEntry);
        if (passwordField.getText().toString().equals(pw)) {
            // TODO: Direct onto main screen (user is now logged in)
            System.out.println("logged in");
        }
    }
}
