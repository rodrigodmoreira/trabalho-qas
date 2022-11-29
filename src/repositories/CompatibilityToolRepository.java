package repositories;

import model.CompatibilityTool;

import java.util.ArrayList;
import java.util.List;

public class CompatibilityToolRepository extends GenericRepository<CompatibilityTool> {
    private static CompatibilityToolRepository singletonRepository = null;
    private CompatibilityToolRepository() {}

    public static CompatibilityToolRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new CompatibilityToolRepository();
        return singletonRepository;
    }

    public ArrayList<CompatibilityTool> filter(String name) {
        List<CompatibilityTool> filteredList = getInstance().entities.stream().filter(
                (compatibilityTool) -> compatibilityTool.getName().contains(name)
        ).toList();

        return new ArrayList<>(filteredList);
    }
}
