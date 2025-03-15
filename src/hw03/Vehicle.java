package hw03;

public abstract class Vehicle {
    String name;
    int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    abstract void displayInfo();

    void start(){
        System.out.println("Vehicle is starting...");
    }
}
