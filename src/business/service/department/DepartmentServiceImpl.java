package business.service.department;

import business.dao.department.DepartmentDAO;
import business.dao.department.DepartmentDAOImpl;
import business.model.department.Department;

import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentDAO departmentDAO = new DepartmentDAOImpl();


    @Override
    public boolean insert(Department department) {
        return departmentDAO.insert(department);
    }

    @Override
    public boolean update(Department department) {
        return departmentDAO.update(department);
    }

    @Override
    public boolean delete(Department department) {
        return departmentDAO.delete(department);
    }

    @Override
    public List<Department> getAll (){
        return departmentDAO.getAll();
    }

    @Override
    public List<Department> findDepartmentByName(String name) {
        return departmentDAO.findDepartmentByName(name);
    }

    @Override
    public List<Department> getDepartmentsByPage(int pageNumber) {
        return departmentDAO.departmentCurPage(pageNumber);
    }

    @Override
    public Optional<Department> findById(int id) {
        return departmentDAO.findById(id);
    }
}
