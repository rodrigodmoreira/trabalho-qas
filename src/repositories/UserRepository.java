package repositories;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends GenericRepository<User> {
    private static UserRepository singletonRepository = null;
    private UserRepository() {}

    public static UserRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new UserRepository();
        return singletonRepository;
    }

    public ArrayList<User> filter(String username) {

        List<User> filteredList = getInstance().entities.stream().filter(
            (user) -> user.getUsername().contains(username)
        ).toList();

        return new ArrayList<>(filteredList);
    }

    public User login(String username, String password) {
        return entities.stream()
            .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
            .findAny()
            .orElse(null);
    }
}