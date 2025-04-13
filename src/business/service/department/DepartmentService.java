package business.service.department;

import business.dao.BaseDAO;
import business.model.department.Department;
import business.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface DepartmentService extends BaseService<Department> {
    List<Department> findDepartmentByName(String name);
    List<Department> getDepartmentsByPage(int pageNumber);
    Optional<Department> findById (int id);
}
