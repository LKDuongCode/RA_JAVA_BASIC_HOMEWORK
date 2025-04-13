package business.service.statistic;

import java.util.Map;

public interface StatisticService {
    int getTotalEmployee();
    Map<String, Integer> getEmployeeCountPerDepartment();
    String getDepartmentWithMostEmployees();
    String getDepartmentWithHighestAverageSalary();
}
