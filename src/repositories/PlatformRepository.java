package repositories;

import model.CompatibilityTool;
import model.Game;
import model.Platform;

import java.util.ArrayList;

public class PlatformRepository extends GenericRepository<Platform> {
    private static PlatformRepository singletonRepository = null;
    private PlatformRepository() {}

    public static PlatformRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new PlatformRepository();
        return singletonRepository;
    }

    public static ArrayList<Platform> filter(String name) {
        ArrayList<Platform> results = new ArrayList<>();

        for(Platform platform: getInstance().entities) {
            if (platform.getName().contains(name)) {
                results.add(platform);
            }
        }

        return results;
    }
}