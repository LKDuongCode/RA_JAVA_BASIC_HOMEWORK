package hw09;

public class Employee {
    protected String name;
    protected String id;
    protected double salary;
    
    public Employee() {
        this.name = "default";
        this.id = "default";
        this.salary = 0;
    }
    
    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double amount) {
        if (amount > 0) {
            this.salary += amount;
            System.out.println("Lương của " + name + " đã tăng thêm " + amount);
        } else {
            System.out.println(" Số tiền tăng lương phải lớn hơn 0!");
        }
    }

    @Override
    public String toString() {
        return "Employee | Tên: " + name + " | Mã: " + id + " | Lương: " + salary;
    }
}
