package hw09;

public class Airplane extends Vehicle{
    double altitude;
    String flightNumber;

    public Airplane (double altitude, String flightNumber){
        this.altitude = altitude;
        this.flightNumber = flightNumber;
    }

    @Override
    public void sound (){
        System.out.println("Whoosh Whoosh");
    }

    @Override
    public void move (){
        System.out.println("move super fast");
    }
}
