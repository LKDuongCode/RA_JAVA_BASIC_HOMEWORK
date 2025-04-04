package homeworks.hw02;

public class Main {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.createAnimal("dog");
        Animal cat = AnimalFactory.createAnimal("cat");

        dog.speak();
        cat.speak();
    }
}
