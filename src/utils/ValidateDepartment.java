package utils;

import business.model.department.Department;
import business.service.department.DepartmentService;
import business.service.department.DepartmentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ValidateDepartment {
    private final DepartmentService departmentService = new DepartmentServiceImpl();

    public String validateDepartmentName (Scanner sc){
        List<Department> curDepartment = departmentService.getAll();

        while (true){
            try {
                String s = ValidateInput.validateString(sc,"tên phòng ban",1,100);

                boolean isExist = curDepartment.stream().anyMatch(d -> d.getDepartmentName().equalsIgnoreCase(s));
                if(isExist){
                    throw new IllegalArgumentException("tên phòng ban đã được sử dụng.");
                }

                return s;
            }
            catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
