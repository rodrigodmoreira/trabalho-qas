package repositories;

import model.Entity;
import model.OpCode;
import model.Role;
import model.User;

public class PermissionManager {
    private static PermissionManager singletonRepository = null;

    public static PermissionManager getInstance() {
        if(singletonRepository == null) singletonRepository = new PermissionManager();
        return singletonRepository;
    }

    public boolean checkUserPermission(Role currentRole, OpCode operationCode) {
        return currentRole.hasPermission(operationCode);
    }

    public boolean checkOwnership(User currentUser, Entity resource) {
        return resource.getOwner() != null && resource.getOwner().getId() == currentUser.getId();
    }
}
