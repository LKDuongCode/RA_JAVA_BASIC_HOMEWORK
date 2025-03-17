package hw09;



public class Bike extends Vehicle {
    public enum FuelType {
        GASOLINE,
        DIESEL,
        ELECTRIC;
    }

    double maxSpeed;
    FuelType fuleltype;

    public Bike (double maxSpeed, FuelType fuleltype){
        this.maxSpeed = maxSpeed;
        this.fuleltype =fuleltype;
    }

    @Override
    public void sound (){
        System.out.println("Honk honk");
    }

    @Override
    public void move (){
        System.out.println("move normally");
    }
}


