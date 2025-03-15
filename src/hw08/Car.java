package hw08;

public abstract class Car implements Refuelable {
     String model;
     int year;
     double price;

    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract void start();
    public abstract void stop();

    @Override
    public abstract void refuel();
}
