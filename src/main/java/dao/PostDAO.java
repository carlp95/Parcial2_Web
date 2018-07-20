package dao;

import entities.Post;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
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
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (IllegalArgumentException iae) {
            System.out.println("The instance" + iae.toString() + "is not an entity. "+ iae.getMessage());
        } catch (EntityExistsException eee) {
            System.out.println("The entity is already persisted. " + eee.getMessage());
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw  e;
        } finally {
            em.close();
        }

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
