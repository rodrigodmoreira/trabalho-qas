package repositories;

import model.Entity;
import model.User;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericRepository<T extends Entity> {
    protected ArrayList<T> entities = new ArrayList<>();

    public boolean add(T entity, User currentUser) throws Exception {
        if(!currentUser.getRole().isAdmin()) throw new Exception("Unauthorized");
        entities.add(entity);
        return true;
    }

    public T get(int id) {
        return entities.stream()
            .filter(entity -> entity.getId() == id)
            .findAny()
            .orElse(null);
    }

    public ArrayList<T> get() {
        return entities;
    }

    public boolean remove(int id, User currentUser) throws Exception {
        final T match = this.get(id);

        if(match == null) throw new Exception("Entity not found for removal");
        if(!PermissionManager.checkOwnership(currentUser, match)) throw new Exception("Unauthorized");

        entities.remove(match);
        return true;
    }

    public boolean edit(int id, T newEntity, User issuer) {
        int i = 0;
        for (T entity: entities) {
            if (entity.getId() == id && entity.getOwner() == issuer) {
                entities.set(i, newEntity);
                return true;
            }
        }
        return false;
    }
}
