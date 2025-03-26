import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Hw05 {
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>(Arrays.asList("Alice", "Andrew", "Bob", "Anna", "Charles"));
        System.out.println(strs);

        Predicate<String> checking = (str) -> Pattern.matches("^A\\w+",str) && str.length() >= 5;

        int count = 0;
        for (String str: strs){
            if(checking.test(str)){
                count++;
            }
        }

        System.out.println(count);
    }
}
