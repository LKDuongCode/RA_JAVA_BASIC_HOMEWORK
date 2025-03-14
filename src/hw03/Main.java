package hw03;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car("toyota","civic",2000);
        System.out.println("car1 :");
        System.out.println(c1.getMade());
        System.out.println(c1.getModel());
        System.out.println(c1.getYear());

        c1.setMade("gg");
        c1.setModel("vip");
        c1.setYear(2030);
    }
}
