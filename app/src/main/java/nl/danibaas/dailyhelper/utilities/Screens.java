package nl.danibaas.dailyhelper.utilities;

import nl.danibaas.dailyhelper.R;

import java.util.ArrayList;
import java.util.Arrays;

public enum Screens {

    MAIN_SCREEN(R.layout.main_screen, "Main", null),
    BANKING_SCREEN(R.layout.banking_screen, "Banking", Screens.MAIN_SCREEN),
    EXPENSES_SCREEN(R.layout.banking_expenses_screen, "Expenses", Screens.BANKING_SCREEN),
    INCOME_SCREEN(4, "Income", Screens.BANKING_SCREEN), // TODO: replace 4 with layout of income screen
    WEIGHT_SCREEN(5, "Weight", Screens.MAIN_SCREEN);

    private final int id;
    private final String name;
    private final Screens parent;
    private final ArrayList<Screens> childs = new ArrayList<>();

    Screens(int id, String name, Screens parent, Screens... child) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        childs.addAll(Arrays.asList(child));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Screens get(int i) {
        for (Screens s : values()) {
            if (s.id == i) {
                return s;
            }
        }
        return null;
    }

    public Screens get(String name) {
        for (Screens s : values()) {
            if (s.name.equals(name)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Screens> getChilds() {
        return childs;
    }

    public Screens getParent() {
        return parent;
    }

    public void setChilds(Screens... childs) {
        this.childs.addAll(Arrays.asList(childs));
    }
}
