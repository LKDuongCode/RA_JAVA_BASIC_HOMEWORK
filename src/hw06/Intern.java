package hw06;

public class Intern extends Employee {
    public Intern (String name, int age, double basicSalary){
        super(name, age, basicSalary);
    }

    @Override
    public double calSalary(){
        return this.basicSalary;
    }

    @Override
    public void showInfo (){
        System.out.println("name: " + this.name);
        System.out.println("age: " + this.age);
        System.out.println("basicSalary: " + this.basicSalary);
        System.out.println("salary: " + this.basicSalary);
    }
}
