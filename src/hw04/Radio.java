package hw04;

public class Radio implements Electronic {
    @Override
    public void turnOn() {
        System.out.println("tunrning on Radio");
    }

    @Override
    public void turnOff() {
        System.out.println("tunrning off Radio");
    }
}
