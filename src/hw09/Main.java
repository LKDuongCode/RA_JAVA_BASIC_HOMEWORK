package hw09;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        int curIdx = 0;

        employees[curIdx++] = new Employee("Nguyen Van A", "E001", 5000);
        employees[curIdx++] = new Manager("Tran Thi B", "M002", 7000, 2000);
        employees[curIdx++] = new Developer("Le Van C", "D003", 6000, "Java");

        System.out.println("Danh sách nv ==");
        for (int i = 0; i < curIdx; i++) {
            System.out.println(employees[i].toString());
        }

        System.out.println("\nLương nv ==");
        for (int i = 0; i < curIdx; i++) {
            System.out.println(employees[i].name + " có tổng lương: " + employees[i].getSalary());
        }

        System.out.println("\n== Tăng lương nv ==");
        employees[0].increaseSalary(1000);
        System.out.println(employees[0].toString());
    }
}
