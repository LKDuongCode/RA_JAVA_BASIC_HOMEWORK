package hw03;

public class Car extends Vehicle{

    Car (String name, int speed){
        super(name,speed);
    }

    @Override
    void displayInfo (){
        System.out.println("Car:" + this.name + " | " + this.speed );
    }

}
