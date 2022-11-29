package model;

public abstract class Content extends Entity {
    protected String title;

    public Content(String title, User owner) {
        super(owner);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
