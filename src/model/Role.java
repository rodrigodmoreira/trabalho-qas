package model;

public class Role {
    private String name;

    private boolean isAdmin;

    public Role(String name) {
        this.name = name;
        this.isAdmin = false;
    }

    public Role(String name, boolean isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() { return isAdmin; }
}
