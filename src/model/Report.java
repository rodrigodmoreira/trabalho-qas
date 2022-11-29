package model;

public class Report extends Content {
    private String text;
    private float compatibilityRating;
    private float compatibilityTool;
    private Platform platform;

    public Report(String title, String text, Platform platform, User owner) {
        super(title, owner);
        this.text = text;
        this.compatibilityRating = 0f;
        this.compatibilityTool = 0f;
        this.platform = platform;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getCompatibilityRating() {
        return compatibilityRating;
    }

    public void setCompatibilityRating(float compatibilityRating) {
        this.compatibilityRating = compatibilityRating;
    }

    public float getCompatibilityTool() {
        return compatibilityTool;
    }

    public void setCompatibilityTool(float compatibilityTool) {
        this.compatibilityTool = compatibilityTool;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
