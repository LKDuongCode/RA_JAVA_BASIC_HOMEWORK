package hw07;

public class Car extends Vehicle{
    public Car (String name){
        super(name);
    }

    @Override
    public void move(){
        System.out.println("move faster");
    }

    @Override
    public void sound (){
        System.out.println("Vroom");
    }
}
