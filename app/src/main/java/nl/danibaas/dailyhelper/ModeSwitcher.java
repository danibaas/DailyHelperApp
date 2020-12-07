package nl.danibaas.dailyhelper;

import android.widget.ImageView;

public class ModeSwitcher {

    boolean jokerMode = true;

    public void switchModes(boolean jokerMode) { // change background picture modes
        this.jokerMode = jokerMode;
        ImageView mainBackground = MainActivity.getInstance().findViewById(R.id.MainBackground);
        ImageView homeScreenBackground = MainActivity.getInstance().findViewById(R.id.HomeBackground);
        if (jokerMode) { // joker mode
            mainBackground.setImageResource(R.drawable.joker);
            homeScreenBackground.setImageResource(R.drawable.joker1);
        } else { // harley quinn mode
            mainBackground.setImageResource(R.drawable.hq1);
            homeScreenBackground.setImageResource(R.drawable.hq);
        }
    }
}
