package model;

import java.util.ArrayList;

public class Guide extends Content {
    private Platform platform;
    private float compatibilityTool;
    private ArrayList<Page> pages;

    public Guide(String title, Platform platform, float compatibilityTool, ArrayList<Page> pages, User owner) {
        super(title, owner);
        this.platform = platform;
        this.compatibilityTool = compatibilityTool;
        this.pages = pages;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public float getCompatibilityTool() {
        return compatibilityTool;
    }

    public void setCompatibilityTool(float compatibilityTool) {
        this.compatibilityTool = compatibilityTool;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }
}
