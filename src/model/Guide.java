package model;

import java.util.ArrayList;

public class Guide extends Content {
    private ArrayList<Page> pages;

    public Guide(String title, Game game, Platform platform, CompatibilityTool compatibilityTool, ArrayList<Page> pages, User owner) {
        super(title, game, platform, compatibilityTool, owner);
        this.platform = platform;
        this.pages = pages;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }
}
