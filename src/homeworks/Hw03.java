package homeworks;

import java.util.ArrayList;
import java.util.List;

public class Hw03 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        int min = numbers.get(0);
        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
