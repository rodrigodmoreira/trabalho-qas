package repositories;

import model.CompatibilityTool;

import java.util.ArrayList;

public class CompatibilityToolRepository extends GenericRepository<CompatibilityTool> {
    private static CompatibilityToolRepository singletonRepository = null;
    private CompatibilityToolRepository() {}

    public static CompatibilityToolRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new CompatibilityToolRepository();
        return singletonRepository;
    }

    public static ArrayList<CompatibilityTool> filter(String name) {
        ArrayList<CompatibilityTool> results = new ArrayList<>();

        for(CompatibilityTool compatibilityTool: getInstance().entities) {
            if (compatibilityTool.getName().contains(name)) {
                results.add(compatibilityTool);
            }
        }

        return results;
    }
}
