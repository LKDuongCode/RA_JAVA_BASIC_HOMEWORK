package hw03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangle obj = new Rectangle();

        double len = Double.parseDouble(sc.nextLine());
        double wid = Double.parseDouble(sc.nextLine());

        Rectangle obj2 = new Rectangle(len,wid);

        obj.display();
        System.out.println("----");
        obj2.display();
    }
}
