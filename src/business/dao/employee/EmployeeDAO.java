package business.dao.employee;

import business.dao.BaseDAO;
import business.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends BaseDAO<Employee> {
    Optional<Employee> findById(String employeeId);
    List<Employee> findByNameAndAge(String name, int minAge, int maxAge);
    List<Employee> getPerPage(int pageNumber);
}