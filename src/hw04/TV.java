package hw04;

public class TV implements Electronic {
    @Override
    public void turnOn(){
        System.out.println("turning on TV");
    }

    @Override
    public void turnOff(){
        System.out.println("turning off TV");
    }
}
