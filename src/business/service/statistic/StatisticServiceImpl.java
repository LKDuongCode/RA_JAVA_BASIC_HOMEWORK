package business.service.statistic;

import business.dao.statistics.EmployeeStatisticDAO;
import business.dao.statistics.EmployeeStatisticDAOImpl;

import java.util.Map;

public class StatisticServiceImpl implements StatisticService {

    private final EmployeeStatisticDAO dao = new EmployeeStatisticDAOImpl();

    @Override
    public int getTotalEmployee() {
        return dao.getTotalEmployee();
    }

    @Override
    public Map<String, Integer> getEmployeeCountPerDepartment() {
        return dao.getEmployeeCountPerDepartment();
    }

    @Override
    public String getDepartmentWithMostEmployees() {
        return dao.getDepartmentWithMostEmployees();
    }

    @Override
    public String getDepartmentWithHighestAverageSalary() {
        return dao.getDepartmentWithHighestAverageSalary();
    }
}
