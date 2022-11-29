package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game extends Entity {
    private String name;
    private Platform platform;

    public Game(String name, Platform platform, User owner) {
        super(owner);
        this.name = name;
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
