import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

public class Hw01 {
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>(Arrays.asList("Java", "", "Lambda", "Stream", "", "Functional"));
        System.out.println(strs);
        filterEmptyString(strs);
        System.out.println(strs);

    }

    public static void filterEmptyString (ArrayList<String> strs){
        Predicate<String> isEmpty = str -> str.trim().isEmpty();
        Iterator<String> it = strs.iterator();
        while(it.hasNext()){
            if(isEmpty.test(it.next())){
                it.remove();
            }
        }

        //c2
//        strs.removeIf(str -> isEmpty.test(str));
    }
}
