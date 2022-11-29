package model;

public class Report extends Content {
    private String text;
    private float compatibilityRating;
    private Platform platform;

    private Game game;

    public Report(String title, String text, Game game, Platform platform, CompatibilityTool compatibilityTool, User owner) {
        super(title, game, platform, compatibilityTool, owner);
        this.text = text;
        this.compatibilityRating = 0f;
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
}
