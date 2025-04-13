package business.service;
import java.util.List;
import java.util.Optional;

public interface BaseService <T> {
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
    List<T> getAll ();
}
