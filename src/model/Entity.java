package model;

public abstract class Entity {
    protected static int _id = 0;

    protected int id;
    protected User owner;

    public Entity(User owner) {
        this.id = Entity._id++;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
