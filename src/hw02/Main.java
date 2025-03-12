package hw02;

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng Employee với thông tin mẫu
        Employee emp = new Employee(1, "John Doe", "IT", 5000);

        // Hiển thị thông tin nhân viên
        emp.displayInfo();

        // Tăng lương nhân viên lên 10%
        emp.increaseSalary(10);

        // Hiển thị mức lương sau khi tăng
        System.out.println("Updated Salary: " + emp.getSalary());
    }
}
