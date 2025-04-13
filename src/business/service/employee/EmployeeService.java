package business.service.employee;


import business.model.employee.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService extends business.service.BaseService<Employee> {
    Optional<Employee> findById(String employeeId);
    List<Employee> findByNameAndAge(String name, int minAge, int maxAge);
    List<Employee> getPerPage(int pageNumber);
}
