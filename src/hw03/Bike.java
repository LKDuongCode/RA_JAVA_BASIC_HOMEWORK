package hw03;

public class Bike extends Vehicle {
    Bike (String name, int speed){
        super(name,speed);
    }

    @Override
    void displayInfo (){
        System.out.println("Bike:" + this.name + " | " + this.speed );
    }
}
