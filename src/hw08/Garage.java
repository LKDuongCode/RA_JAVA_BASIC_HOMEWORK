package hw08;

public class Garage {
    private Car[] cars;
    private int count;

    public Garage(int capacity) {
        cars = new Car[capacity];
        count = 0;
    }

    public void addCar(Car car) {
        if (count < cars.length) {
            cars[count] = car;
            count++;
        } else {
            System.out.println("full");
        }
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            cars[i].start();
            cars[i].stop();
            cars[i].refuel();
            System.out.println();
        }
    }
}


