package model;

public abstract class Content extends Entity {
    protected String title;

    protected Game game;
    protected Platform platform;
    private CompatibilityTool compatibilityTool;

    public Content(String title, Game game, Platform platform, CompatibilityTool compatibilityTool, User owner) {
        super(owner);
        this.title = title;
        this.game = game;
        this.platform = platform;
        this.compatibilityTool = compatibilityTool;
    }

    public String getTitle() {
        return title;
    }
    public Game getGame() { return game; }
    public Platform getPlatform() { return platform; }
    public CompatibilityTool getCompatibilityTool() { return compatibilityTool; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setGame(Game game) { this.game = game; }
    public void setPlatform(Platform platform) { this.platform = platform; }
    public void setCompatibilityTool(CompatibilityTool compatibilityTool) { this.compatibilityTool = compatibilityTool; }
}
