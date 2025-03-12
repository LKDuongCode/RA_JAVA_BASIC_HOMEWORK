package hw02;

public class Main {
    public static void main(String[] args) {
        // Viết đoạn mã trong hàm main để tạo đối tượng nhân viên(Employment) và thực hiện các thao tác: hiển thị thông tin, tăng lương.
        Employee emp = new Employee(1, "John Doe", "IT", 5000);

        emp.displayInfo();
        emp.increaseSalary(10);
        System.out.println("Updated Salary: " + emp.getSalary());
    }
}
