package model;

public class Page extends Entity {
    private String text;

    public Page(String text, User owner) {
        super(owner);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
