package business.dao.employee;

import business.config.DatabaseConnection;
import business.model.employee.Employee;
import business.model.employee.EmployeeStatus;
import business.model.employee.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call get_all_employee()}")
        ) {
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSet(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insert(Employee e) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call insert_employee(?,?,?,?,?,?,?,?,?,?,?)}")
        ) {
            cs.setString(1, e.getEmployeeId());
            cs.setString(2, e.getEmployeeName());
            cs.setString(3, e.getEmail());
            cs.setString(4, e.getPhone());
            cs.setString(5, e.getGender().name());
            cs.setInt(6, e.getLevelSalary());
            cs.setDouble(7, e.getSalary());
            cs.setDate(8, Date.valueOf(e.getDob()));
            cs.setString(9, e.getAddress());
            cs.setInt(10, e.getDepartmentId());
            cs.setString(11, e.getStatus().name());

            return cs.executeUpdate() > 0;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Employee e) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call update_employee(?,?,?,?,?,?,?,?,?,?,?)}")
        ) {
            cs.setString(1, e.getEmployeeId());
            cs.setString(2, e.getEmployeeName());
            cs.setString(3, e.getEmail());
            cs.setString(4, e.getPhone());
            cs.setString(5, e.getGender().name());
            cs.setInt(6, e.getLevelSalary());
            cs.setDouble(7, e.getSalary());
            cs.setDate(8, Date.valueOf(e.getDob()));
            cs.setString(9, e.getAddress());
            cs.setInt(10, e.getDepartmentId());
            cs.setString(11, e.getStatus().name());

            return cs.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Employee e) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call delete_employee(?)}")
        ) {
            cs.setString(1, e.getEmployeeId());
            return cs.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<Employee> findById(String employeeId) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call find_employee_by_id(?)}")
        ) {
            cs.setString(1, employeeId);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSet(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> findByNameAndAge(String name, int minAge, int maxAge) {
        List<Employee> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call find_employee_by_name_and_age_range(?,?,?)}")
        ) {
            cs.setString(1, name);
            cs.setInt(2, minAge);
            cs.setInt(3, maxAge);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSet(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Employee> getPerPage(int pageNumber) {
        List<Employee> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement cs = c.prepareCall("{call get_employee_per_page(?,?)}")
        ) {
            cs.setInt(1, 5); // number per page
            cs.setInt(2, pageNumber);
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSet(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Employee mapResultSet(ResultSet rs) throws SQLException {
        Employee e = new Employee();
        e.setEmployeeId(rs.getString("employeeId"));
        e.setEmployeeName(rs.getString("employeeName"));
        e.setEmail(rs.getString("email"));
        e.setPhone(rs.getString("phone"));
        e.setGender(Gender.valueOf(rs.getString("gender")));
        e.setLevelSalary(rs.getInt("levelSalary"));
        e.setSalary(rs.getDouble("salary"));
        e.setDob(rs.getDate("dob").toLocalDate());
        e.setAddress(rs.getString("address"));
        e.setDepartmentId(rs.getInt("departmentId"));
        e.setStatus(EmployeeStatus.valueOf(rs.getString("status")));
        return e;
    }
}