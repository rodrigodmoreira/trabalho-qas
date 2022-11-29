package repositories;

import model.Entity;
import model.User;

public class PermissionManager {

    public static boolean checkOwnership(User currentUser, Entity resource) {
        return resource.getOwner() != null && resource.getOwner().getId() == currentUser.getId() || currentUser.getRole().isAdmin();
    }
}
