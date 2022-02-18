package nl.danibaas.dailyhelper.utilities;

import java.util.ArrayList;
import java.util.Arrays;

import nl.danibaas.dailyhelper.R;

public enum Screens {

    LOGIN_SCREEN(R.layout.login_screen, "Login", null),
    MAIN_SCREEN(R.layout.main_screen, "Main", Screens.LOGIN_SCREEN),
    BANKING_SCREEN(R.layout.banking_screen, "Banking", Screens.MAIN_SCREEN),
    EXPENSES_SCREEN(R.layout.banking_expenses_screen, "Expenses", Screens.BANKING_SCREEN),
    ADD_EXPENSES_SCREEN(R.layout.banking_add_expenses_screen, "AddExpenses", Screens.EXPENSES_SCREEN),
    INCOME_SCREEN(R.layout.banking_income_screen, "Income", Screens.BANKING_SCREEN),
    ADD_INCOME_SCREEN(R.layout.banking_add_income_screen, "AddIncome", Screens.INCOME_SCREEN),
    MENTAL_SCREEN(R.layout.mental_screen, "Mental", Screens.MAIN_SCREEN),
    MENTAL_STATE_SCREEN(6, "MentalState", Screens.MENTAL_SCREEN),
    MENTAL_VENT_SCREEN(7, "MentalVent", Screens.MENTAL_SCREEN),
    ANIME_SCREEN(R.layout.anime_screen, "Anime", Screens.MAIN_SCREEN),
    ANIME_VIEW_SCREEN(R.layout.anime_view_screen, "AnimeView", Screens.ANIME_SCREEN),
    MANGA_SCREEN(R.layout.manga_screen, "Manga", Screens.ANIME_SCREEN),
    BOOK_SCREEN(R.layout.books_screen, "Books", Screens.MAIN_SCREEN),
    BOOK_VIEW_SCREEN(R.layout.books_view_screen, "BookView", Screens.BOOK_SCREEN),
    COMICS_SCREEN(R.layout.comics_screen, "Comics", Screens.BOOK_SCREEN),
    BOOK_PLANNING_SCREEN(R.layout.books_planning_screen, "BookPlanning", Screens.BOOK_SCREEN);


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
