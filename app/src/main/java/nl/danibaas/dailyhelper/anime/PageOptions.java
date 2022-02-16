package nl.danibaas.dailyhelper.anime;

public enum PageOptions {

    ANIME("https://anilist.co/user/Stomar/animelist/"),
    ANIME_HOME("https://anilist.co/home"),
    ANIME_LOGIN("https://anilist.co/login"),
    ANIME_WATCHING("https://anilist.co/user/Stomar/animelist/Watching"),
    ANIME_COMPLETED("https://anilist.co/user/Stomar/animelist/Completed"),
    ANIME_DROPPED("https://anilist.co/user/Stomar/animelist/Dropped"),
    ANIME_PLANNING("https://anilist.co/user/Stomar/animelist/Planning"),
    MANGA("https://anilist.co/user/Stomar/mangalist/"),
    MANGA_READING("https://anilist.co/user/Stomar/mangalist/Reading"),
    MANGA_COMPLETED("https://anilist.co/user/Stomar/mangalist/Completed"),
    MANGA_PLANNING("https://anilist.co/user/Stomar/mangalist/Planning");

    final String url;

    PageOptions(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
