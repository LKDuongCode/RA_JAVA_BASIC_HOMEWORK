package hw07;

public class Bus extends Vehicle{
    public Bus (String name){
        super(name);
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
