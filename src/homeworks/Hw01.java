package homeworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Hw01 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        numbers.stream()
                .filter(num -> num % 2 == 0).forEach(num -> System.out.println(num));
    }
}
