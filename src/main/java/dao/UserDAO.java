package dao;

import entities.User;

import javax.persistence.*;
import java.util.List;

public class UserDAO implements Dao<User, String> {
    private EntityManagerFactory emf;

    public UserDAO() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("Persistence");
        }
    }

    @Override
    public void persist(User entity) {
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
    public User find(String username) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(User.class, username);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public void update(User entity) {
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
    public void remove(User entity) {
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
    public List<User> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery("select u from User u", User.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
        return null;
    }
}
