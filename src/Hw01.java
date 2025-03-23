import java.util.HashSet;
import java.util.Set;

public class Hw01 {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();

        for(int i = 10; i <= 50; i+=10) {
            numbers.add(i);
        }

        System.out.println(numbers);
    }
}
