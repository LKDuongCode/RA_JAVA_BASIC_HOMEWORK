package homeworks.hw04;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private LocalDate dob;

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }



    int getAge (){
        return  Period.between(dob,LocalDate.now()).getYears();
    }

    void printInfo (){
        System.out.println("name: " + this.name + ", " + "dateBirth: " + this.dob + ", " + "age: " + getAge());
    }
}
