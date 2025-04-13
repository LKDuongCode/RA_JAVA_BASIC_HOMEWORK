package utils;

import business.model.employee.Employee;
import business.model.employee.EmployeeStatus;
import business.model.employee.Gender;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EmployeeUtils {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final ValidateEmployee validateEmployee = new ValidateEmployee();

    public void printAllEmployees(Scanner sc) {
        int page = 1;
        boolean back = false;

        while (!back) {
            List<Employee> employees = employeeService.getPerPage(page);

            System.out.println("\nDanh sách nhân viên - Trang " + page);
            if (employees.isEmpty()) {
                System.out.println("Không có nhân viên nào ở trang này.");
            } else {
                employees.forEach(System.out::println);
            }

            System.out.println("\n1. Chuyển đến trang khác");
            System.out.println("0. Quay lại");

            int choice = ValidateInput.validateInt(sc);
            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập số trang: ");
                    int newPage = ValidateInput.validateInt(sc);
                    if (newPage <= 0) {
                        System.out.println("Trang không hợp lệ.");
                    } else {
                        page = newPage;
                    }
                }
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public void insertEmployee(Scanner sc) {
        System.out.println("Nhập thông tin nhân viên mới:");

        System.out.print("ID (ví dụ: E0001): ");
        String id = validateEmployee.validateEmployeeId(sc);

        System.out.print("Tên: ");
        String name = ValidateInput.validateString(sc, "Tên", 15, 150);

        System.out.print("Email: ");
        String email = validateEmployee.validateEmail(sc);

        System.out.print("Số điện thoại: ");
        String phone = validateEmployee.validatePhone(sc);

        Gender gender = ValidateInput.validateEnum(sc, Gender.class);

        System.out.print("Bậc lương: ");
        int level = validateEmployee.validateLevelSalary(sc);

        System.out.print("Lương: ");
        double salary = validateEmployee.validateSalary(sc);

        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        LocalDate dob = ValidateInput.validateLocalDate(sc);

        System.out.print("Địa chỉ: ");
        String address = sc.nextLine().trim();

        System.out.print("ID phòng ban: ");
        int departmentId = ValidateInput.validateInt(sc);

        EmployeeStatus status = ValidateInput.validateEnum(sc, EmployeeStatus.class);

        Employee e = new Employee(id, name, email, phone, level, gender, salary, address, dob, departmentId, status);
        boolean result = employeeService.insert(e);

        if (result)
            System.out.println("Thêm nhân viên thành công.");
        else
            System.out.println("Thêm nhân viên thất bại.");
    }

    public void updateEmployee(Scanner sc) {
        System.out.println("Nhập ID nhân viên cần cập nhật:");
        String id = sc.nextLine().trim();

        Optional<Employee> found = employeeService.findById(id);
        if (found.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên.");
            return;
        }

        Employee e = found.get();
        boolean back = false;

        while (!back) {
            System.out.println("\n== Cập nhật nhân viên: " + e.getEmployeeName() + " ==");
            System.out.println("1. Tên: " + e.getEmployeeName());
            System.out.println("2. Email: " + e.getEmail());
            System.out.println("3. Số điện thoại: " + e.getPhone());
            System.out.println("4. Bậc lương: " + e.getLevelSalary());
            System.out.println("5. Lương: " + e.getSalary());
            System.out.println("6. Địa chỉ: " + e.getAddress());
            System.out.println("7. Trạng thái: " + e.getStatus());
            System.out.println("0. Quay lại");
            System.out.print("Chọn thuộc tính cần cập nhật: ");

            int choice = ValidateInput.validateInt(sc);
            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập tên mới: ");
                    String newName = ValidateInput.validateString(sc, "Tên", 15, 150);
                    e.setEmployeeName(newName);
                }
                case 2 -> {
                    System.out.print("Nhập email mới: ");
                    String newEmail = new ValidateEmployee().validateEmail(sc);
                    e.setEmail(newEmail);
                }
                case 3 -> {
                    System.out.print("Nhập số điện thoại mới: ");
                    String newPhone = new ValidateEmployee().validatePhone(sc);
                    e.setPhone(newPhone);
                }
                case 4 -> {
                    System.out.print("Nhập bậc lương mới: ");
                    int level = new ValidateEmployee().validateLevelSalary(sc);
                    e.setLevelSalary(level);
                }
                case 5 -> {
                    System.out.print("Nhập lương mới: ");
                    double salary = new ValidateEmployee().validateSalary(sc);
                    e.setSalary(salary);
                }
                case 6 -> {
                    System.out.print("Nhập địa chỉ mới: ");
                    String address = sc.nextLine().trim();
                    e.setAddress(address);
                }
                case 7 -> {
                    System.out.print("Nhập trạng thái mới: ");
                    EmployeeStatus status = ValidateInput.validateEnum(sc, EmployeeStatus.class);
                    e.setStatus(status);
                }
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }

            boolean result = employeeService.update(e);
            if (result) {
                System.out.println("Cập nhật thành công.");
            } else {
                System.out.println("Cập nhật thất bại.");
            }
        }
    }


    public void deleteEmployee(Scanner sc) {
        System.out.println("Nhập ID nhân viên cần xoá:");
        String id = sc.nextLine().trim();

        Optional<Employee> found = employeeService.findById(id);
        if (found.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên.");
            return;
        }

        while (true) {
            System.out.println("Bạn có chắc muốn xoá? (y/n)");
            String choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                boolean result = employeeService.delete(found.get());
                System.out.println(result
                        ? "Đã xoá thành công."
                        : "Xoá thất bại.");
                break;
            }
            if (choice.equals("n")) {
                System.out.println("Đã huỷ xoá.");
                break;
            }
            System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    public void findEmployeeByNameAndAge(Scanner sc) {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        String name = sc.nextLine().trim();

        System.out.print("Tuổi nhỏ nhất: ");
        int minAge = ValidateInput.validateInt(sc);

        System.out.print("Tuổi lớn nhất: ");
        int maxAge = ValidateInput.validateInt(sc);

        List<Employee> result = employeeService.findByNameAndAge(name, minAge, maxAge);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy nhân viên phù hợp.");
            return;
        }

        System.out.println("Danh sách nhân viên:");
        result.forEach(System.out::println);
    }
}