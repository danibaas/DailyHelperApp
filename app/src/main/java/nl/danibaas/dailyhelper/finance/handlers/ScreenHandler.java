package nl.danibaas.dailyhelper.finance.handlers;

import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.utilities.ModeSwitcher;
import nl.danibaas.dailyhelper.utilities.Screens;

public class ScreenHandler {

    private final ModeSwitcher switcher;
    private Screens currentScreen;

    public ScreenHandler() {
        fixChildren();
        currentScreen = Screens.MAIN_SCREEN;
        switcher = new ModeSwitcher();
    }

    public void setContentView(Screens screen) {
        currentScreen = screen;
        MainActivity.getInstance().setContentView(currentScreen.getId());
        switcher.refresh();
    }

    public void goBack() {
        if (currentScreen.getParent() == null) {
            MainActivity.getInstance().finish();
            return;
        }
        MainActivity.getInstance().setContentView(currentScreen.getParent().getId());
        currentScreen = currentScreen.getParent();
        switcher.refresh();
    }

    public Screens getCurrentScreen() {
        return currentScreen;
    }

    public void fixChildren() {
        Screens.MAIN_SCREEN.setChilds(Screens.BANKING_SCREEN, Screens.MENTAL_SCREEN);
        Screens.BANKING_SCREEN.setChilds(Screens.EXPENSES_SCREEN, Screens.INCOME_SCREEN);
        Screens.EXPENSES_SCREEN.setChilds(Screens.ADD_EXPENSES_SCREEN);
        Screens.INCOME_SCREEN.setChilds(Screens.ADD_INCOME_SCREEN);
        Screens.MENTAL_SCREEN.setChilds(Screens.MENTAL_STATE_SCREEN, Screens.MENTAL_VENT_SCREEN);
        Screens.ANIME_SCREEN.setChilds(Screens.ANIME_VIEW_SCREEN, Screens.MANGA_SCREEN);
    }

    public ModeSwitcher getSwitch() {
        return switcher;
    }
}
