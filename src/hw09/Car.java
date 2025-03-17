package hw09;

public class Car extends Vehicle {
    int horsePower;

    public Car (int horsePower){
        this.horsePower = horsePower;
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
