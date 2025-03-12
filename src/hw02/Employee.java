package hw02;


public class Employee {
    // Xác định các thuộc tính cơ bản: id, name, department, salary.
     int id;
     String name;
     String department;
     double salary;

    // Viết constructor có tham số để khởi tạo thông tin nhân viên.
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Viết phương thức hiển thị thông tin nhân viên bao gồm: mã, tên và phòng ban.
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
    }

    //Viết getter và setter cho thuộc tính salary để thay đổi lương nếu cần.
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Viết phương thức để tăng lương nhân viên dựa trên phần trăm(percentage) nhập vào.
    public void increaseSalary(double percentage) {
        this.salary += this.salary * (percentage / 100);
    }
}
