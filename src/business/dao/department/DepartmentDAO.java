package business.dao.department;

import business.dao.BaseDAO;
import business.model.department.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentDAO extends BaseDAO<Department> {
    List<Department> departmentCurPage (int pageNumber);
    List<Department> findDepartmentByName (String name);
    Optional<Department> findById (int id);
}
