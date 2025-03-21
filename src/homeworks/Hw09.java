package homeworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Nhập size = ");
        int size = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < size; i++) {
            System.out.printf("numbers[%d] = ", i);
            int value = Integer.parseInt(sc.nextLine());
            numbers.add(value);
        }

        List<Integer> primes = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int num : numbers) {
            boolean isPrime = isPrimeNumber(num);

            if (isPrime && !primes.contains(num)) {
                primes.add(num);
            }

            else if (!isPrime) {
                if (num % 2 == 0 && !evens.contains(num)) {
                    evens.add(num);
                } else if (num % 2 != 0 && !odds.contains(num)) {
                    odds.add(num);
                }
            }
        }

        System.out.println("Primes = " + primes);
        System.out.println("Evens = " + evens);
        System.out.println("Odds = " + odds);
    }

    public static boolean isPrimeNumber(int num) {
        if (num < 2) return false;
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
