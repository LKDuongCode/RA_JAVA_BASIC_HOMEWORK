package hw03;

import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập a");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("nhập b");
        int b = Integer.parseInt(sc.nextLine());

        Connect add = (x,y) -> MathOperations.add(x,y); // tương đương
        Connect subtract = MathOperations::subtract;
        Connect multiply = MathOperations::multiply;
        Connect divide = MathOperations::divide;

        System.out.println(add.apply(a,b));
        System.out.println(subtract.apply(a,b));
        System.out.println(multiply.apply(a,b));
        System.out.println(divide.apply(a,b));
    }
}
