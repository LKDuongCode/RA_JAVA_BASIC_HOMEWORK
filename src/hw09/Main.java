package hw09;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];
        int curIdx = 0;

        vehicles[curIdx++] = new Car(200);
        vehicles[curIdx++] = new Bike(200, Bike.FuelType.GASOLINE);
        vehicles[curIdx++] = new Airplane(600,"A123");
        vehicles[curIdx++] = new Bus(32,10);

        for(int i = 0; i < curIdx; i++) {
            double time = i+1;
            double speed = (i+1)*20;
            vehicles[i].move();
            vehicles[i].sound();
            System.out.println(vehicles[i].move(time,speed) + " km");
            System.out.println();
        }

    }
}
