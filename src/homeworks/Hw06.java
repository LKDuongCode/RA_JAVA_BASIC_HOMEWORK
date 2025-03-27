package homeworks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Hw06 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> countMaps = new HashMap<>();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String formattedDateTime = now.format(formatter);
        for (String fruit : items) {
            countMaps.put(fruit, countMaps.getOrDefault(fruit, 0) + 1);
        }

        System.out.println(countMaps);
        System.out.println(formattedDateTime);
    }
}
