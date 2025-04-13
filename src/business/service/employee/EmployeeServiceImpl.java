package business.service.employee;

import business.dao.employee.EmployeeDAO;
import business.dao.employee.EmployeeDAOImpl;
import business.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    public boolean insert(Employee employee) {
        return employeeDAO.insert(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeeDAO.delete(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public Optional<Employee> findById(String employeeId) {
        return employeeDAO.findById(employeeId);
    }

    @Override
    public List<Employee> findByNameAndAge(String name, int minAge, int maxAge) {
        return employeeDAO.findByNameAndAge(name, minAge, maxAge);
    }

    @Override
    public List<Employee> getPerPage(int pageNumber) {
        return employeeDAO.getPerPage(pageNumber);
    }
}