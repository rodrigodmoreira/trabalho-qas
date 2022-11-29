package repositories;

import model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository extends GenericRepository<Game>{
    private static GameRepository singletonRepository = null;
    private GameRepository() {}

    public static GameRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new GameRepository();
        return singletonRepository;
    }

    public ArrayList<Game> filter(String name) {
        PermissionManager permissionManager = PermissionManager.getInstance();
        List<Game> filteredList = entities.stream().filter(
            (game) -> game.getName().contains(name)
        ).toList();

        return new ArrayList<>(filteredList);
    }
}
