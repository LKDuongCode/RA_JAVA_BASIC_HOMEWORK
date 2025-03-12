package hw04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Circle objDefault = new Circle();

        System.out.print("input radius = ");
        int ctRadius = Integer.parseInt(sc.nextLine());
        Circle objCustom = new Circle(ctRadius);

        objDefault.display();
        System.out.println("----");
        objCustom.display();
    }
}
