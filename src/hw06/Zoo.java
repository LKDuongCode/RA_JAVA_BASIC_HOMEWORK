package hw06;

public class Zoo {
     Animal[] animals;
     int count;

    public Zoo(int capacity) {
        animals = new Animal[capacity];
        count = 0;
    }

    public void addAnimal(Animal animal) {
        if (count < animals.length) {
            animals[count] = animal;
            count++;
        } else {
            System.out.println("full");
        }
    }

}
