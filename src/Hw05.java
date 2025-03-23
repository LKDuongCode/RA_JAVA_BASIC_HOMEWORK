import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hw05 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        for (int num : set2){
            if(!set1.contains(num)){
                set1.add(num);
            }
        }

        // cách 2
        // set1.addAll(set2);

        System.out.println(set1);
    }
}
