package hw09;

public abstract class Vehicle {
    public void move(){
        System.out.println("vehicle moving");
    }

    public void sound(){
        System.out.println("vehicle sound");
    }

    public double move (double time, double speed){
        return speed * time;
    }
}
