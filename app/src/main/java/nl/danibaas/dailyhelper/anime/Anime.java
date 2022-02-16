package nl.danibaas.dailyhelper.anime;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.Nullable;

import nl.danibaas.dailyhelper.MainActivity;
import nl.danibaas.dailyhelper.R;
import nl.danibaas.dailyhelper.utilities.Screens;

public class Anime {
    public boolean firstTime = true;

    public Anime() {
        enableJavaScript();
    }

    public void loadPage(PageOptions page) {
        enableJavaScript();
        WebView wv = getCorrectWebView();
        if (wv == null) return;
        wv.loadUrl(page.getUrl());
    }

    @Nullable
    private WebView getCorrectWebView() {
        WebView wv = null;
        if (MainActivity.getInstance().screen.getCurrentScreen() == Screens.MANGA_SCREEN) {
            wv = MainActivity.getInstance().findViewById(R.id.MangaList);
        } else if (MainActivity.getInstance().screen.getCurrentScreen() == Screens.ANIME_VIEW_SCREEN) {
            wv = MainActivity.getInstance().findViewById(R.id.AnimeList);
        }
        return wv;
    }

    private boolean canEnableJavaScript() {
        WebView wv = MainActivity.getInstance().findViewById(R.id.AnimeList);
        WebView wv2 = MainActivity.getInstance().findViewById(R.id.MangaList);
        return wv != null || wv2 != null;
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void enableJavaScript() {
        if (canEnableJavaScript()) {
            int[] ids = {R.id.AnimeList, R.id.MangaList};
            for (int i : ids) {
                WebView view = ((WebView) MainActivity.getInstance().findViewById(i));
                if (view == null) continue;
                WebSettings wv = view.getSettings();
                wv.setJavaScriptEnabled(true);
                wv.setJavaScriptCanOpenWindowsAutomatically(true);
                wv.setAllowContentAccess(true);
                wv.setAllowFileAccess(true);
                wv.setDomStorageEnabled(true);
            }

        }
    }
}
