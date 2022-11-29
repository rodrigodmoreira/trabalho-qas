package repositories;

import model.User;

import java.util.ArrayList;

public class UserRepository extends GenericRepository<User> {
    private static UserRepository singletonRepository = null;
    private UserRepository() {}

    public static UserRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new UserRepository();
        return singletonRepository;
    }

    public static ArrayList<User> filter(String username) {
        ArrayList<User> results = new ArrayList<User>();

        for(User user: getInstance().entities) {
            if (user.getUsername().contains(username)) {
                results.add(user);
            }
        }

        return results;
    }
}