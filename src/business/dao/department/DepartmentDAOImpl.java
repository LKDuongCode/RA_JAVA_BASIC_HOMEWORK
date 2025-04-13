package business.dao.department;

import business.config.DatabaseConnection;
import business.model.department.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentDAOImpl implements DepartmentDAO{
    @Override
    public boolean insert(Department department) {
        try (
                Connection connection = DatabaseConnection.connectToDB();
                CallableStatement callableStatement = connection.prepareCall("{call insert_department (?,?)}")){

            callableStatement.setString(1,department.getDepartmentName());
            callableStatement.setString(2,department.getDescription());

            int rowsAffected = callableStatement.executeUpdate();

            return rowsAffected > 0;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Department department) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement call = c.prepareCall("{call update_department (?,?,?,?)}")
                ){
            call.setInt(1, department.getDepartmentId());
            call.setString(2, department.getDepartmentName() );
            call.setString(3, department.getDescription() );
            call.setBoolean(4,department.isStatus());

            int rowsAffected = call.executeUpdate();
            return rowsAffected > 0;

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Department department) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement call = c.prepareCall("{call delete_department (?)}")
                ){
            call.setInt(1, department.getDepartmentId());

            int rowsAffected = call.executeUpdate();

            return rowsAffected > 0;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Department> getAll (){
        List<Department> departments = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement call = c.prepareCall("{call get_all_department ()}");
                ){

            try (ResultSet rs = call.executeQuery()){
                while(rs.next()){
                    Department d = new Department();
                    d.setDepartmentId(rs.getInt("departmentId"));
                    d.setDepartmentName(rs.getString("departmentName"));
                    d.setDescription(rs.getString("description"));
                    d.setStatus(rs.getBoolean("status"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public List<Department> findDepartmentByName(String name) {
        List<Department> departments = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement call = c.prepareCall("{call find_department_by_name (?)}")
                ){
            call.setString(1,name);

            try (ResultSet rs = call.executeQuery()){
                while (rs.next()) {
                    Department d = new Department();
                    d.setDepartmentId(rs.getInt("departmentId"));
                    d.setDepartmentName(rs.getString("departmentName"));
                    d.setDescription(rs.getString("description"));
                    d.setStatus(rs.getBoolean("status"));

                    departments.add(d);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public List<Department> departmentCurPage(int pageNumber) {
        List<Department> departments = new ArrayList<>();

        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement call = c.prepareCall("{call get_department_per_page (?,?)}")
                ){

            call.setInt(1,5);
            call.setInt(2,pageNumber);

            try (ResultSet rs = call.executeQuery()){
                while (rs.next()){
                    Department d = new Department();
                    d.setDepartmentId(rs.getInt("departmentId"));
                    d.setDepartmentName(rs.getString("departmentName"));
                    d.setDescription(rs.getString("description"));
                    d.setStatus(rs.getBoolean("status"));

                    departments.add(d);
                }
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public Optional<Department> findById(int id) {
        try (
                Connection c = DatabaseConnection.connectToDB();
                CallableStatement call = c.prepareCall("{call find_department_by_id (?)}")
                ){
            call.setInt(1,id);

            try (ResultSet rs = call.executeQuery()) {
                if(rs.next()){
                    Department d = new Department();
                    d.setDepartmentId(rs.getInt("departmentId"));
                    d.setDepartmentName(rs.getString("departmentName"));
                    d.setDescription(rs.getString("description"));
                    d.setStatus(rs.getBoolean("status"));
                 return Optional.of(d);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
