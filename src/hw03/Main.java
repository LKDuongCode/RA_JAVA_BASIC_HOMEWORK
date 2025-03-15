package hw03;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("carvip",100);
        Bike bike1 = new Bike("bikevip",20);

        car1.displayInfo();
        car1.start();

        bike1.displayInfo();
        bike1.start();
    }
}
