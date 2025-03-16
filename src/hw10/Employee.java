package hw10;

public abstract class Employee {
     String name;
     double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();
    public abstract void takeVacation();
}
