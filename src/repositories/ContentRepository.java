package repositories;

import model.Content;

import java.util.ArrayList;

public class ContentRepository extends GenericRepository<Content> {
    private static ContentRepository singletonRepository = null;
    private ContentRepository() {}

    public static ContentRepository getInstance() {
        if(singletonRepository == null) singletonRepository = new ContentRepository();
        return singletonRepository;
    }

    public static ArrayList<Content> filter(String title) {
        ArrayList<Content> results = new ArrayList<Content>();

        for(Content content: getInstance().entities) {
            if (content.getTitle().contains(title)) {
                results.add(content);
            }
        }

        return results;
    }
}
