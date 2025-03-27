package homeworks;

import java.util.List;
import java.util.stream.Collectors;

public class Hw05 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList= List.of(10, 10, 10);

        int result1 = normalList.stream().distinct().sorted().collect(Collectors.toList()).reversed().stream().skip(1).findFirst().get();
        System.out.println(normalList);
        System.out.println(result1);

        // exception
        int result3 = allSameList.stream().distinct().sorted().collect(Collectors.toList()).reversed().stream().skip(1).findFirst().get();
        System.out.println(normalList);
        System.out.println(result3);

        int result2 = singleElementList.stream().distinct().sorted().collect(Collectors.toList()).reversed().stream().skip(1).findFirst().get();
        System.out.println(normalList);
        System.out.println(result2);

    }
}
