package nl.danibaas.dailyhelper;

import android.widget.EditText;

public class PasswordChecker {

    public void checkPassword() {
        EditText passwordField = MainActivity.getInstance().findViewById(R.id.PasswordEntry);
        final String pw = "IMadeThisMyself#2020";
        if (passwordField.getText().toString().equals(pw)) {
            // TODO: Direct onto main screen (user is now logged in)
            System.out.println("logged in");
        }
    }
}
