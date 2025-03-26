package hw08;

import java.util.List;
import java.util.function.Predicate;

public interface ListProcessor {
    int sumOddNumbers (List<Integer> nums);
    static void printList(List<Integer> nums){
        nums.forEach(num -> System.out.printf("%d ",num));
    }
    default boolean checkOdd(List<Integer> nums){
        Predicate<Integer> checking = (num) -> num % 2 != 0;
        for (int num : nums){
            if(checking.test(num)){
                return true;
            }
        }
        return false;
    }
}
