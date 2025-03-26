package hw07;

import java.util.List;

public interface ListProcessor {
    boolean containsNegative(List<Integer> nums);
    static void printList(List<Integer> nums){
        nums.forEach(num -> System.out.printf("%d ",num));
    }
}
