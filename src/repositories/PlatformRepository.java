package repositories;

import model.Platform;

import java.util.ArrayList;
import java.util.List;

public class PlatformRepository extends GenericRepository<Platform> {
    private static PlatformRepository singletonRepository = null;
    private PlatformRepository() {}

    public static PlatformRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new PlatformRepository();
        return singletonRepository;
    }

    public ArrayList<Platform> filter(String name) {

        List<Platform> filteredList = getInstance().entities.stream().filter(
                (platform) -> platform.getName().contains(name)
        ).toList();

        return new ArrayList<>(filteredList);
    }
}