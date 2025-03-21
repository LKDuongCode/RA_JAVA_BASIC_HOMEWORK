package homeworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hw06 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);

            if (Collections.frequency(result, current) == 0) {
                result.add(current);
            }
        }
        System.out.println(result);
    }
}
