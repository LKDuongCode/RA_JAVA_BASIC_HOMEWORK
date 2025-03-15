package hw06;

public class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println(name + "Roar!");
    }

    @Override
    public void move() {
        System.out.println(name + " The lion is running.");
    }
}
