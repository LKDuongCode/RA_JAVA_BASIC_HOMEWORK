package hw07;

import java.util.List;
import java.util.function.Predicate;

public class ListProcessorImpl implements ListProcessor{
    @Override
    public boolean containsNegative(List<Integer> nums){
        Predicate<Integer> checking = (num)-> num < 0;
        for (int num : nums){
            if(checking.test(num)){
                return true;
            }
        }

        return false;
    }


}
