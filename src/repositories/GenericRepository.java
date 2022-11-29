package repositories;

import model.Entity;
import model.User;

import java.util.ArrayList;

public abstract class GenericRepository<T extends Entity> {
    protected ArrayList<T> entities = new ArrayList<>();

    public boolean add(T entity) {
        entities.add(entity);
        return true;
    }

    public T get(int id) {
        return entities.get(id);
    }

    public ArrayList<T> get() {
        return entities;
    }

    public boolean remove(int id, User currentUser) {
        entities.removeIf((entity) -> entity.getId() == id && PermissionManager.checkOwnership(currentUser, entity));
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
