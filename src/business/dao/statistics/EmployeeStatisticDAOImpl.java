package business.dao.statistics;

import business.config.DatabaseConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class EmployeeStatisticDAOImpl implements EmployeeStatisticDAO {

    @Override
    public int getTotalEmployee() {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call get_total_employee_count()}")
        ) {
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt("totalEmployee");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Map<String, Integer> getEmployeeCountPerDepartment() {
        Map<String, Integer> result = new HashMap<>();
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call get_employee_count_by_department()}")
        ) {
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                String deptName = rs.getString("departmentName");
                int count = rs.getInt("employeeCount");
                result.put(deptName, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getDepartmentWithMostEmployees() {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call get_department_with_most_employees()}")
        ) {
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getString("departmentName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Không xác định";
    }

    @Override
    public String getDepartmentWithHighestAverageSalary() {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call get_department_with_highest_avg_salary()}")
        ) {
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getString("departmentName");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Không xác định";
    }
}
