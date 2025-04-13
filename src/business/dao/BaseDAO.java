package business.dao;

import java.util.List;

public interface BaseDAO<T> {
     List<T> getAll ();
     boolean insert (T t);
     boolean update (T t);
     boolean delete (T t);
}
