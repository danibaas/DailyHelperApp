package nl.danibaas.dailyhelper.utilities;

import android.content.Context;
import android.text.Html;

import nl.danibaas.dailyhelper.MainActivity;

public enum CustomToast {

    PASSWORD("Incorrect password, please try again.", "#FF0000", 0, android.widget.Toast.LENGTH_LONG),
    INCORRECT_FINANCE_PARAM("Fields cannot be empty!", "#FF0000", 0, android.widget.Toast.LENGTH_LONG),
    NOT_A_NUMBER("Field must be a number!", "#FF0000", 0, android.widget.Toast.LENGTH_LONG);

    private final String msg;
    private final String color;
    private final int flags;
    private final int duration;

    CustomToast(String msg, String color, int flags, int duration) {
        this.msg = msg;
        this.color = color;
        this.flags = flags;
        this.duration = duration;
    }

    /**
     * Shows a toast for the enum with the corresponding message and color.
     */
    public void showToast() {
        Context context = MainActivity.getInstance().getApplicationContext();
        android.widget.Toast toast = android.widget.Toast.makeText(context, Html.fromHtml("<font color='" + color + "'>" + msg + "</font>", flags), duration);
        toast.show();
    }
}
