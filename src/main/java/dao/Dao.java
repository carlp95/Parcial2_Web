package dao;

import java.util.List;

public interface Dao<T, K> {
    void persist(T entity);
    T find(K id);
    void update(T entity);
    void remove(T entity);
    List<T> findAll();
}
