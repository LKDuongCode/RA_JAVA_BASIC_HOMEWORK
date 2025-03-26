package hw06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("Alice", "Andrew", "Bob", "Anna", "Charles"));
        System.out.println(strs);

        StringProcessor toUpperStrs = ( str) -> str.toUpperCase() + " - TECHNICAL" ;
        List<String> result = new ArrayList<>();
        strs.forEach(str -> {
            result.add(toUpperStrs.processString(str));
        });
        toUpperStrs.printList(result);

    }
}
