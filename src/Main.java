import model.*;
import repositories.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static CompatibilityToolRepository compatibilityToolRepository;
    private static ContentRepository contentRepository;
    private static GameRepository gameRepository;
    private static PlatformRepository platformRepository;
    private static UserRepository userRepository;
    private static Role roleAdmin;
    private static Role roleUser;
    private static User currentUser;
    public static void createSystemResources() {
        roleAdmin = new Role("Admin", new ArrayList<>(Arrays.asList(OpCode.values())));
        roleUser = new Role("End-User", new ArrayList<>(Arrays.asList(
            OpCode.ADD_CONTENT,
            OpCode.LIST_CONTENT,
            OpCode.REMOVE_CONTENT,
            OpCode.ADD_GAME,
            OpCode.LIST_GAME,
            OpCode.REMOVE_GAME
        )));

        compatibilityToolRepository = CompatibilityToolRepository.getInstance();
        contentRepository = ContentRepository.getInstance();
        gameRepository = GameRepository.getInstance();
        platformRepository = PlatformRepository.getInstance();
        userRepository = UserRepository.getInstance();
    }

    public static void createMockData() {
        User userAdmin = new User("superadmin", "admin@honestguides.com", "Sup3rS3cretP@ssw0rd", roleAdmin, null);
        userRepository.add(userAdmin);
        Platform platformWindows = new Platform("WIN10_X64", userAdmin);
        platformRepository.add(platformWindows);

        gameRepository.add(new Game("DefenseOfTheYouth", platformWindows, userAdmin));
        gameRepository.add(new Game("GodOfPeace", platformWindows, userAdmin));
        gameRepository.add(new Game("LeagueOfOrdinaries", platformWindows, userAdmin));
        gameRepository.add(new Game("AgeOfVillages", platformWindows, userAdmin));
    }

    public static void simulateAccess() throws Exception {
        currentUser = new User("superadmin", "admin@honestguides.com", "Sup3rS3cretP@ssw0rd", roleAdmin, null);
        OpCode desiredOperation = OpCode.LIST_GAME;

//        GenericRepository operationRepository = desiredOperation.getRepository();
//        operationMapping.put(OpCode.ADD_GAME, gameRepository.add);

        gameRepository.filter("ges").forEach((game -> System.out.println(game.getName())));

        if (!currentUser.getRole().hasPermission(desiredOperation)) {
            throw new Exception("Unauthorized");
        }
    }

    public static void main(String[] args) {
        createSystemResources();
        createMockData();

        try {
            simulateAccess();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
