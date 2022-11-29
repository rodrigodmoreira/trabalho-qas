import model.*;
import repositories.*;

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
        roleAdmin = new Role("Admin", true);
        roleUser = new Role("End-User");

        compatibilityToolRepository = CompatibilityToolRepository.getInstance();
        contentRepository = ContentRepository.getInstance();
        gameRepository = GameRepository.getInstance();
        platformRepository = PlatformRepository.getInstance();
        userRepository = UserRepository.getInstance();
    }

    public static void createMockData() throws Exception {
        User userAdmin = new User("superadmin", "admin@honestguides.com", "Sup3rS3cretP@ssw0rd", roleAdmin, null);
        userRepository.add(userAdmin, userAdmin);
        userRepository.add(new User("anaverageuser", "averageuser@averageemail.com", "@v3r@g3p@ssw0rd", roleUser, null), userAdmin);

        Platform platformWindows = new Platform("Windows10_x64", userAdmin);
        platformRepository.add(platformWindows, userAdmin);
        platformRepository.add(new Platform("Linux_x64", userAdmin), userAdmin);

        compatibilityToolRepository.add(new CompatibilityTool("Proton", userAdmin), userAdmin);
        compatibilityToolRepository.add(new CompatibilityTool("DXVK", userAdmin), userAdmin);

        gameRepository.add(new Game("DefenseOfTheYouth", platformWindows, userAdmin), userAdmin);
        gameRepository.add(new Game("GodOfPeace", platformWindows, userAdmin), userAdmin);
        gameRepository.add(new Game("LeagueOfOrdinaries", platformWindows, userAdmin), userAdmin);
        gameRepository.add(new Game("AgeOfVillages", platformWindows, userAdmin), userAdmin);
    }

    private static void printPadded(String str) {
        System.out.println("\n".concat(String.format("%-100s", str).replace(' ', '-')).concat("\n"));
    }

    public static void simulateAccess() throws Exception {
        currentUser = userRepository.login("anaverageuser", "@v3r@g3p@ssw0rd");
        if(currentUser == null) throw new Exception("Invalid username / password");
        printPadded("Exemplo_0-Login_bem_sucedido");


        printPadded("Exemplo_1-Filtrar_jogos_contendo_'ges'_no_título");
        gameRepository.filter("ges").forEach((game -> System.out.println(game.getName())));


        printPadded("Exemplo_2-Adicionar_novo_relatório");
        contentRepository.add(new Report(
            "Real performance are the friends we made along the way",
            "D.O.N.T. B.U.Y. I.T.\n\n...awful perfomance issues",
            gameRepository.filter("GodOfPeace").stream().findFirst().get(),
            platformRepository.filter("Linux_x64").stream().findFirst().get(),
            compatibilityToolRepository.filter("DXVK").stream().findFirst().get(),
            currentUser
        ), currentUser);
        System.out.println(
            ((Report)contentRepository.filter(currentUser)
                .stream()
                .findFirst()
                .get()
            ).getText()
        );


        printPadded("Exemplo_2.1-Editar_relatório");
        boolean editDone = contentRepository.edit(
            contentRepository.filter("Real performance are the friends we made along the way")
                .stream()
                .findFirst()
                .get()
                .getId(), // fetch correct content somehow (here first from listing title is enough)
            new Report(
                "Maybe it's not that bad",
                "After DXVK update, thing's got better. Noice\n⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⣿⣿⣿⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠸⣿⣿⣿⠀⠙⠻⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⢹⣿⣿⠀⠀⠀⠈⠙⠷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀\n⠀⠀⠹⣿⠀⠀⠀⠀⠀⠀⠈⠙⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⡤⠶⣶⣿⣿⣿⠃\n⠀⠀⠀⠹⣯⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⡶⠞⠛⠉⠁⠀⠀⣿⣿⣿⠃⠀\n⠀⠀⠀⠀⠹⣯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⠶⠞⠋⠉⠀⠀⠀⠀⠀⠀⠀⣸⣿⡿⠃⠀⠀\n⠀⠀⠀⠀⠀⠘⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠓⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠒⠲⠶⠤⢤⠶⠚⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠟⠁⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠈⢻⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⣰⡿⠋⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠹⣦⣀⣴⠟⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⡿⠓⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡀⠀⠀⣠⡶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠁⠀⠀⠀⠀⣀⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣶⠞⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⢀⣾⠁⠀⠀⠀⠀⣼⡏⣹⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡶⢶⣶⡄⠀⠀⠀⠀⠀⠀⢹⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠀⣸⠃⠀⠀⠀⠀⠀⢻⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⣾⣿⡿⠀⠀⠀⠀⠀⠀⠀⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⢰⡏⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⣤⣀⣀⠀⠀⠀⠀⠀⠀⠘⠻⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠘⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⣾⢠⣴⣿⣿⣶⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠛⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⡇⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣶⡀⠀⠀⠸⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⣧⠈⠻⠿⠿⠟⠋⠀⠀⠀⠀⠀⠀⠀⢀⣾⠟⠋⠉⠙⠻⣦⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⡇⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣇⠀⠀ ⠀⠀⠀  ⣿⠀⠀⠀⠀⠀⠀⠀⠙⠿⠿⠿⠿⠛⠀⠀⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⠀⠀⠀⠀⠘⣷⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠷⣤⣀⣠⣴⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀",
                gameRepository.filter("GodOfPeace").stream().findFirst().get(),
                platformRepository.filter("Linux_x64").stream().findFirst().get(),
                compatibilityToolRepository.filter("DXVK").stream().findFirst().get(),
                currentUser
            ),
            currentUser
        );
        if(!editDone) {
            throw new Exception("Unauthorized edit");
        } else {
            System.out.println(
                ((Report)contentRepository.filter("Maybe it's not that bad")
                    .stream()
                    .findFirst()
                    .get()
                ).getText()
            );
        }

        printPadded("Exemplo_3-Remover_relatório");
        contentRepository.remove(
                contentRepository.filter("Maybe it's not that bad")
                        .stream()
                        .findFirst()
                        .get()
                        .getId(), // fetch correct content somehow (here first from listing title is enough)
                currentUser
        );
        System.out.println(contentRepository.filter("Maybe it's not that bad")
                .stream()
                .findFirst()
                .get()  );
    }

    public static void main(String[] args) {
        createSystemResources();

        try {
            createMockData();
            simulateAccess();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
