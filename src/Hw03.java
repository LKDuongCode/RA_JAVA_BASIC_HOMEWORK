import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hw03 {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        Iterator<Integer> it = numbers.iterator();

        while(it.hasNext() ){
            if(it.next() % 2 == 0){
                it.remove();
            }
        }


        System.out.println(numbers);
    }
}
