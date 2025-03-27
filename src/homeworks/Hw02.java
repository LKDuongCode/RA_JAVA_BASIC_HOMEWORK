package homeworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hw02 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int result = numbers.stream()
                .filter(num -> num % 2 != 0)
                .reduce(0,(sum,num)-> sum+=num);
        System.out.println(result);
    }
}
