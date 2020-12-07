package nl.danibaas.dailyhelper;

import android.widget.ImageView;

public class ModeSwitcher {

    boolean jokerMode = true;

    public void switchModes(boolean jokerMode) { // change background picture modes
        this.jokerMode = jokerMode;
        switchImages(jokerMode);
    }

    private void switchImages(boolean jokerMode) {
        ImageView mainBackground = MainActivity.getInstance().findViewById(R.id.MainBackground);
        ImageView homeScreenBackground = MainActivity.getInstance().findViewById(R.id.HomeBackground);
        if (jokerMode) { // joker mode
            if (mainBackground != null) {
                mainBackground.setImageResource(R.drawable.joker);
            } else {
                homeScreenBackground.setImageResource(R.drawable.joker1);
            }
        } else { // harley quinn mode
            if (mainBackground != null) {
                mainBackground.setImageResource(R.drawable.hq1);
            } else {
                homeScreenBackground.setImageResource(R.drawable.hq);
            }
        }
    }
}
