package nl.danibaas.dailyhelper;

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

    public void fixChildren() {
        Screens.MAIN_SCREEN.setChilds(Screens.BANKING_SCREEN, Screens.WEIGHT_SCREEN);
        Screens.BANKING_SCREEN.setChilds(Screens.EXPENSES_SCREEN, Screens.INCOME_SCREEN);
    }

    public ModeSwitcher getSwitch() {
        return switcher;
    }
}
