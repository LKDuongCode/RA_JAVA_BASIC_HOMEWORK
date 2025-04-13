package utils;
import business.model.department.Department;
import business.service.department.DepartmentService;
import business.service.department.DepartmentServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DepartmentUtils {
    private final DepartmentService departmentService = new DepartmentServiceImpl();
    private final ValidateDepartment validateDepartment = new ValidateDepartment();

    public void printAllDepartment(Scanner sc) {
        int page = 1;
        boolean back = false;

        while (!back) {
            List<Department> departments = departmentService.getDepartmentsByPage(page);

            System.out.println("\nDanh sách phòng ban - Trang " + page);

            if (departments.isEmpty()) {
                System.out.println("Không có phòng ban nào ở trang này.");
            } else {
                departments.forEach(System.out::println);
            }

            System.out.println("\n1. Chuyển đến trang khác");
            System.out.println("0. Quay lại menu chính");

            int choice = ValidateInput.validateInt(sc);
            switch (choice) {
                case 1:
                    System.out.print("Nhập số trang muốn xem: ");
                    page = ValidateInput.validateInt(sc);
                    if(page <=0){
                        System.out.println("trang không hợp lệ!");
                        break;
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default : System.out.println("Lựa chọn không hợp lệ."); break;
            }
        }
    }


    public void insertDepartment (Scanner sc){
        System.out.println("nhập thông tin phòng ban mới: ");
        System.out.println("nhập tên phòng ban: ");
        String name = validateDepartment.validateDepartmentName(sc);
        System.out.println("nhập mô tả: ");
        String des = ValidateInput.validateString(sc,"mô tả phòng ban",1,255);

        Department d = new Department();
        d.inputDepartment(name,des);
        boolean result = departmentService.insert(d);
        if (result) System.out.println("\u001B[32m thêm mới thành công.\u001B[0m");

        if(!result) System.out.println("\u001B[31m thêm mới thất bại.\u001B[0m");

    }

    public void updateDepartment (Scanner sc){
        System.out.println("nhập id phòng ban cần sửa: ");
        int id = ValidateInput.validateInt(sc);
        Optional<Department> found = departmentService.findById(id);
        if(found.isEmpty()){
            System.err.println("phòng ban không tồn tại.");
            return;
        }

        Department d = found.get();

        boolean back = false;
        while (!back){
            System.out.println("chỉnh sửa thông tin phòng ban: ");
            System.out.println("1.tên: " + d.getDepartmentName());
            System.out.println("2. mô tả: " + d.getDescription());
            System.out.println("3. trạng thái: " + (d.isStatus()? "hoạt động" : "không hoạt động"));
            System.out.println("4. quay lại.");
            System.out.println("sửa phần nào?");

            int choice = ValidateInput.validateInt(sc);

            switch (choice){
                case 1:
                    System.out.println("nhập tên mới:");
                    d.setDepartmentName(validateDepartment.validateDepartmentName(sc));
                    break;
                case 2:
                    System.out.println("nhập mô tả mới:");
                    d.setDescription(ValidateInput.validateString(sc,"mô tả phòng ban",1,255));
                    break;
                case 3:
                    System.out.println("nhập trạng thái mới:");
                    d.setStatus(ValidateInput.validateBoolean(sc));
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("chọn không hợp lệ!");
                    break;
            }

            departmentService.update(d);
            System.out.println("\u001B[32m cập nhật thành công.\u001B[0m");
        }
    }

    public void deleteDepartment (Scanner sc){
        System.out.println("nhập id phòng ban cần xóa: ");
        int id = ValidateInput.validateInt(sc);

        Optional<Department> found = departmentService.findById(id);
        if(found.isEmpty()){
            System.err.println("phòng ban không tồn tại.");
            return;
        }

        while(true){
            System.out.println("bạn có chắc muốn xóa? (y/n)");
            String choice = ValidateInput.validateString(sc,"lựa chọn",1,1);

            if(choice.equalsIgnoreCase("y")) {
                departmentService.delete(found.get());
                System.out.println("\u001B[32m xóa thành công.\u001B[0m");
                break;
            }

            if(choice.equalsIgnoreCase("n")){
                System.out.println("hủy xóa!");
                break;
            }

            System.out.println("không hợp lệ!");
        }
    }

    public void findDepartmentByName (Scanner sc){
        System.out.println("nhập tên phòng ban cần tìm: ");
        String name = sc.nextLine();

        List<Department> founds = departmentService.findDepartmentByName(name);
        if(founds.isEmpty()){
            System.err.println("phòng ban không tồn tại.");
            return;
        }

        founds.forEach(System.out::println);
    }
}
