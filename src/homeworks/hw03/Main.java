package homeworks.hw03;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder()
                .setEngine("V6")
                .setSeats(4)
                .setColor("Black")
                .build();

        Car car2 = new Car.CarBuilder()
                .setEngine("Electric")
                .setSeats(2)
                .setColor("White")
                .build();

        System.out.println(car1);
        System.out.println(car2);
    }
}
