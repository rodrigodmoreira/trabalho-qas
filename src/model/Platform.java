package model;

public class Platform extends Entity {
    private String name;

    public Platform(String name, User owner) {
        super(owner);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
