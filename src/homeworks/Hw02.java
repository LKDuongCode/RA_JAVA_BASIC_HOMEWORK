package homeworks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hw02 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num % 3 == 0) {
                iterator.remove();
            }
        }

        System.out.println(numbers);
    }
}
