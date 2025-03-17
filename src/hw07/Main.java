package hw07;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];
        int curIdx = 0;

        vehicles[curIdx++] = new Car("car");
        vehicles[curIdx++] = new Bike("bike");
        vehicles[curIdx++] = new Bus("bus");

        for(int i = 0; i < curIdx; i++) {
            System.out.println(vehicles[i].name);
            vehicles[i].move();
            vehicles[i].sound();
            System.out.println();
        }
    }
}
