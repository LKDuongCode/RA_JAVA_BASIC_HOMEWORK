package homeworks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hw05 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        List<Integer> counted = new ArrayList<>();

        for (int num : numbers) {
            if (!counted.contains(num)) {
                int count = Collections.frequency(numbers, num);
                System.out.println(num + "- " + count + " lần.");
                counted.add(num);
            }
        }
    }
}
