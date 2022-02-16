package nl.danibaas.dailyhelper.utilities;

import android.content.Context;
import android.text.Html;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;

public class PasswordChecker {
    private boolean showPassword;

    public void checkPassword() {
        EditText passwordField = MainActivity.getInstance().findViewById(R.id.PasswordEntry);
        final String pw = "IMadeThisMyself#2020";
        if (passwordField.getText().toString().equals(pw)) {
            MainActivity.getInstance().screen.setContentView(Screens.MAIN_SCREEN);
        } else {
            CustomToast.PASSWORD.showToast();
        }
    }

    public void showPassword(boolean show) {
        EditText password = MainActivity.getInstance().findViewById(R.id.PasswordEntry);
        showPassword = show;
        password.setTransformationMethod(show ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
        password.setSelection(password.length());
    }

    public boolean IsShowingPassword() {
        return showPassword;
    }
}
