package business.dao.statistics;

import java.util.Map;

public interface EmployeeStatisticDAO {
    int getTotalEmployee();
    Map<String, Integer> getEmployeeCountPerDepartment();
    String getDepartmentWithMostEmployees();
    String getDepartmentWithHighestAverageSalary();
}