package hw09;

public class Bus extends Vehicle {
    int seats;
    double ticketPrice;

    public Bus (int seats, double ticketPrice){
        this.seats = seats;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void move (){
        System.out.println("move slower ");
    }

    @Override
    public void sound (){
        System.out.println("Ring Ring");
    }
}
