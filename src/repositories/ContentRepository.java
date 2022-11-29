package repositories;

import model.Content;
import model.User;

import java.util.ArrayList;

public class ContentRepository extends GenericRepository<Content> {
    private static ContentRepository singletonRepository = null;
    private ContentRepository() {}

    public static ContentRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new ContentRepository();
        return singletonRepository;
    }

    // Overriding method since every user can create contents
    public boolean add(Content entity, User currentUser) {
        entities.add(entity);
        return true;
    }

    public ArrayList<Content> filter(String title) {
        ArrayList<Content> results = new ArrayList<>();

        for(Content content : getInstance().entities) {
            if (content.getTitle().contains(title)) {
                results.add(content);
            }
        }

        return results;
    }

    public ArrayList<Content> filter(User owner) {
        ArrayList<Content> results = new ArrayList<>();

        for(Content content: getInstance().entities) {
            if (content.getOwner() == owner) {
                results.add(content);
            }
        }

        return results;
    }

    @Override
    public boolean edit(int id, Content newEntity, User issuer) {
        int i = 0;
        for (Content entity: entities) {
            if (entity.getId() == id && (entity.getOwner() == issuer || issuer.getRole().isAdmin())) {
                entities.set(i, newEntity);
                return true;
            }
        }
        return false;
    }
}
