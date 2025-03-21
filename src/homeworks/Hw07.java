package homeworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hw07 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>() ;

        for(int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        numbers.add(1);

        List<Integer> uniqueNum = new ArrayList<>();

        for (int num : numbers) {
            if (Collections.frequency(numbers, num) == 1) {
                uniqueNum.add(num);
            }
        }

        System.out.println(uniqueNum);
    }
}
