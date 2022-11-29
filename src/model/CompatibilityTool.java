package model;

public class CompatibilityTool extends Entity {
    private String name;

    public CompatibilityTool(String name, User owner){
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
