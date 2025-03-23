import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hw06 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30, 40));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(30, 40, 50, 60));

//        set1.retainAll(set2);

        // cách 2:
        Iterator<Integer> result = set1.iterator();

        while(result.hasNext()){
            if(!set2.contains(result.next())){
                result.remove();
            }
        }

        System.out.println(set1);
    }
}
