package model;

import java.util.ArrayList;

public class Role {
    private String name;
    private ArrayList<OpCode> permissions;

    public Role(String name, ArrayList<OpCode> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public boolean hasPermission(OpCode operation) {
        return permissions.contains(operation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<OpCode> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<OpCode> permissions) {
        this.permissions = permissions;
    }
}
