package hw08;

public class Main {
    public static void main(String[] args) {
        Animals[] animalList = new Animals[10];
        int curIndex = 0;

        animalList[curIndex++] = new Dog("Buddy", 3, "Golden Retriever");
        animalList[curIndex++] = new Cat("Whiskers", 2, "Black");
        animalList[curIndex++] = new Dog("Charlie", 4, "Bulldog");
        animalList[curIndex++] = new Cat("Luna", 1, "White");
        animalList[curIndex++] = new Dog("Rocky", 5, "German Shepherd");

        System.out.println("== Danh sách động vật ==");
        for (int i = 0; i < curIndex; i++) {
            animalList[i].displayInfo();
            System.out.println("sound : " + animalList[i].makeSound());
            System.out.println("--------------------------");
        }
    }
}
