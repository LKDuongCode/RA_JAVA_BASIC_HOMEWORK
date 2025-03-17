package hw06;

public class Employee {
    String name;
    int age;
    double basicSalary;

    public Employee (String name, int age, double basicSalary){
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
    }

    public double calSalary (){
        return this.basicSalary;
    }

    public void showInfo (){
        System.out.println("name: " + this.name);
        System.out.println("age: " + this.age);
        System.out.println("basicSalary: " + this.basicSalary);
    }
}
