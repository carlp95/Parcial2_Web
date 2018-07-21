package dao;

import entities.Post;

import javax.persistence.*;
import java.util.List;

public class PostDAO implements DAO<Post, Long> {
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
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Post.class, id);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public void update(Post entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw  e;
        } finally {
            em.close();
        }
    }

    @Override
    public void remove(Post entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
            throw  ex;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Post> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return null;
    }
}
