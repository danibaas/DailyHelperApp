package nl.danibaas.dailyhelper;

import nl.danibaas.dailyhelper.utilities.Screens;

public class ScreenHandler {

    Screens currentScreen;

    public ScreenHandler() {
        fixChildren();
        currentScreen = Screens.MAIN_SCREEN;
    }

    public void setContentView(Screens screen) {
        currentScreen = screen;
        MainActivity.getInstance().setContentView(currentScreen.getId());
    }

    public void goBack() {
        if (currentScreen.getParent() == null) {
            MainActivity.getInstance().finish();
            return;
        }
        MainActivity.getInstance().setContentView(currentScreen.getParent().getId());
        currentScreen = currentScreen.getParent();
    }

    public void fixChildren() {
        Screens.MAIN_SCREEN.setChilds(Screens.BANKING_SCREEN, Screens.WEIGHT_SCREEN);
        Screens.BANKING_SCREEN.setChilds(Screens.EXPENSES_SCREEN, Screens.INCOME_SCREEN);
    }
}
