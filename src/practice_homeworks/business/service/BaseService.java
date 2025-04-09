package practice_homeworks.business.service;

import java.util.List;

public interface BaseService<T, ID> {
    List<T> getAll();
    T getById(ID id);
    boolean create(T entity);
    boolean update(T entity);
    boolean delete(ID id);
}
