package practice_homeworks.business.dao;

import java.util.List;

public interface BaseDAO<T,ID> {
    List<T> findAll ();
    T findById (ID id);
    void insert(T element);
    void update (T element);
    void delete (ID id);
}
