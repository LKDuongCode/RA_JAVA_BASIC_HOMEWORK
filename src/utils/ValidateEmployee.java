package utils;

import business.model.employee.Employee;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateEmployee {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    public String validateEmployeeId(Scanner sc) {
        List<Employee> existing = employeeService.getAll();
        Pattern pattern = Pattern.compile("^E\\d{4}$");

        while (true) {
            try {
                String id = ValidateInput.validateString(sc, "mã nhân viên", 5, 5);

                if (!pattern.matcher(id).matches()) {
                    throw new IllegalArgumentException("Mã nhân viên phải có định dạng E1234.");
                }

                boolean isExist = existing.stream().anyMatch(e -> e.getEmployeeId().equalsIgnoreCase(id));
                if (isExist) {
                    throw new IllegalArgumentException("Mã nhân viên đã tồn tại.");
                }

                return id;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String validateEmail(Scanner sc) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        while (true) {
            try {
                String email = sc.nextLine().trim();

                if (!pattern.matcher(email).matches()) {
                    throw new IllegalArgumentException("Email không hợp lệ.");
                }

                return email;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String validatePhone(Scanner sc) {
        Pattern pattern = Pattern.compile("^0[35789]\\d{8}$");

        while (true) {
            try {
                String phone = sc.nextLine().trim();

                if (!pattern.matcher(phone).matches()) {
                    throw new IllegalArgumentException("Số điện thoại phải đúng định dạng di động Việt Nam.");
                }

                return phone;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public int validateLevelSalary(Scanner sc) {
        while (true) {
            int level = ValidateInput.validateInt(sc);
            if (level <= 0) {
                System.err.println("Bậc lương phải lớn hơn 0.");
            } else {
                return level;
            }
        }
    }

    public double validateSalary(Scanner sc) {
        while (true) {
            double salary = ValidateInput.validateDouble(sc);
            if (salary <= 0) {
                System.err.println("Lương phải lớn hơn 0.");
            } else {
                return salary;
            }
        }
    }
}
