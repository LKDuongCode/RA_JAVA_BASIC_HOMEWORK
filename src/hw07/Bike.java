package hw07;

public class Bike extends Vehicle{
    public Bike (String name){
        super(name);
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
