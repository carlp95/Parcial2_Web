package dao;

import entities.Post;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PostDAO implements Dao<Post, Long> {
    EntityManagerFactory emf;

    public PostDAO() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("Persistence");
        }
    }

    @Override
    public void persist(Post entity) {

    }

    @Override
    public Post find(Long id) {
        return null;
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void remove(Post entity) {

    }

    @Override
    public List<Post> findAll() {
        return null;
    }
}
