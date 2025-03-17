package hw06;

public class PartTimeEmployee extends Employee {
    double hour;

    public PartTimeEmployee (String name, int age, double basicSalary, double hour){
        super(name, age, basicSalary);
        this.hour = hour;
    }

    @Override
    public double calSalary(){
        return this.hour * this.basicSalary;
    }

    @Override
    public void showInfo (){
        System.out.println("name: " + this.name);
        System.out.println("age: " + this.age);
        System.out.println("basicSalary: " + this.basicSalary);
        System.out.println("salary: " + calSalary());
    }
}
