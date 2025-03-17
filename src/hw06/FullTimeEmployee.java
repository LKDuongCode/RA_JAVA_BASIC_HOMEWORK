package hw06;

public class FullTimeEmployee extends Employee {
    public FullTimeEmployee (String name, int age, double basicSalary){
        super(name,age,basicSalary);
    }

    @Override
    public double calSalary(){
        return (this.basicSalary*8) + 500;
    }

    @Override
    public void showInfo (){
        System.out.println("name: " + this.name);
        System.out.println("age: " + this.age);
        System.out.println("basicSalary: " + this.basicSalary);
        System.out.println("salary: " + calSalary());
    }
}
