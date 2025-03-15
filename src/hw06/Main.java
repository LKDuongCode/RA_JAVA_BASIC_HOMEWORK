package hw06;

public class Main {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo(3);

        Lion lion1 = new Lion("Simba", 5);
        Elephant elephant1 = new Elephant("Dumbo", 10);
        Lion lion2 = new Lion("Mufasa", 8);

        myZoo.addAnimal(lion1);
        myZoo.addAnimal(elephant1);
        myZoo.addAnimal(lion2);

        for (int i = 0; i < myZoo.count; i++) {
            myZoo.animals[i].sound();
            myZoo.animals[i].move();
            System.out.println();
        }
    }
}
