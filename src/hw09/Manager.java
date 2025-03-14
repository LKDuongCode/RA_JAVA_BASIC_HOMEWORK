package hw09;

public class Manager extends Employee {
    private double bonus;

    public Manager() {
        super();
        this.bonus = 0;
    }

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return salary + bonus;
    }

    @Override
    public String toString() {
        return "Manager | Tên: " + name + " | Mã: " + id + " | Lương cơ bản: " + salary + " | Thưởng: " + bonus + " | Tổng lương: " + getSalary();
    }
}
