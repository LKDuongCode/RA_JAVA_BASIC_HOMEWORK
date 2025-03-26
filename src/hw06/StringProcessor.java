package hw06;

import java.util.Iterator;
import java.util.List;

public interface StringProcessor {
    String processString (String input);
    default void printList (List<String> strs) {
        strs.forEach(str -> System.out.println(str));
    }
}
