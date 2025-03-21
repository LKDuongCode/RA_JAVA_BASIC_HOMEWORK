package homeworks;

import java.util.ArrayList;
import java.util.List;

public class Hw04 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        System.out.println(sum);
    }
}
