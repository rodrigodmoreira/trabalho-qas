package repositories;

import java.util.ArrayList;

public abstract class GenericRepository<T> {
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

    public boolean remove(T entity) {
        entities.remove(entity);
        return true;
    }

}
